package logic;

import java.util.List;

public class NeMozeSeNositiException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NeMozeSeNositiException(Karta k, List<Karta> l){
		super("Ne moze se sa kartom "+k+" nositi "+l);
	}
}
