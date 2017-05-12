package logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Spil implements Serializable{

	public List<Karta> spil;

	public Spil() {
		spil = new ArrayList<>(52);
		for(Znak z : Znak.values()){
			for(Vrednost v : Vrednost.values()){
				spil.add(new Karta(z, v));
			}
		}
	}
	
	public Spil(List<Karta> l){
		spil = l;
	}
	
	public void promesaj(){
		Collections.shuffle(spil);;
	}
	
	public List<Karta> uzmi(int n){
		List<Karta> ret = new ArrayList<>(n);
		List<Karta> tmp = spil.subList(0, n);
		tmp.forEach(ret::add);
		spil.removeAll(ret);
		
		return ret;
	}
	
	public int preostaloKarata(){
		return spil.size();
	}
	
}
