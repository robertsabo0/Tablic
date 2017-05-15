package komunikacija;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import logic.Karta;

public interface KarteInterfejs extends Remote{
	
	public void stampaj() throws RemoteException;
	public void odigraoJe(Karta k, List<Karta> l) throws RemoteException;
	public boolean amIServer() throws RemoteException;
	public void setImeIgraca(String imeIgraca) throws RemoteException;
	public void posaljiImeIgraca(String imeIgraca) throws RemoteException;
}
