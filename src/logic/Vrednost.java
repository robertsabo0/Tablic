package logic;

public enum Vrednost implements VrednostInterface{
	A(11),
	DVA(2),
	TRI(3),
	CETIRI(4),
	PET(5),
	SEST(6),
	SEDAM(7),
	OSAM(8),
	DEVET(9),
	DESET(10),
	J(12),
	Q(13),
	K(14);
	
	private int vr;
	
	private Vrednost(int v){
		vr = v;
	}

	public int getVrednost() {
		return vr;
	}
	
	@Override
	public String toString(){
		return vr > 10 ? this.name() : this.getVrednost()+"";
	}
}
