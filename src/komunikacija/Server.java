package komunikacija;

import java.rmi.RemoteException;
import java.util.LinkedList;

public class Server extends KarteImplementacija implements ServerInterfejs{
	
	private KlijentInterfejs klijent=null;
	
	protected Server() throws RemoteException{
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void javiSe(KlijentInterfejs kl) throws RemoteException {
		System.out.println("HELLO");
		
		super.drugi = (KarteInterfejs)kl;
		klijent=kl;
		
		// TODO spil
		
		kl.posaljiSpil(new LinkedList<>());
		// posalji spil
	}

}
