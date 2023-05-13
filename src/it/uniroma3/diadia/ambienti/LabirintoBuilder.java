package it.uniroma3.diadia.ambienti;
import java.util.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe LabirintoBuilder che si occupa della generazione di labirinti.
 * @author Emilio Martis/Edoardo Piovano - 578909/577997
 * @version base
 * @see Labirinto
 */

public class LabirintoBuilder {

	private Labirinto labirinto;
	private Map<String,Stanza> mappaStringStanza;
	private Stanza ultimaStanzaAggiunta;

	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
		this.mappaStringStanza = new HashMap<>();
	}
	
	/**
	 * Lista delle Stanza con chiave il loro nome.
	 * @return ritorna una mappa con chiave String e valori Stanza.
	 */
	
	public Map<String,Stanza> getListaStanze() {
		return mappaStringStanza;
	}
	
	/**
	 * Labirinto generato.
	 * @return ritorna il labirinto con le stanze generate.
	 */
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	/**
	 * Imposta la stanza iniziale del labirinto.
	 * @param nomeStanza
	 *
	 */
	
	public LabirintoBuilder addStanzaIniziale(String nomeStanza) {
		Stanza stanza = new Stanza(nomeStanza);
		mappaStringStanza.put(nomeStanza, stanza);
		this.labirinto.setStanzaCorrente(stanza);
		this.labirinto.setStanzaIniziale(stanza);
		this.ultimaStanzaAggiunta = stanza;
		return this;
		}
	
	/**
	 * Imposta la stanza vincente del labirinto.
	 * @param nomeStanza
	 *
	 */
	
	public LabirintoBuilder addStanzaVincente(String nomeStanza) {
		Stanza stanza = new Stanza(nomeStanza);
		mappaStringStanza.put(nomeStanza, stanza);
		this.labirinto.setStanzaVincente(stanza);
		this.ultimaStanzaAggiunta = stanza;
		return this;
	}

	/**
	 * Aggiunge una stanza al labirinto.
	 * @param nomeStanza
	 *
	 */
	
	public LabirintoBuilder addStanza(String nomeStanza) {
		Stanza stanza = new Stanza(nomeStanza);
		mappaStringStanza.put(nomeStanza, stanza);
		this.ultimaStanzaAggiunta = stanza;
		return this;
	}
	
	/**
	 * Aggiunge una stanza bloccata al labirinto.
	 * @param nomeStanza
	 * @param direzioneBloccata
	 * @param nomeAttrezzoSbloccante
	 *
	 */
	
	public LabirintoBuilder addStanzaBloccata(String nomeStanza,String direzioneBloccata, String nomeAttrezzoSbloccante) {
		StanzaBloccata stanzaBloccata = new StanzaBloccata(nomeStanza, direzioneBloccata, nomeAttrezzoSbloccante);
		mappaStringStanza.put(nomeStanza, stanzaBloccata);
		this.ultimaStanzaAggiunta = stanzaBloccata;
		return this;
	}
	
	/**
	 * Aggiunge una stanza buia al labirinto.
	 * @param nomeStanza
	 * @param nomeAttrezzoIlluminante
	 *
	 */
	
	public LabirintoBuilder addStanzaBuia(String nomeStanza, String nomeAttrezzoIlluminante) {
		StanzaBuia stanzaBuia = new StanzaBuia(nomeStanza, nomeAttrezzoIlluminante);
		mappaStringStanza.put(nomeStanza, stanzaBuia);
		this.ultimaStanzaAggiunta = stanzaBuia;
		return this;
	}
	
	/**
	 * Aggiunge una stanza magica al labirinto.
	 * @param nomeStanza
	 * @param sogliaMagica
	 *
	 */
	
	public LabirintoBuilder addStanzaMagica(String nomeStanza, int sogliaMagica) {
		StanzaMagica stanzaMagica = new StanzaMagica(nomeStanza, sogliaMagica);
		mappaStringStanza.put(nomeStanza, stanzaMagica);
		this.ultimaStanzaAggiunta = stanzaMagica;
		return this;
	}
	
	/**
	 * Aggiunge un attrezzo all'ultima stanza aggiunta nel labirinto.
	 * @param nomeAttrezzo
	 * @param peso
	 *
	 */
	
	public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int peso) {
		this.ultimaStanzaAggiunta.addAttrezzo(new Attrezzo(nomeAttrezzo,peso));
		return this;
	}
	
	/**
	 * Imposta l'adiacenza tra due stanze.
	 * @param nome1
	 * @param nome2
	 * @param direzione
	 * 
	 */

	public LabirintoBuilder addAdiacenza(String nome1, String nome2, String direzione) {
		this.mappaStringStanza.get(nome1).impostaStanzaAdiacente(direzione, this.mappaStringStanza.get(nome2));
		this.mappaStringStanza.get(nome2).impostaStanzaAdiacente(direzioneOpposta(direzione), this.mappaStringStanza.get(nome1));
		return this;
	}
	
	/**
	 * Ritorna la direzione opposta rispetto alla direzione inviata.
	 * @param direzione
	 * @return
	 */
	
	public String direzioneOpposta (String direzione) {
		if (direzione.equals("nord"))
			return "sud";
		if (direzione.equals("sud"))
			return "nord";
		if (direzione.equals("est"))
			return "ovest";
		if (direzione.equals("ovest"))
			return "est";
		return "errore";
	}
}
