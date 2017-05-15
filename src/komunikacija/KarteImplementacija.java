package komunikacija;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import logic.Igrac;
import logic.Karta;
import logic.ManagerIgre;

public abstract class KarteImplementacija  extends UnicastRemoteObject  implements KarteInterfejs{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public boolean blokiran;
	protected boolean amIServer;
	
	public KarteInterfejs drugi;
	
	protected KarteImplementacija() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void stampaj() throws RemoteException {
		System.out.println("aaaa");	
	}

	void odigraoSam(Karta k, List<Karta> l){
		try{
			// posalji request
			drugi.odigraoJe(k, l);
			blokirajSe();
		}catch (Exception e){}
		
	}
	public void blokirajSe(){
		blokiran = true;
	}
	public void odBlokirajSe(){
		blokiran = false;
	}
	
	public void odigraoJe(Karta k, List<Karta> l) throws RemoteException{
		// dobio sam request !
		odBlokirajSe();
		//TODO
		//odstampati
		
		// realno:
		ManagerIgre.odigraoJe(k, l);
		
	}
	public boolean amIServer(){
		return amIServer;
	}
	
	@Override
	public void setImeIgraca(String imeIgraca){
		ManagerIgre.setImeIgraca2(imeIgraca);
	}
	@Override
	public void posaljiImeIgraca(String imeIgraca) throws RemoteException{
		drugi.setImeIgraca(imeIgraca);
	}

}
