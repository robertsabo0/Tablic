package komunikacija;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


public interface KlijentInterfejs extends Remote, KarteInterfejs{
	public void odgovor() throws RemoteException;
	public void posaljiSpil(List<String> splil) throws RemoteException;
}
