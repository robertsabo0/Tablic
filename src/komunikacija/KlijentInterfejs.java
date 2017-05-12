package komunikacija;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import logic.Spil;


public interface KlijentInterfejs extends Remote, KarteInterfejs{
	public void odgovor() throws RemoteException;
	public void posaljiSpil(Spil s, boolean b) throws RemoteException;
}
