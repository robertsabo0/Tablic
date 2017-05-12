package komunikacija;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MenagerKomunikacije {
	
	public KarteImplementacija me;
	
	public void kreirajKonekciju(){
		try{
			Server server=new Server();
			me = server;
			Registry reg=LocateRegistry.createRegistry(1099);
			reg.rebind("server", server);
			System.out.println("Konekcija spremna");
		} catch (Exception e){}
	}
	
	public void konektujSe(String ip) throws NeuspesnaKonekcija, NotBoundException{
		try{
			Registry reg=LocateRegistry.getRegistry(ip, 1099);
			ServerInterfejs server=(ServerInterfejs) reg.lookup("server");
			System.out.println("Konektovan");
			Klijent klijent=new Klijent(server);
			me = klijent;
		} catch (RemoteException e){
			throw new NeuspesnaKonekcija();
		}
	}
	
	public void odigraoSam(){
		me.odigraoSam();
	}
	
	
}
