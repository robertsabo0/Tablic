package logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Karta implements Cloneable, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Znak znak;
	private Vrednost vrednost;
	Karta(Znak znak, Vrednost vrednost) {
		super();
		this.znak = znak;
		this.vrednost = vrednost;
	}
	Znak getZnak() {
		return znak;
	}

	Vrednost getVrednost() {
		return vrednost;
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
	

	static boolean mozeNositi(Karta bacena, List<Karta> nositi) {
		if(nositi.isEmpty())
			return true;
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
		boolean ret = false;
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
			
			for(int i = 2; i<ostali.length && !found; i++){
				VrednostInterface tmp = ostali.get(i);
				
				int zbir = tmp.getVrednost() + prvi.getVrednost();
				if(zbir > nosac.getVrednost())
					continue;
				
				VrednostProsireno vr = VrednostProsireno.getByVrednost(zbir);
				ostali.replace( i, vr); !!!
				ostali.add(0, nosac);
				found = found | mozeNositiNoA(ostali.toArray());
			}
		}
		return found;
	}
	
	public static void main(String[] args) {
		Karta a1 = new Karta(Znak.HERC, Vrednost.A);
		
		List<Karta> k = new LinkedList<>();
		k.add(new Karta(Znak.HERC, Vrednost.A));
		k.add( new Karta(Znak.HERC, Vrednost.CETIRI));
		k.add( new Karta(Znak.HERC, Vrednost.A));
		k.add(new Karta(Znak.HERC, Vrednost.CETIRI));
		
		mozeNositi(a1, k);
	}
}
