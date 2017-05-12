package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Spil {

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
		List<Karta> tmp = spil.subList(spil.size() - n, spil.size());
		tmp.forEach(ret::add);
		spil.removeAll(ret);
		
		return ret;
	}
	
	public int preostaloKarata(){
		return spil.size();
	}
	
}
