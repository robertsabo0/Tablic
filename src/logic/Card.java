package logic;

public class Card {
	
	private Znak znak;
	private Vrednost vrednost;
	
	public Card(Znak znak, Vrednost vrednost) {
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
		Card other = (Card) obj;
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
