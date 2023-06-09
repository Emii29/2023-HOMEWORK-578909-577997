package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

import java.util.*;


/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
 */

public class Stanza {

	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;

	private String nome;
	private Map<String,Attrezzo> Attrezzi;
	private int numeroAttrezzi;
	private Map<Direzione,Stanza> Direzioni;
	private int numeroStanzeAdiacenti;
	private AbstractPersonaggio personaggio;
	

	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */

	public Stanza(String nome) {
		this.nome = nome;
		this.Direzioni = new HashMap<>();
		this.Attrezzi = new HashMap<>();
		this.numeroStanzeAdiacenti = 0;
		this.numeroAttrezzi = 0;
	}
	
	public void setPersonaggio(AbstractPersonaggio p) {
		this.personaggio = p;
	}
	
	public AbstractPersonaggio getPersonaggio() {
		return this.personaggio;
	}

	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(Direzione direzione, Stanza stanza) {
		if (this.Direzioni.containsKey(direzione)) {
			this.Direzioni.put(direzione, stanza);		
		}
		else {
			if (numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
				this.Direzioni.put(direzione, stanza);
				numeroStanzeAdiacenti++;
			}				
		}
	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(Direzione direzione) {
		Stanza stanza = null;
		if (direzione != null && this.Direzioni.containsKey(direzione))
			stanza = this.Direzioni.get(direzione);
		return stanza;
	}

	/**
	 * Restituisce il nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public List<Attrezzo> getAttrezzi() {
		return new ArrayList<>(this.Attrezzi.values());
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
			this.Attrezzi.put(attrezzo.getNome(), attrezzo);
			this.numeroAttrezzi++;
			return true;
		}
		return false;
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nUscite: ");
		for (Direzione direzione : this.Direzioni.keySet())
			if (direzione!=null)
				risultato.append(" " + direzione);
		risultato.append("\nAttrezzi nella stanza: ");
		for (Attrezzo attrezzo : this.Attrezzi.values()) {
			if (attrezzo!=null)
				risultato.append(attrezzo.toString()+" ");
		}
		return risultato.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.Attrezzi.containsKey(nomeAttrezzo);
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;
		if (nomeAttrezzo != null && this.Attrezzi.containsKey(nomeAttrezzo))
			attrezzoCercato = this.Attrezzi.get(nomeAttrezzo);
		return attrezzoCercato;
	}
	
	public Map<Direzione, Stanza> getMapStanzeAdiacenti() {
		return this.Direzioni;
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {		
		if(this.Attrezzi.remove(attrezzo.getNome()) != null)
			return true;			
		return false;
	}

	public List<Direzione> getDirezioni() {
		return new ArrayList<>(this.Direzioni.keySet());
	}

}