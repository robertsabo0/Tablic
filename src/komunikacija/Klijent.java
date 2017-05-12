package komunikacija;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class Klijent extends KarteImplementacija implements KlijentInterfejs{

	ServerInterfejs server;
	
	protected Klijent(ServerInterfejs a) throws RemoteException {
		super();
		super.drugi = (ServerInterfejs)a;// KarteInterfejs
		server = a;

		server.javiSe(this);
		// TODO Auto-generated constructor stub
		
	}
	@Override
	public void odgovor() throws RemoteException {
		System.out.println("Odgovor");
		
	}

	@Override
	public void posaljiSpil(List<String> spil) throws RemoteException {
		//return spil;
		
		//TODO 
		// test: stampati
	}

}
