package komunikacija;

import java.rmi.RemoteException;
import java.rmi.server.RemoteCall;
import java.rmi.server.RemoteObject;
import java.rmi.server.RemoteObjectInvocationHandler;
import java.rmi.server.RemoteServer;
import java.rmi.server.RemoteStub;
import java.rmi.server.UnicastRemoteObject;

public abstract class KarteImplementacija  extends UnicastRemoteObject  implements KarteInterfejs{
	
	public boolean blokiran;
	public boolean amIServer;
	
	public KarteInterfejs drugi;
	
	protected KarteImplementacija() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void stampaj() throws RemoteException {
		System.out.println("aaaa");	
	}

	void odigraoSam(){
		try{
			// posalji request
			drugi.odigraoJe();
			blokirajSe();
		}catch (Exception e){}
		
	}
	protected void blokirajSe(){
		blokiran = true;
	}
	protected void odBlokirajSe(){
		blokiran = false;
	}
	
	public void odigraoJe() throws RemoteException{
		// dobio sam request !
		odBlokirajSe();
		//TODO
		//odstampati
		
		// realno:
		// poziva iz logike ...
		// unblock //
		
	}
	public void setImeIgraca2(String imeIgraca2) throws RemoteException{
		drugi.setImeIgraca2(imeIgraca2);
		
	}

}
