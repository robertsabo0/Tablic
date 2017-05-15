package komunikacija;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import logic.Karta;

public interface KarteInterfejs extends Remote{
	
	public void stampaj() throws RemoteException;
	public void odigraoJe(Karta k, List<Karta> l) throws RemoteException;
	public void setImeIgraca2(String imeIgraca2) throws RemoteException;
	public boolean amIServer() throws RemoteException;
}
