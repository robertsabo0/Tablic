package logic;

import java.util.ArrayList;
import java.util.List;

public class Igrac {

	private static String ime;
	private List<Karta> ruka;
	private List<Karta> noseno;
	
	private List<Integer> poeni;
	private List<Integer> poeniProtivnika;

	Igrac(){
		initialize();
	}
	
	void novaPartija(){
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

	void sracunajPoene(){
		Integer n = noseno.stream().map(Karta::nosiPoena).reduce(0, (a,b) -> a+b);
		Integer n_pr = 22-n;
		if(noseno.size() > 26){
			n+=3;
		} else {
			n_pr += 3;
		}
		
		addOnLast(poeni, n);
		addOnLast(poeniProtivnika, n_pr);
	}
	
	void tablaZaMene(){
		addOnLast(poeni, 1);
	}
	void tablaZaProtivnika(){
		addOnLast(poeniProtivnika, 1);
	}
	
	private static void addOnLast(List<Integer> p, int br){
		int lastIndex = p.size()-1;
		Integer h = p.get(lastIndex);
		h+= br;
		p.set(lastIndex,h);
	}
	
	void dodajURuku(List<Karta> l){
		ruka.clear();
		ruka.addAll(l);
	}
	
	void baciKartu(Karta k){
		ruka.remove(k);
	}
	
	void dadajUNosene(List<Karta> l){
		noseno.addAll(l);
	}
	
	public List<Karta> getURuci() {
		return ruka;
	}
	
	List<Karta> getNoseno() {
		return noseno;
	}

	public List<Integer> getPoeni() {
		return poeni;
	}

	public List<Integer> getPoeniProtivnika() {
		return poeniProtivnika;
	}

	public static String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		System.out.println("Ime je "+ime);
		this.ime = ime;
	}
	
	public Integer getPoeniTrenutnePartije() {
		return poeni.get(poeni.size()-1);
	}
	
	public Integer getPoeniProtivnikaTrenutnePartije() {
		return poeniProtivnika.get(poeniProtivnika.size()-1);
	}
	
	public Integer getUkupnoPoeni(){
		return addAll(poeni);
	}
	public Integer getUkupnoPoeniProtivnika(){
		return addAll(poeniProtivnika);
	}

	private Integer addAll(List<Integer> p) {
		return p.stream().reduce(0, (a,b) -> a+b);
	}
}
