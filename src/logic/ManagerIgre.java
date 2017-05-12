package logic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class ManagerIgre {
	public static final int BROJ_KARATA_NA_TABLI = 4;
	public static final int BROJ_KARATA_U_RUCI = 6;
	
	private static Spil spil;
	//RoiiTODO : private !
	private static Igrac igrac;
	
	private static boolean igramPrvi;
	private static boolean poslednjiNosio;
	
	private static List<Karta> tabla;
	
	final static boolean DEBUG = true;
	
	static{
		igrac = new Igrac();
		tabla = new ArrayList<>(26);
	}
	
	public static Igrac igrac(){ return igrac;}
	public static List<Karta> tabla(){ return tabla;}
	
	public static void zapocniIgru(){
		Spil s = new Spil();
		
		s.promesaj();
		
		if(DEBUG) System.out.println("Zapocinjanje igre");
		
		List<Karta> prvoNaTabli = s.uzmi(BROJ_KARATA_NA_TABLI);
		List<Karta> mojSpil = new ArrayList<>(28);
		List<Karta> tudjiSpil= new ArrayList<>(28);
		
		prvoNaTabli.stream().map(Karta::clone).forEach(mojSpil::add);
		tudjiSpil.addAll(prvoNaTabli);
		
		mojSpil.addAll(s.uzmi(24));
		tudjiSpil.addAll(s.uzmi(24));
		
		boolean igramPrvi = igrac.getPoeni().size() % 2 == 0;
		
		// test
		igramPrvi = false;
		// test
		zapocniIgru(new Spil(mojSpil), igramPrvi);
		// Robii.TODO
		// KomunikacijaManager.posaljiSpil(new Spil(mojSpil), !igramPrvi);
		
	}
	
	
	public static void zapocniIgru(Spil s, boolean pf){

		if(DEBUG) System.out.println("Dobio sam spil... Igram prvi: "+pf);
		
		igramPrvi = pf;
		spil = s;
		igrac.novaPartija();
		postaviNaTablu();
		novaRuka();
	}
	
	private static void postaviNaTablu() {
		tabla.addAll(spil.uzmi(BROJ_KARATA_NA_TABLI));
		if(DEBUG) stampajTablu();
	}


	private static void stampajTablu() {
		System.out.println("Tabla:");
		tabla.forEach(t -> System.out.print(t+" "));
		System.out.println("-----------");
	}
	private static void stampajRuku() {
		System.out.println("Ruka:");
		igrac.getURuci().forEach(t -> System.out.print(t+" "));
		System.out.println("+++");
	}
	
	public static void novaRuka(){
		List<Karta> r = spil.uzmi(BROJ_KARATA_U_RUCI);
		igrac.dodajURuku(r);
		
		if(DEBUG) stampajRuku();
		
		if(!igramPrvi){
			// wait
		}
	}
	public static void odigraoSam(Karta bacena){
		if(DEBUG) System.out.println("Bacena karta: "+bacena);
		try{
			odigraoSam(bacena, new LinkedList<Karta>());
		} catch (NeMozeSeNositiException e){}
	}
	
	public static void odigraoSam(Karta bacena, List<Karta> nos) throws NeMozeSeNositiException{
		if(!mozeNositi(bacena, nos))
			throw new NeMozeSeNositiException(bacena, nos);

		if(DEBUG) System.out.println("Noseno sa "+bacena+" : "+nos);
		
		List<Karta> nositi = new ArrayList<>(nos);
		boolean pisiTablu = srediTablu(bacena, new ArrayList<>(nos));
		
		if(pisiTablu)
			igrac.tablaZaMene();
		
		// bacena karta

		igrac.baciKartu(bacena);
		if(nositi.size() > 0){
			poslednjiNosio = true;
			// noseno
			List<Karta> uPoene = new ArrayList<>(nositi);
			uPoene.add(bacena);
			igrac.dadajUNosene(uPoene);
			
		}
		
		if(igrac.getURuci().isEmpty() && !igramPrvi){
			checkResult();
		}
	}

	public static void odigraoJe(Karta bacena, List<Karta> nositi){
		boolean pisiTablu = srediTablu(bacena, nositi);
		
		if(pisiTablu)
			igrac.tablaZaProtivnika();
		
		if(!nositi.isEmpty())
			poslednjiNosio = false;
		
		if(igramPrvi)
			checkResult();
	}
	
	private static boolean srediTablu(Karta bacena, List<Karta> nositi) {
			if(nositi.size() == 0){
				tabla.add(bacena);
			} else {
				tabla.removeAll(nositi);
			}
			
			return tabla.isEmpty();
	}


	private static boolean mozeNositi(Karta bacena, List<Karta> nositi) {
		if(nositi.isEmpty())
			return true;
		//Robii.TODO
		// implementirati logiku nosenja
		return true;
	}
	

	private static void checkResult() {
		
		if(DEBUG) System.out.println("Checking rezultat");
		
		if(spil.preostaloKarata()>0){
			novaRuka();
		} else {
			if(poslednjiNosio)
				igrac.dadajUNosene(tabla);
			
			igrac.sracunajPoene();
			
			if(krajIgre()){
				JOptionPane.showMessageDialog(null, "Kraj igre!");
			} else {
				// RobiiTODO
				
				// if I'm a server... 
				zapocniIgru();
			}
		}
	}
	
	private static boolean krajIgre(){
		if(DEBUG) System.out.println("Igra je zavrsena");
		return igrac.getUkupnoPoeni() > 100 || igrac.getUkupnoPoeniProtivnika() > 100;
	}
}
