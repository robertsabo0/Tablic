package logic;

interface VrednostInterface {
	public int getVrednost();
}

enum VrednostProsireno implements VrednostInterface{
	JEDAN(1),
	DVA(2),
	TRI(3),
	CETIRI(4),
	PET(5),
	SEST(6),
	SEDAM(7),
	OSAM(8),
	DEVET(9),
	DESET(10),
	JEDANAEST(11),
	J(12),
	Q(13),
	K(14);
	
	private int vr;
	
	private VrednostProsireno(int v){
		vr = v;
	}

	public int getVrednost() {
		return vr;
	}
}