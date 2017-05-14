package komunikacija;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface KarteInterfejs extends Remote{
	
	public void stampaj() throws RemoteException;
	public void odigraoJe() throws RemoteException;
	public void setImeIgraca2(String imeIgraca2) throws RemoteException;
}
