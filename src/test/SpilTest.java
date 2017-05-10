package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import logic.Igrac;
import logic.Karta;
import logic.Spil;

public class SpilTest {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String... args) throws Exception{
		Spil s = new Spil();
		s.promesaj();
		
		
		Igrac igrac = new Igrac();
		igrac.novaPartija();
		
		while(s.preostaloKarata() >= 6){
			
			List<Karta> c = s.uzmi(6);
			c.forEach(System.out::println);
			
			igrac.dodajURuku(c);
			
			for(int i = 0; i < 6; i++){
				Karta k = c.get(i);
				igrac.baciKartu(k);
				System.out.println("bacna karta:"+k);
				
				igrac.dadajUNosene(Arrays.asList(new Karta[]{k}));
				
				System.out.print("noseno do sad: ");
				igrac.getNoseno().forEach(t -> System.out.print(t+" "));
				System.out.println();
				
				System.out.print("ostalo u ruci: ");
				igrac.getURuci().forEach(t -> System.out.print(t+" "));
				System.out.println();
	
				System.out.println("\n------------------\n");
			}

			System.out.println("\n===\n");
			igrac.sracunajPoene();
			System.out.println("Trenutni rez: "+igrac.getPoeniTrenutnePartije()+" - "+igrac.getPoeniProtivnikaTrenutnePartije());

			System.out.println("\n===\n");
			
		}

		System.out.print("ostalo u spilu: ");
		s.uzmi(s.preostaloKarata()).forEach(t -> System.out.print(t+" "));;
	}
}
