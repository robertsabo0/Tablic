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
	private static final String host = "192.168.1.111";
	
	public static void main(String... args) throws Exception{
		ManagerIgre.menagerKomunikacije().konektujSe(host, "Igrac2");
		SpilTest.playTest();
	}
}
