package komunikacija;

public class NeuspesnaKonekcijaException extends Exception{
	
	public NeuspesnaKonekcijaException(){
		super("Niste konektovani, pogresan ip");
	}

}
