package test;

import java.util.List;
import java.util.Scanner;

import logic.Karta;
import logic.ManagerIgre;

public class TesticServer {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String... args) throws Exception{
		ManagerIgre.menagerKomunikacije().kreirajKonekciju();
		
		SpilTest.playTest();
		
	}
}
