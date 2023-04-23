package tests;


import static org.junit.jupiter.api.Assertions.*;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StanzaBuiaTest {
	private StanzaBuia stanzaVuotaBuia;
	private StanzaBuia stanzaPienaBuia;
	private Stanza stanzaVuotaIlluminata;
	private Stanza stanzaPienaIlluminata;
	private Attrezzo[] attrezzi;
	private static String MESSAGGIO_BUIA = "Qui c'e' un buio pesto.";
	
	@BeforeEach
	void setup() {
		//creazione array di attrezzi
		this.attrezzi = new Attrezzo[3];
		this.attrezzi[0] = new Attrezzo("torcia", 1);
		this.attrezzi[1] = new Attrezzo("scudo", 2);
		this.attrezzi[2] = new Attrezzo("spada", 3);
		//setup stanze
		this.stanzaVuotaBuia = new StanzaBuia("vuota", "torcia");
		this.stanzaPienaBuia = new StanzaBuia("piena", "torcia");
		this.stanzaVuotaIlluminata = new Stanza("vuota");
		this.stanzaPienaIlluminata = new Stanza("piena");
		//setup attrezzi stanze buie
		this.stanzaPienaBuia.addAttrezzo(this.attrezzi[0]);
		this.stanzaPienaBuia.addAttrezzo(this.attrezzi[1]);
		this.stanzaPienaBuia.addAttrezzo(this.attrezzi[2]);
		//setup attrezzi stanze illuminate
		this.stanzaPienaIlluminata.addAttrezzo(this.attrezzi[0]);
		this.stanzaPienaIlluminata.addAttrezzo(this.attrezzi[1]);
		this.stanzaPienaIlluminata.addAttrezzo(this.attrezzi[2]);
	}

	@Test
	void testComportamentoStanzaPienaConAttrezzoIlluminante() {
		assertEquals(this.stanzaPienaBuia.getDescrizione(),this.stanzaPienaIlluminata.getDescrizione());
	}

	@Test
	void testComportamentoStanzaPienaConAttrezzoIlluminanteRimosso() {
		this.stanzaPienaBuia.removeAttrezzo(this.stanzaPienaBuia.getAttrezzi()[0]);
		assertEquals(this.stanzaPienaBuia.getDescrizione(),this.MESSAGGIO_BUIA);
	}
	
	@Test
	void testStanzaVuota() {
		assertEquals(this.stanzaVuotaBuia.getDescrizione(),this.MESSAGGIO_BUIA);
	}
	
	@Test
	void testStanzaVuotaConAttrezzoIlluminanteAggiuntoDopo() {
		this.stanzaVuotaBuia.addAttrezzo(this.attrezzi[0]);
		this.stanzaVuotaIlluminata.addAttrezzo(this.attrezzi[0]);
		assertEquals(this.stanzaVuotaBuia.getDescrizione(), this.stanzaVuotaIlluminata.getDescrizione());
	}
	
	void testStanzaVuotaConAttrezzoNonIlluminanteAggiuntoDopo() {
		this.stanzaVuotaBuia.addAttrezzo(this.attrezzi[1]);
		this.stanzaVuotaIlluminata.addAttrezzo(this.attrezzi[1]);
		assertEquals(this.stanzaVuotaBuia.getDescrizione(), this.MESSAGGIO_BUIA);
	}
}
