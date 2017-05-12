package komunikacija;

public class NeuspesnaKonekcija extends Exception{
	
	public NeuspesnaKonekcija(){
		super("Niste konektovani, pogresan ip");
	}

}
