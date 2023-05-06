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
	private Map<String,Attrezzo> Borsa;
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private int pesoMax;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
		this.Borsa = new HashMap<>();
		this.pesoMax = pesoMax;
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		this.Borsa.put(attrezzo.getNome(), attrezzo);
		return true;
	}
	
	public int getPesoMax() {
		return pesoMax;
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;		
		if (nomeAttrezzo != null && this.Borsa.containsKey(nomeAttrezzo))
			a = this.Borsa.get(nomeAttrezzo);
		return a;
	}

	public int getPeso() {
		int peso = 0;
		Iterator<Attrezzo> iterator = this.Borsa.values().iterator();
		while (iterator.hasNext()) {
			peso = peso + iterator.next().getPeso();
		}
		return peso;
	}

	public boolean isEmpty() {
		return this.Borsa.isEmpty();
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	public boolean removeAttrezzo(Attrezzo nomeAttrezzo) {
		if(this.Borsa.remove(nomeAttrezzo.getNome()) != null)
			return true;			
		return false;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}