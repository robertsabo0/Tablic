package test;

import java.util.List;

import logic.Karta;
import logic.ManagerIgre;

public class SpilTest {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String... args) throws Exception{
		ManagerIgre.zapocniIgru();
		List<Karta> ruka = ManagerIgre.igrac().getURuci();
		while(true){
			ManagerIgre.odigraoSam(ruka.get(0));
			ManagerIgre.odigraoSam(ruka.get(0));
			ManagerIgre.odigraoSam(ruka.get(0));
			ManagerIgre.odigraoSam(ruka.get(0), ManagerIgre.tabla());
			ManagerIgre.odigraoSam(ruka.get(0));
			ManagerIgre.odigraoSam(ruka.get(0));
		}
		
		
		/* 
		 * Ovde vidite kako to otprilike izgleda
		 * 
		 * Stef ce pozvati zapocni Igru na serveru
		 * 
		 * a to ce automacki pozvati na drugom delu isto tako nesto...
		 * 
		 * nakon te metode, svi imaju isto (vise-manje)
		 * 
		 * 
		 * 2 metode su vam bitne - odigraoSam(Karta k) - bacena karta
		 * 						 - odigraoSam(Karta k, List<Karta> nosenoSaTable) - sa kojom kartom i sta je noseno sa table
		 * 
		 * otprilike to je to zasad... nadogradnje kad sednemo zajedno
		 * */
	}
}
