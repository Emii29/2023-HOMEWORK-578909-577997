package it.uniroma3.diadia.ambienti;
import java.util.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {
	
	private Labirinto labirinto;
	private Map<String,Stanza> mappaStringStanza;
	private Stanza ultimaStanzaAggiunta;

	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
		this.mappaStringStanza = new HashMap<>();
	}
	
	public Map<String,Stanza> getListaStanze() {
		return mappaStringStanza;
	}

	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	public LabirintoBuilder addStanzaIniziale(String nomeStanza) {
		Stanza stanza = new Stanza(nomeStanza);
		mappaStringStanza.put(nomeStanza, stanza);
		this.labirinto.setStanzaCorrente(stanza);
		this.labirinto.setStanzaIniziale(stanza);
		this.ultimaStanzaAggiunta = stanza;
		return this;
		}
	
	public LabirintoBuilder addStanzaVincente(String nomeStanza) {
		Stanza stanza = new Stanza(nomeStanza);
		mappaStringStanza.put(nomeStanza, stanza);
		this.labirinto.setStanzaVincente(stanza);
		this.ultimaStanzaAggiunta = stanza;
		return this;
	}

	public LabirintoBuilder addStanza(String nomeStanza) {
		Stanza stanza = new Stanza(nomeStanza);
		mappaStringStanza.put(nomeStanza, stanza);
		this.ultimaStanzaAggiunta = stanza;
		return this;
	}

	public LabirintoBuilder addStanzaBloccata(String nomeStanza,String direzioneBloccata, String nomeAttrezzo) {
		StanzaBloccata stanzaBloccata = new StanzaBloccata(nomeStanza, direzioneBloccata, nomeAttrezzo);
		mappaStringStanza.put(nomeStanza, stanzaBloccata);
		this.ultimaStanzaAggiunta = stanzaBloccata;
		return this;
	}

	public LabirintoBuilder addStanzaBuia(String nomeStanza, String nomeAttrezzo) {
		StanzaBuia stanzaBuia = new StanzaBuia(nomeStanza, nomeAttrezzo);
		mappaStringStanza.put(nomeStanza, stanzaBuia);
		this.ultimaStanzaAggiunta = stanzaBuia;
		return this;
	}

	public LabirintoBuilder addStanzaMagica(String nomeStanza, int sogliaMagica) {
		StanzaMagica stanzaMagica = new StanzaMagica(nomeStanza, sogliaMagica);
		mappaStringStanza.put(nomeStanza, stanzaMagica);
		this.ultimaStanzaAggiunta = stanzaMagica;
		return this;
	}
	
	public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int peso) {
		this.ultimaStanzaAggiunta.addAttrezzo(new Attrezzo(nomeAttrezzo,peso));
		return this;
	}
	
	public LabirintoBuilder addAdiacenza(String nome1, String nome2, String direzione) {
		this.mappaStringStanza.get(nome1).impostaStanzaAdiacente(direzione, this.mappaStringStanza.get(nome2));
		this.mappaStringStanza.get(nome2).impostaStanzaAdiacente(direzioneOpposta(direzione), this.mappaStringStanza.get(nome1));
		return this;
	}

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
