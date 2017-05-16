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
	
	public static VrednostProsireno getByVrednost(int b){
		switch (b) {
		case 1: return VrednostProsireno.JEDAN;
		case 2: return VrednostProsireno.DVA;
		case 3: return VrednostProsireno.TRI;
		case 4: return VrednostProsireno.CETIRI;
		case 5: return VrednostProsireno.PET;
		case 6: return VrednostProsireno.SEST;
		case 7: return VrednostProsireno.SEDAM;
		case 8: return VrednostProsireno.OSAM;
		case 9: return VrednostProsireno.DEVET;
		case 10: return VrednostProsireno.DESET;
		case 11: return VrednostProsireno.JEDANAEST;
		case 12: return VrednostProsireno.J;
		case 13: return VrednostProsireno.Q;
		case 14: return VrednostProsireno.K;
		}
		return null;

	}
}