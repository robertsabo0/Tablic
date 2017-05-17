package logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Karta implements Cloneable, Serializable{
	
	/**
	 * 
	 */
	private static Map<String, String> mapa;
	
	static{
		inicijalizujMapu();
		
	}
	
	private static final long serialVersionUID = 1L;
	
	private Znak znak;
	private Vrednost vrednost;
	Karta(Znak znak, Vrednost vrednost) {
		super();
		this.znak = znak;
		this.vrednost = vrednost;
	}
	
	private static void inicijalizujMapu() {
		mapa=new HashMap<>();
		//
		for(Znak z : Znak.values()){
			for(Vrednost v : Vrednost.values()){
				String kljuc=new String(v+"-"+z);
				String simbol="";
				String znak="";
				
				switch(v.toString()){
				case "2": case "3": case "4": case "5":case "6":case "7": case "8": case "9":case "10":
					simbol=v.toString();
					break;
				case "A":
					simbol="11";
					break;
				case "J":
					simbol="12";
					break;
				case "Q":
					simbol="13";
					break;
				case "K":
					simbol="14";
				}
				
				switch(z){
				case KARO:
					znak="kocka";
					break;
				case HERC:
					znak="srce";
					break;
				case PIK:
					znak="pik";
					break;
				default:
					znak="tref";
				}
				
				String vr = "img/"+simbol+","+znak+".png";
				mapa.put(kljuc, vr);
			}
		}
		
	}
	Znak getZnak() {
		return znak;
	}

	Vrednost getVrednost() {
		return vrednost;
	}
	
	public String getSlika(){
		return mapa.get(this.toString());
	}
	
	int nosiPoena() {
		int vr = 0;
		if(vrednost.getVrednost() >= 10) vr = 1;
		if(vrednost.equals(Vrednost.DESET) && znak.equals(Znak.KARO))
			vr = 2;
		if(vrednost.equals(Vrednost.DVA) && znak.equals(Znak.TREF))
			vr = 1;
		
		return vr;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vrednost == null) ? 0 : vrednost.hashCode());
		result = prime * result + ((znak == null) ? 0 : znak.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Karta other = (Karta) obj;
		if (vrednost != other.vrednost)
			return false;
		if (znak != other.znak)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return vrednost+"-"+znak;
	}

	@Override
	public Karta clone(){
		return new Karta(znak, vrednost);
	}
	

	static boolean mozeNositi(Karta bacena, List<Karta> nos) {
		if(nos.isEmpty())
			return true;
		List<Karta> nositi = new ArrayList<>(nos);
		nositi.add(0, bacena);
		
		List<VrednostInterface> allVrednosti = new ArrayList<>();
		nositi.forEach(t -> allVrednosti.add(t.getVrednost()));
		
		return mozeNositi(allVrednosti.toArray(new VrednostInterface[allVrednosti.size()]));
	}
	
	private static boolean mozeNositi(VrednostInterface[] list) {
		boolean ret = false;
		for(int i = 0 ; i<list.length && !ret; i++){
			if(list[i].equals(Vrednost.A)){
				list[i] = VrednostProsireno.JEDAN;
				boolean rez = mozeNositi(list);
				list[i] = VrednostProsireno.JEDANAEST;
				ret = rez || mozeNositi(list);
				list[i] = Vrednost.A;
				return ret;
			}
		}
		return mozeNositiNoA(list);
	}
	
	private static boolean mozeNositiNoA(VrednostInterface[] list) {
		VrednostInterface nosac = list[0];
		List<VrednostInterface> ostali = new ArrayList<>(list.length);
		for(int i = 1; i<list.length; i++){
			if(nosac.getVrednost() != list[i].getVrednost())
				ostali.add(list[i]);
		}
		if(ostali.isEmpty())
			return true;
		boolean found = false;
		if(ostali.size() > 1){
			VrednostInterface prvi = ostali.get(0);
			ostali.remove(prvi);
			
			for(int i = 0; i<ostali.size() && !found; i++){
				VrednostInterface tmp = ostali.get(i);
				
				int zbir = tmp.getVrednost() + prvi.getVrednost();
				if(zbir > nosac.getVrednost())
					continue;
				
				VrednostProsireno vr = VrednostProsireno.getByVrednost(zbir);
				ostali.set(i, vr);
				ostali.add(0, nosac);
				found = found || mozeNositiNoA(ostali.toArray(new VrednostInterface[ostali.size()]));
				ostali.remove(0);
				ostali.set(i, tmp);
			}
		}
		return found;
	}
	
}
