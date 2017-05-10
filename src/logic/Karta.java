package logic;

public class Karta {
	
	private Znak znak;
	private Vrednost vrednost;
	
	public Karta(Znak znak, Vrednost vrednost) {
		super();
		this.znak = znak;
		this.vrednost = vrednost;
	}
	public Znak getZnak() {
		return znak;
	}

	public Vrednost getVrednost() {
		return vrednost;
	}
	
	public int nosiPoena() {
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

	
	
	
}
