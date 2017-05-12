package logic;

import java.util.List;

public class NeMozeSeNositiException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	public NeMozeSeNositiException(Karta k, List<Karta> l){
		super();
		StringBuilder s = new StringBuilder();
		l.forEach(t->s.append(" "+t));
		message = "Ne moze se sa kartom "+k+" nositi "+s.toString();
	}
	
	@Override
	public String getMessage(){
		return message;
	}
}
