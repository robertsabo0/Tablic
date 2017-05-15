package test;

import java.util.List;
import java.util.Scanner;

import logic.Karta;
import logic.ManagerIgre;

public class TesticKlijent {

	/**
	 * @param args
	 * @throws Exception
	 */
	private static final String host = "localhost";
	
	public static void main(String... args) throws Exception{
		System.out.println("++++\nK L I J E N T\n+++++");
		ManagerIgre.menagerKomunikacije().konektujSe(host, "Igrac2");
		SpilTest.playTest();
	}
}
