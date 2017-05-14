package komunikacija;

import java.rmi.RemoteException;

import logic.ManagerIgre;
import logic.Spil;

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
	public void posaljiSpil(Spil s, boolean b) throws RemoteException {
		ManagerIgre.zapocniIgru(s, b);
	}
//	@Override
//	public void setImeIgraca2(String imeIgraca2) throws RemoteException {
//		server.setImeIgraca2(imeIgraca2);
//		
//	}

}
