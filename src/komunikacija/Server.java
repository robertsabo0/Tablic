package komunikacija;
import komunikacija.KarteImplementacija;
import java.rmi.RemoteException;
import java.util.LinkedList;

import logic.ManagerIgre;

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
		klijent.setImeIgraca2(ManagerIgre.igrac().getIme());
		ManagerIgre.zapocniIgru(klijent);
	}

//	@Override
//	public void setImeIgraca2(String imeIgraca2) throws RemoteException {
//		// TODO Auto-generated method stub
//		
//	}

}
