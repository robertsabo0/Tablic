package logic;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import gui.Frame;
import gui.JTalonPanel;
import komunikacija.KlijentInterfejs;
import komunikacija.MenagerKomunikacije;

public class ManagerIgre {
	public static final int BROJ_KARATA_NA_TABLI = 4;
	public static final int BROJ_KARATA_U_RUCI = 6;
	
	private static Spil spil;
	//RoiiTODO : private !
	private static Igrac igrac;
	

	private static String drugiIgracIme;
	public static String getDrugiIgracIme() {
		return drugiIgracIme;
	}
	public static void setDrugiIgracIme(String drugiIgracIme) {
		ManagerIgre.drugiIgracIme = drugiIgracIme;
	}

	private static boolean igramPrvi;
	private static boolean poslednjiNosio;
	
	private static List<Karta> tabla;
	
	final static boolean DEBUG = true;
	
	static MenagerKomunikacije menagerKomunikacije;
	
	static {
		igrac = new Igrac();
		tabla = new ArrayList<>(26);
		menagerKomunikacije = new MenagerKomunikacije();
	}
	
	public static Igrac igrac(){ return igrac;}
	public static List<Karta> tabla(){ return tabla;}
	public static MenagerKomunikacije menagerKomunikacije(){ return menagerKomunikacije;}
	
	private static KlijentInterfejs klijent; //Robii.TODO
	public static void zapocniIgru(KlijentInterfejs kl){
		klijent = kl;
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
		zapocniIgru(new Spil(mojSpil), igramPrvi);
		
		if(klijent!=null){
			try {
				klijent.posaljiSpil(new Spil(tudjiSpil), !igramPrvi);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}
	public static void setImeIgraca2(String imeIgraca2){
		drugiIgracIme=imeIgraca2;
		System.out.println("Ime 2 je"+drugiIgracIme);
	}
	public static String getImeIgraca2(){
		return drugiIgracIme;
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
		System.out.println("\n-----------");
	}
	private static void stampajRuku() {
		System.out.println("Ruka:");
		igrac.getURuci().forEach(t -> System.out.print(t+" "));
		System.out.println("\n+++");
	}
	
	public static void novaRuka(){
		List<Karta> r = spil.uzmi(BROJ_KARATA_U_RUCI);
		igrac.dodajURuku(r);
		
		if(DEBUG) stampajRuku();
		
		if(!igramPrvi){
			Frame.blokiran=true;
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
		
		menagerKomunikacije.odigraoSam(bacena, nositi);

		if(igrac.getURuci().isEmpty() && !igramPrvi){
			checkResult();
		}
	}

	public static void odigraoJe(Karta bacena, List<Karta> nositi){
		if(DEBUG) System.out.println("Noseno sa "+bacena+" : "+nositi);

		boolean pisiTablu = srediTablu(bacena, nositi);
		
		if(pisiTablu)
			igrac.tablaZaProtivnika();
		
		if(!nositi.isEmpty())
			poslednjiNosio = false;
		
		if(igrac.getURuci().isEmpty() && igramPrvi)
			checkResult();
		JTalonPanel.odigraoJe(bacena, nositi);
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
	

	private static void checkResult(){
		
		
		if(spil.preostaloKarata()>0){
			novaRuka();
		} else {

			if(DEBUG) System.out.println("Checking rezultat");
			
			if(poslednjiNosio)
				igrac.dadajUNosene(tabla);
			
			igrac.sracunajPoene();
			
			if(krajIgre()){
				JOptionPane.showMessageDialog(null, "Kraj igre!");
			} else {
				// RobiiTODO
				
				// if I'm a server...
				if(menagerKomunikacije.me.amIServer())
				zapocniIgru(klijent);
			}
		}
	}
	
	public static boolean krajIgre(){
		if(DEBUG) System.out.println("Igra je zavrsena");
		return igrac.getUkupnoPoeni() > 100 || igrac.getUkupnoPoeniProtivnika() > 100;
	}
}
