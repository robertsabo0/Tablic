package komunikacija;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class KreirajKonekcijuTest {
	
	public static void main(String[] args) throws RemoteException, NotBoundException{
		MenagerKomunikacije menager=new MenagerKomunikacije();
		menager.kreirajKonekciju();
		
//		Scanner scan=new Scanner(System.in);
//		String text=scan.nextLine();
//		while (text!="."){
//			// ucitaj
//			// kada ucitas:
//			
//			// if Blokiran, do nothing
//			menager.odigraoSam();
//		}
	}
}
