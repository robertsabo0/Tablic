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
	private static final String host = "LOCALHOST";
	
	public static void main(String... args) throws Exception{
		ManagerIgre.menagerKomunikacije().konektujSe(host);
		SpilTest.playTest();
	}
}
