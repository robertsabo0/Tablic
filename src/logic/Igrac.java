package logic;

import java.util.ArrayList;
import java.util.List;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Igrac {

	private String ime;
	private List<Karta> ruka;
	private List<Karta> noseno;
	
	private List<Integer> poeni;
	private List<Integer> poeniProtivnika;

	
	public void novaPartija(){
		if(ruka==null)
			initialize();
		poeni.add(0);
		poeniProtivnika.add(0);
		
		noseno.clear();
		ruka.clear();
	}
	
	private void initialize() {
		ruka = new ArrayList<>(6);
		noseno = new ArrayList<>(52);
		
		poeni = new ArrayList<>(10);
		poeniProtivnika = new ArrayList<>(10);
	}

	public void sracunajPoene(){
		Integer n = noseno.stream().map(Karta::nosiPoena).reduce(0, (a,b) -> a+b);
		
		if(noseno.size() > 26) n+=3;
		
		poeni.add(n);
	}
	
	public void tablaZaMene(){
		int lastIndex = poeni.size()-1;
		Integer h = poeni.get(lastIndex);
		h++;
		poeni.set(lastIndex,h);
	}
	
	public void dodajURuku(List<Karta> l){
		ruka.clear();
		ruka.addAll(l);
	}
	
	public void baciKartu(Karta k){
		ruka.remove(k);
	}
	
	public void dadajUNosene(List<Karta> l){
		noseno.addAll(l);
	}
	
	public List<Karta> getURuci() {
		return ruka;
	}
	public List<Karta> getNoseno() {
		return noseno;
	}

	public List<Integer> getPoeni() {
		return poeni;
	}

	public List<Integer> getPoeniProtivnika() {
		return poeniProtivnika;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public Integer getPoeniTrenutnePartije() {
		return poeni.get(poeni.size()-1);
	}
	
	public Integer getPoeniProtivnikaTrenutnePartije() {
		return poeniProtivnika.get(poeniProtivnika.size()-1);
	}
	
	
}
