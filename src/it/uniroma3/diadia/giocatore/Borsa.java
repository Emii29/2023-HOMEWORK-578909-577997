package it.uniroma3.diadia.giocatore;
import java.util.*;
import it.uniroma3.diadia.attrezzi.*;

/**
 * Classe Borsa che si occupa delle gestione dell'inventario del giocatore
 * @author Emilio Martis/Edoardo Piovano - 578909/577997
 * @version base
 * @see Attrezzo
 */

public class Borsa {
	private Map<String,Attrezzo> mappaStringAttrezzo;
	private List<Attrezzo> listaAttrezzi;
	private SortedSet<Attrezzo> setBorsaSorted;
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private int pesoMax;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
		this.mappaStringAttrezzo = new HashMap<>();
		this.pesoMax = pesoMax;
	}
	
	/**
	 * Metodo che permette di aggiungere un attrezzo alla borsa.
	 * @param attrezzo
	 * @return true se l'attrezzo e' stato aggiunto.
	 */
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		this.mappaStringAttrezzo.put(attrezzo.getNome(), attrezzo);
		return true;
	}
	
	/**
	 * @return Il peso massimo consentito nella borsa.
	 */
	
	public int getPesoMax() {
		return pesoMax;
	}
	
	/**
	 * Metodo che cerca un attrezzo tramite striga e ritorna tale attrezzo in variabile attrezzo.
	 * @param nomeAttrezzo
	 * @return l'attrezzo cercato in variabile di tipo attrezzo.
	 */
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;		
		if (nomeAttrezzo != null && this.mappaStringAttrezzo.containsKey(nomeAttrezzo))
			a = this.mappaStringAttrezzo.get(nomeAttrezzo);
		return a;
	}

	/**
	 * Metodo che ritorna il peso attuale della borsa.
	 * @return il peso attuale della borsa.
	 */
	
	public int getPeso() {
		int peso = 0;
		Iterator<Attrezzo> iterator = this.mappaStringAttrezzo.values().iterator();
		while (iterator.hasNext()) {
			peso = peso + iterator.next().getPeso();
		}
		return peso;
	}

	/**
	 * Metodo che verifica se la borsa e' vuota.
	 * @return true se la borsa e' vuota.
	 */
	
	public boolean isEmpty() {
		return this.mappaStringAttrezzo.isEmpty();
	}
	
	/**
	 * Metodo che verifica se esiste un attrezzo per nome.
	 * @param nomeAttrezzo
	 * @return l'attrezzo cercato in formato variabile attrezzo.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	/**
	 * Cerca il nome dell'attrezzo ricevuto e lo rimuove dalla borsa se presente.
	 * @param nomeAttrezzo.
	 * @return true se l'attrezzo � stato rimosso.
	 */
	
	public boolean removeAttrezzo(Attrezzo nomeAttrezzo) {
		if(this.mappaStringAttrezzo.remove(nomeAttrezzo.getNome()) != null)
			return true;			
		return false;
	}
	
	/**
	 * Metodo che stampa le informazioni riguardanti la borsa.
	 */
	
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) { //se la borsa non e' vuota, stampa:
//			s.append("\nContenuto borsa: " + this.getPeso() + " kg / " + this.getPesoMax() + " kg\n");
//			s.append(this.getContenutoOrdinatoPerNome().toString());
//			s.append(this.getContenutoOrdinatoPerPeso().toString());
			s.append("\nContenuto borsa raggruppato per peso: \n");
		//	s.append(this.getContenutoRaggruppatoPerPeso().toString());
			s.append(this.getSortedSetOrdinatoPerPeso().toString());
			return s.toString();
		}
		else
			s.append("Borsa vuota.");
		return s.toString();
	}
	
	/**
	 * Metodo che ordina gli attrezzi basandosi sul loro peso.
	 * @return lista ordinata
	 */
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		
		this.listaAttrezzi = new ArrayList<Attrezzo>(this.mappaStringAttrezzo.values());

		this.listaAttrezzi.sort(Comparator.comparing(Attrezzo::getNome));
		this.listaAttrezzi.sort(Comparator.comparingInt(Attrezzo::getPeso));
		
		return this.listaAttrezzi;
	}
	
	/**
	 * Metodo che crea un Set ordinato per nome.
	 * @return Set ordinato per nome di tutti gli attrezzi presenti nella borsa.
	 */
	
	SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		return new TreeSet<Attrezzo>(this.mappaStringAttrezzo.values());
	}
	
	/**
	 * Metodo che restituisce una mappa che ha come chiave un intero, e come valore un Set con tutti gli attrezzi che hanno quel peso.
	 * @return Map(integer),Set(Attrezzo))
	 */
	
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer,Set<Attrezzo>> mappaIntegerSet = new TreeMap<>();
		Iterator<Attrezzo> iteratoreAttrezziBorsa = this.mappaStringAttrezzo.values().iterator();
		
		Attrezzo temp = new Attrezzo(null, 0);
		
			while (iteratoreAttrezziBorsa.hasNext()) {
				temp = iteratoreAttrezziBorsa.next();
					if (mappaIntegerSet.containsKey(temp.getPeso()))
						mappaIntegerSet.get(temp.getPeso()).add(temp); //aggiunge nella mappa all'indice con il peso gia' esistente l'attrezzo temp
					else {
						Set<Attrezzo> listaAttrezzi = new HashSet<>();					
						listaAttrezzi.add(temp);
						mappaIntegerSet.put(temp.getPeso(), listaAttrezzi);
					}
			}

		return mappaIntegerSet;
	}
	
	SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {		
		SortedSet<Attrezzo> cacca = new TreeSet<Attrezzo>(new ComparatoreAttrezziPerPeso());
		cacca.addAll(this.mappaStringAttrezzo.values());
		return cacca;
	}


	
}