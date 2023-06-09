package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;
import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Labirinto che si occupa della gestione del labirinto.
 * @author Emilio Martis/Edoardo Piovano - 578909/577997
 * @version base
 */

public class Labirinto {
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private Stanza stanzaIniziale;
	
	private Labirinto(String nomeFile) throws FileNotFoundException, FormatoFileNonValidoException {
		CaricatoreLabirinto c = new CaricatoreLabirinto(nomeFile);
		c.carica();
		this.stanzaIniziale = c.getStanzaIniziale();
		this.stanzaCorrente = c.getStanzaIniziale();
		this.stanzaVincente = c.getStanzaVincente();
	}

	
	public static LabirintoBuilder newBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
		return new LabirintoBuilder(labirinto);
	}
	
	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}
	
	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;	
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}
	
	public void setStanzaIniziale(Stanza stanzaIniziale) {
		this.stanzaIniziale = stanzaIniziale;
	}

	public static class LabirintoBuilder {
		
		private Labirinto labirinto;
		private Map<String,Stanza> mappaStringStanza;
		private Stanza ultimaStanzaAggiunta;
	
		public LabirintoBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
			this.labirinto = new Labirinto(labirinto);
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
		
		public LabirintoBuilder addStanzaBloccata(String nomeStanza,Direzione direzioneBloccata, String nomeAttrezzoSbloccante) {
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

		public LabirintoBuilder addAdiacenza(String nome1, String nome2, Direzione direzione) {
			this.mappaStringStanza.get(nome1).impostaStanzaAdiacente(direzione, this.mappaStringStanza.get(nome2));
			this.mappaStringStanza.get(nome2).impostaStanzaAdiacente(direzioneOpposta(direzione), this.mappaStringStanza.get(nome1));
			return this;
		}
		
		/**
		 * Ritorna la direzione opposta rispetto alla direzione inviata.
		 * @param direzione
		 * @return
		 */
		
		public Direzione direzioneOpposta (Direzione direzione) {
			if (direzione == Direzione.nord)
				return Direzione.sud;
			if (direzione == Direzione.sud)
				return Direzione.nord;
			if (direzione == Direzione.est)
				return Direzione.ovest;
			else
				return Direzione.est;
		}

		public LabirintoBuilder  addMago(String nome, String presentazione, Attrezzo attrezzo) {
			Mago m = new Mago(nome, presentazione, attrezzo);
			if(this.ultimaStanzaAggiunta==null)
				return this;
			this.ultimaStanzaAggiunta.setPersonaggio(m);
			return this;
		}

		public LabirintoBuilder  addCane(String nome, String presentazione) {
			Cane c = new Cane(nome, presentazione);
			if(this.ultimaStanzaAggiunta==null)
				return this;
			this.ultimaStanzaAggiunta.setPersonaggio(c);
			return this;
		}

		public LabirintoBuilder  addStrega(String nome, String presentazione) {
			Strega s = new Strega(nome, presentazione);
			if(this.ultimaStanzaAggiunta==null)
				return this;
			this.ultimaStanzaAggiunta.setPersonaggio(s);
			return this;
		}

	}

}
