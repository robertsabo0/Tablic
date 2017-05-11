package logic;

import java.util.ArrayList;
import java.util.List;

public class ManagerIgre {
	public static int BROJ_KARATA_NA_TABLI = 4;
	public static int BROJ_KARATA_U_RUCI = 6;
	
	private static Spil spil;
	private static Igrac igrac;
	
	private static boolean igramPrvi;
	private static boolean poslednjiNosio;
	
	public static List<Karta> tabla;
	
	static{
		igrac = new Igrac();
		tabla = new ArrayList<>(26);
	}
	public static void zapocniIgru(){
		Spil s = new Spil();
		
		s.promesaj();
		
		List<Karta> prvoNaTabli = s.uzmi(BROJ_KARATA_NA_TABLI);
		List<Karta> mojSpil = new ArrayList<>(28);
		List<Karta> tudjiSpil= new ArrayList<>(28);
		
		prvoNaTabli.stream().map(Karta::clone).forEach(mojSpil::add);
		tudjiSpil.addAll(prvoNaTabli);
		
		boolean igramPrvi = igrac.getPoeni().size() % 2 == 0;
		
		zapocniIgru(s, igramPrvi);
		// Robii.TODO
		// KomunikacijaManager.posaljiSpil(tudjiSpil, !igramPrvi);
		
	}
	
	
	public static void zapocniIgru(Spil s, boolean pf){
		igramPrvi = pf;
		igrac.novaPartija();
		postaviNaTablu();
		novaRuka();
	}
	
	private static void postaviNaTablu() {
		tabla.addAll(spil.uzmi(BROJ_KARATA_NA_TABLI));
	}


	public static void novaRuka(){
		List<Karta> r = spil.uzmi(BROJ_KARATA_U_RUCI);
		igrac.dodajURuku(r);
		
		if(!igramPrvi){
			// wait
		}
	}
	
	public static void odigraoSam(Karta bacena, List<Karta> nositi) throws NeMozeSeNositiException{
		if(!mozeNositi(bacena, nositi))
			throw new NeMozeSeNositiException(bacena, nositi);
		
		boolean pisiTablu = srediTablu(bacena, nositi);
		
		if(pisiTablu)
			igrac.tablaZaMene();
		
		// bacena karta
		if(nositi.size() == 0){
			igrac.baciKartu(bacena);
		} else {
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
		if()
	}
}
