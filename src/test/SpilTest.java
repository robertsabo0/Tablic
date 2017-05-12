package test;

import java.util.List;
import java.util.Scanner;

import logic.Karta;
import logic.ManagerIgre;
import logic.NeMozeSeNositiException;

public class SpilTest {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String... args) throws Exception{
		ManagerIgre.zapocniIgru(null);
		
		playTest();
		
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

	static void playTest() throws NeMozeSeNositiException {
		List<Karta> ruka = ManagerIgre.igrac().getURuci();
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			scanner.nextLine();
			ManagerIgre.odigraoSam(ruka.get(0));
			scanner.nextLine();
			ManagerIgre.odigraoSam(ruka.get(0));
			scanner.nextLine();
			ManagerIgre.odigraoSam(ruka.get(0));
			scanner.nextLine();
			ManagerIgre.odigraoSam(ruka.get(0), ManagerIgre.tabla());
		}	
	}
}
