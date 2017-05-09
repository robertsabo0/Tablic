package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Spil {

	public List<Card> spil;

	public Spil() {
		spil = new ArrayList<>(52);
		for(Znak z : Znak.values()){
			for(Vrednost v : Vrednost.values()){
				spil.add(new Card(z, v));
			}
		}
	}
	
	public void promesaj(){
		Collections.shuffle(spil);;
	}
	
	public List<Card> uzmi(int n){
		List<Card> ret = spil.subList(spil.size() - n, spil.size());
		
		spil.removeAll(ret);
		
		return ret;
	}
	
	public int preostaloKarata(){
		return spil.size();
	}
	
}
