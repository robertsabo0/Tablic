package komunikacija;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterfejs extends Remote, KarteInterfejs{
	public void javiSe(KlijentInterfejs klijent) throws RemoteException;
}
