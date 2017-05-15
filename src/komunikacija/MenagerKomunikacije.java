package komunikacija;
import logic.Karta;
import logic.ManagerIgre;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class MenagerKomunikacije {
	
	public KarteImplementacija me;
	
	public void kreirajKonekciju(String imeIgraca1){
		try{
			Server server=new Server();
			me = server;
			Registry reg=LocateRegistry.createRegistry(1099);
			reg.rebind("server", server);
			ManagerIgre.igrac().setIme(imeIgraca1);
			System.out.println("Konekcija spremna");
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void konektujSe(String ip, String imeIgraca2) throws NeuspesnaKonekcijaException, NotBoundException{
		try{
			Registry reg=LocateRegistry.getRegistry(ip, 1099);
			ServerInterfejs server=(ServerInterfejs) reg.lookup("server");
			System.out.println("Konektovan");
			ManagerIgre.igrac().setIme(imeIgraca2);
			Klijent klijent=new Klijent(server);
			me = klijent;
			//server.setImeIgraca2(imeIgraca2);
		} catch (RemoteException e){
			throw new NeuspesnaKonekcijaException();
		}
	}
	
	public void odigraoSam(Karta k, List<Karta> l){
		me.odigraoSam(k,l);
	}
	
}
