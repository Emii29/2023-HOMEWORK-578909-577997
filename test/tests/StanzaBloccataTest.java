package tests;


import static org.junit.jupiter.api.Assertions.*;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StanzaBloccataTest {
	private StanzaBloccata stanzaBloccata;
	private Stanza stanzaBloccataType;
	private Stanza stanzaEst;
	private Attrezzo[] attrezzi;
	String direzioneBloccata;
	String attrezzoNecessario;
	private String MESSAGGIO_BLOCCATA = ("La porta a est e' bloccata, lascia a terra un: chiave per aprirla");
	
	@BeforeEach
	void setup() {
		//creazione array di attrezzi
		this.attrezzi = new Attrezzo[2];
		this.attrezzi[0] = new Attrezzo("chiave", 2);
		this.attrezzi[1] = new Attrezzo("scudo", 3);
		//setup stanze
		this.stanzaBloccata = new StanzaBloccata("Stanza Bloccata", Direzione.est, "chiave");
		this.stanzaEst = new Stanza("Stanza Est");
		this.stanzaEst = new Stanza("Stanza Est");
		this.stanzaBloccataType = new Stanza("Stanza Bloccata");
		this.stanzaBloccata.impostaStanzaAdiacente(Direzione.est, stanzaEst);
		this.stanzaBloccataType.impostaStanzaAdiacente(Direzione.est, stanzaEst);
	}
	
	@Test
	void testStanzaBloccataGetStanzaAdiacenteBloccata() {
		assertEquals(this.stanzaBloccata.getStanzaAdiacente(Direzione.est),this.stanzaBloccata);
	}
	
	@Test
	void testStanzaBloccataGetStanzaAdiacenteBloccataConChiave() {
		this.stanzaBloccata.addAttrezzo(this.attrezzi[0]);
		assertEquals(this.stanzaBloccata.getStanzaAdiacente(Direzione.est),this.stanzaEst);
	}

	@Test
	void testStanzaBloccataGetStanzaAdiacenteBloccataSenzaChiave() {
		this.stanzaBloccata.addAttrezzo(this.attrezzi[1]);
		assertEquals(this.stanzaBloccata.getStanzaAdiacente(Direzione.est),this.stanzaBloccata);
	}

	@Test
	void testStanzaBloccataGetStanzaAdiacenteBloccataGetDescrizione() {
		this.stanzaBloccata.addAttrezzo(this.attrezzi[1]);
		assertEquals(this.stanzaBloccata.getDescrizione(),this.MESSAGGIO_BLOCCATA);
	}

	@Test
	void testStanzaBloccataGetStanzaAdiacenteBloccataGetDescrizioneSbloccata() {
		this.stanzaBloccata.addAttrezzo(this.attrezzi[0]);
		this.stanzaBloccataType.addAttrezzo(this.attrezzi[0]);
		assertEquals(this.stanzaBloccata.getDescrizione(), this.stanzaBloccataType.getDescrizione());
	}
}
