package test;

import java.util.List;

import logic.Card;
import logic.Spil;

public class SpilTest {

	public static void main(String... args) throws Exception{
		Spil s = new Spil();
		s.promesaj();
		
		List<Card> c = s.uzmi(10);
		c.forEach(System.out::println);
		
		if(s.preostaloKarata() != 52-10){
			throw new Exception("Test failed");
		}
	}
}
