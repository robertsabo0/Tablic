package logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

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
		if(vrednost.getVr() >= 10) vr = 1;
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
	
	
}
