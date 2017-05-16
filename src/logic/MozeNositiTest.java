package logic;

import java.util.LinkedList;
import java.util.List;

public class MozeNositiTest {
	public static void main(String[] args) {
		Test1();
		Test2();
		Test3();
		Test4();
		Test5();
		Test6();
		Test7();
		Test8();
		Test9();
		Test10();
		Test11();
		Test12();
		Test13();
		Test14();
		Test15();
		Test16();
	}

	private static void Test1() {
		Karta bacena = new Karta(Znak.HERC, Vrednost.A);
		List<Karta> nosi = new LinkedList<>();
		nosi.add(new Karta(Znak.TREF, Vrednost.A));
		
		if(Karta.mozeNositi(bacena, nosi))
			System.out.println("Test 1: Moze da nosi ==== "+bacena+" -" + nosi);
		else 
			System.out.println("Test 1: Ne moze da nosi ==== "+bacena+" -" + nosi);
	}
	private static void Test2() {
		Karta bacena = new Karta(Znak.HERC, Vrednost.K);
		List<Karta> nosi = new LinkedList<>();
		nosi.add(new Karta(Znak.TREF, Vrednost.A));
		
		if(Karta.mozeNositi(bacena, nosi))
			System.out.println("Test 2: Moze da nosi ==== "+bacena+" -" + nosi);
		else 
			System.out.println("Test 2: Ne moze da nosi ==== "+bacena+" -" + nosi);
	}
	private static void Test3() {
		Karta bacena = new Karta(Znak.HERC, Vrednost.SEDAM);
		List<Karta> nosi = new LinkedList<>();
		nosi.add(new Karta(Znak.TREF, Vrednost.SEDAM));
		
		if(Karta.mozeNositi(bacena, nosi))
			System.out.println("Test 3: Moze da nosi ==== "+bacena+" -" + nosi);
		else 
			System.out.println("Test 3: Ne moze da nosi ==== "+bacena+" -" + nosi);
	}
	private static void Test4() {
		Karta bacena = new Karta(Znak.HERC, Vrednost.PET);
		List<Karta> nosi = new LinkedList<>();
		nosi.add(new Karta(Znak.HERC, Vrednost.DVA));
		nosi.add(new Karta(Znak.TREF, Vrednost.TRI));
		
		if(Karta.mozeNositi(bacena, nosi))
			System.out.println("Test 4: Moze da nosi ==== "+bacena+" -" + nosi);
		else 
			System.out.println("Test 4: Ne moze da nosi ==== "+bacena+" -" + nosi);
	}
	private static void Test5() {
		Karta bacena = new Karta(Znak.HERC, Vrednost.J);
		List<Karta> nosi = new LinkedList<>();
		nosi.add(new Karta(Znak.HERC, Vrednost.A));
		nosi.add(new Karta(Znak.TREF, Vrednost.A));
		
		if(Karta.mozeNositi(bacena, nosi))
			System.out.println("Test 5: Moze da nosi ==== "+bacena+" -" + nosi);
		else 
			System.out.println("Test 5: Ne moze da nosi ==== "+bacena+" -" + nosi);
	}
	private static void Test6() {
		Karta bacena = new Karta(Znak.HERC, Vrednost.PET);
		List<Karta> nosi = new LinkedList<>();
		nosi.add(new Karta(Znak.HERC, Vrednost.DVA));
		nosi.add(new Karta(Znak.TREF, Vrednost.A));
		nosi.add(new Karta(Znak.TREF, Vrednost.A));
		nosi.add(new Karta(Znak.TREF, Vrednost.A));
		
		if(Karta.mozeNositi(bacena, nosi))
			System.out.println("Test 6: Moze da nosi ==== "+bacena+" -" + nosi);
		else 
			System.out.println("Test 6: Ne moze da nosi ==== "+bacena+" -" + nosi);
	}
	private static void Test7() {
		Karta bacena = new Karta(Znak.HERC, Vrednost.OSAM);
		List<Karta> nosi = new LinkedList<>();
		nosi.add(new Karta(Znak.HERC, Vrednost.DVA));
		nosi.add(new Karta(Znak.TREF, Vrednost.TRI));
		nosi.add(new Karta(Znak.TREF, Vrednost.A));
		nosi.add(new Karta(Znak.TREF, Vrednost.A));
		nosi.add(new Karta(Znak.TREF, Vrednost.A));
		
		if(Karta.mozeNositi(bacena, nosi))
			System.out.println("Test 7: Moze da nosi ==== "+bacena+" -" + nosi);
		else 
			System.out.println("Test 7: Ne moze da nosi ==== "+bacena+" -" + nosi);
	}
	private static void Test8() {
		Karta bacena = new Karta(Znak.HERC, Vrednost.A);
		List<Karta> nosi = new LinkedList<>();
		nosi.add(new Karta(Znak.HERC, Vrednost.DESET));
		nosi.add(new Karta(Znak.TREF, Vrednost.A));
		
		if(Karta.mozeNositi(bacena, nosi))
			System.out.println("Test 8: Moze da nosi ==== "+bacena+" -" + nosi);
		else 
			System.out.println("Test 8: Ne moze da nosi ==== "+bacena+" -" + nosi);
	}
	private static void Test9() {
		Karta bacena = new Karta(Znak.HERC, Vrednost.K);
		List<Karta> nosi = new LinkedList<>();
		nosi.add(new Karta(Znak.HERC, Vrednost.Q));
		nosi.add(new Karta(Znak.TREF, Vrednost.A));
		
		if(Karta.mozeNositi(bacena, nosi))
			System.out.println("Test 9: Moze da nosi ==== "+bacena+" -" + nosi);
		else 
			System.out.println("Test 9: Ne moze da nosi ==== "+bacena+" -" + nosi);
	}
	private static void Test10() {
		Karta bacena = new Karta(Znak.HERC, Vrednost.DEVET);
		List<Karta> nosi = new LinkedList<>();
		nosi.add(new Karta(Znak.HERC, Vrednost.DVA));
		nosi.add(new Karta(Znak.TREF, Vrednost.TRI));
		nosi.add(new Karta(Znak.TREF, Vrednost.A));
		nosi.add(new Karta(Znak.TREF, Vrednost.A));
		nosi.add(new Karta(Znak.TREF, Vrednost.A));
		
		if(Karta.mozeNositi(bacena, nosi))
			System.out.println("Test 10: Moze da nosi ==== "+bacena+" -" + nosi);
		else 
			System.out.println("Test 10: Ne moze da nosi ==== "+bacena+" -" + nosi);
	}
	private static void Test11() {
		Karta bacena = new Karta(Znak.HERC, Vrednost.A);
		List<Karta> nosi = new LinkedList<>();
		nosi.add(new Karta(Znak.HERC, Vrednost.DESET));
		nosi.add(new Karta(Znak.TREF, Vrednost.A));
		nosi.add(new Karta(Znak.TREF, Vrednost.K));
		
		if(Karta.mozeNositi(bacena, nosi))
			System.out.println("Test 11: Moze da nosi ==== "+bacena+" -" + nosi);
		else 
			System.out.println("Test 11: Ne moze da nosi ==== "+bacena+" -" + nosi);
	}
	private static void Test12() {
		Karta bacena = new Karta(Znak.HERC, Vrednost.K);
		List<Karta> nosi = new LinkedList<>();
		nosi.add(new Karta(Znak.HERC, Vrednost.Q));
		nosi.add(new Karta(Znak.TREF, Vrednost.A));
		nosi.add(new Karta(Znak.TREF, Vrednost.DVA));
		
		if(Karta.mozeNositi(bacena, nosi))
			System.out.println("Test 12: Moze da nosi ==== "+bacena+" -" + nosi);
		else 
			System.out.println("Test 12: Ne moze da nosi ==== "+bacena+" -" + nosi);
	}
	private static void Test13() {
		Karta bacena = new Karta(Znak.HERC, Vrednost.DVA);
		List<Karta> nosi = new LinkedList<>();
		nosi.add(new Karta(Znak.HERC, Vrednost.TRI));
		nosi.add(new Karta(Znak.TREF, Vrednost.DVA));
		
		if(Karta.mozeNositi(bacena, nosi))
			System.out.println("Test 13: Moze da nosi ==== "+bacena+" -" + nosi);
		else 
			System.out.println("Test 13: Ne moze da nosi ==== "+bacena+" -" + nosi);
	}
	private static void Test14() {
		Karta bacena = new Karta(Znak.HERC, Vrednost.DEVET);
		List<Karta> nosi = new LinkedList<>();
		nosi.add(new Karta(Znak.HERC, Vrednost.DVA));
		nosi.add(new Karta(Znak.TREF, Vrednost.TRI));
		nosi.add(new Karta(Znak.TREF, Vrednost.DVA));
		nosi.add(new Karta(Znak.HERC, Vrednost.TRI));
		
		if(Karta.mozeNositi(bacena, nosi))
			System.out.println("Test 14: Moze da nosi ==== "+bacena+" -" + nosi);
		else 
			System.out.println("Test 14: Ne moze da nosi ==== "+bacena+" -" + nosi);
	}private static void Test15() {
		Karta bacena = new Karta(Znak.HERC, Vrednost.J);
		List<Karta> nosi = new LinkedList<>();
		nosi.add(new Karta(Znak.HERC, Vrednost.A));
		nosi.add(new Karta(Znak.TREF, Vrednost.A));
		nosi.add(new Karta(Znak.TREF, Vrednost.DVA));
		nosi.add(new Karta(Znak.TREF, Vrednost.TRI));
		nosi.add(new Karta(Znak.TREF, Vrednost.PET));
		
		if(Karta.mozeNositi(bacena, nosi))
			System.out.println("Test 15: Moze da nosi ==== "+bacena+" -" + nosi);
		else 
			System.out.println("Test 15: Ne moze da nosi ==== "+bacena+" -" + nosi);
	}
	private static void Test16() {
		Karta bacena = new Karta(Znak.HERC, Vrednost.J);
		List<Karta> nosi = new LinkedList<>();
		nosi.add(new Karta(Znak.HERC, Vrednost.A));
		nosi.add(new Karta(Znak.TREF, Vrednost.A));
		nosi.add(new Karta(Znak.KARO, Vrednost.A));
		nosi.add(new Karta(Znak.TREF, Vrednost.DVA));
		nosi.add(new Karta(Znak.TREF, Vrednost.TRI));
		nosi.add(new Karta(Znak.TREF, Vrednost.PET));
		
		if(Karta.mozeNositi(bacena, nosi))
			System.out.println("Test 16: Moze da nosi ==== "+bacena+" -" + nosi);
		else 
			System.out.println("Test 16: Ne moze da nosi ==== "+bacena+" -" + nosi);
	}
	
}
