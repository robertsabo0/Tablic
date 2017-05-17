package komunikacija;
import java.rmi.RemoteException;

import gui.Frame;
import logic.Igrac;
import logic.ManagerIgre;

public class Server extends KarteImplementacija implements ServerInterfejs{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private KlijentInterfejs klijent=null;
	
	protected Server() throws RemoteException{
		super();
		super.amIServer = true;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void javiSe(KlijentInterfejs kl) throws RemoteException {
		System.out.println("HELLO");
		
		super.drugi = (KarteInterfejs)kl;
		klijent=kl;
		
		// TODO spil
		//klijent.setImeIgraca2(ManagerIgre.igrac().getIme()); Stefan.TODO
		ManagerIgre.zapocniIgru(klijent);

		Frame.main(new String[0]);

		
		ManagerIgre.igrac();
		MenagerKomunikacije.me.posaljiImeIgraca(Igrac.getIme());
		

	}
//	@Override
//	public void setImeIgraca2(String imeIgraca2) throws RemoteException {
//		// TODO Auto-generated method stub
//		
//	}

}
