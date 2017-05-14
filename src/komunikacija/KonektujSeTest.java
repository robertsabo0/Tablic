package komunikacija;

import java.net.InetAddress;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.UnknownHostException;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;

public class KonektujSeTest {
	public static void main(String[] args) throws RemoteException, NotBoundException, NeuspesnaKonekcijaException, ServerNotActiveException, java.net.UnknownHostException {
		MenagerKomunikacije menager=new MenagerKomunikacije();
		
		InetAddress addr = InetAddress.getLocalHost();
		byte[] ipAddr = addr.getAddress();
		String hostname = addr.getHostName();
		menager.konektujSe(hostname, "Igrac2");
	}
}
