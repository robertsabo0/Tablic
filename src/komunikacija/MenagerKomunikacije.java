package komunikacija;
import logic.ManagerIgre;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import gui.DialogKlijentServer;

public class MenagerKomunikacije {
	
	public KarteImplementacija me;
	
	public void kreirajKonekciju(String imeIgraca1){
		try{
			imeIgraca1=DialogKlijentServer.textImeIgraca.getText();
			Server server=new Server();
			me = server;
			Registry reg=LocateRegistry.createRegistry(1099);
			reg.rebind("server", server);
			ManagerIgre.igrac().setIme(imeIgraca1);
			System.out.println("Konekcija spremna");
		} catch (Exception e){}
	}
	
	public void konektujSe(String ip, String imeIgraca2) throws NeuspesnaKonekcijaException, NotBoundException{
		try{
			imeIgraca2=DialogKlijentServer.textImeIgraca.getText();
			Registry reg=LocateRegistry.getRegistry(ip, 1099);
			ServerInterfejs server=(ServerInterfejs) reg.lookup("server");
			System.out.println("Konektovan");
			server.setImeIgraca2(imeIgraca2);
			Klijent klijent=new Klijent(server);
			me = klijent;
		} catch (RemoteException e){
			throw new NeuspesnaKonekcijaException();
		}
	}
	
	public void odigraoSam(){
		me.odigraoSam();
	}
	
	
}
