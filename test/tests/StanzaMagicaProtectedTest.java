package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.StanzaMagica;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaMagicaProtectedTest {
	private StanzaMagica stanzaPiena;
	private Attrezzo[] attrezzi;
	
	@BeforeEach
	void setup() {
		this.attrezzi = new Attrezzo[3];
		this.attrezzi[0] = new Attrezzo("pala", 1);
		this.attrezzi[1] = new Attrezzo("scudo", 2);
		this.attrezzi[2] = new Attrezzo("spada", 3);
		this.stanzaPiena = new StanzaMagica("piena", 2);
		this.stanzaPiena.addAttrezzo(this.attrezzi[0]);
		this.stanzaPiena.addAttrezzo(this.attrezzi[1]);
		this.stanzaPiena.addAttrezzo(this.attrezzi[2]);
	}

	@Test
	void testStanzaMagicaPienaSogliaMagicaSuperata() {
		assertEquals(this.stanzaPiena.getAttrezzi()[2].getNome(), "adaps");
	}

	@Test
	void testStanzaMagicaPienaSogliaMagicaSuperataDiUnAttrezzo() {
		this.stanzaPiena.addAttrezzo(this.attrezzi[1]);
		assertEquals(this.stanzaPiena.getAttrezzi()[3].getNome(), "oducs");
	}
	
	@Test
	void testStanzaMagicaPienaSogliaMagicaSuperataDiDueAttrezzi() {
		this.stanzaPiena.addAttrezzo(this.attrezzi[1]);
		this.stanzaPiena.addAttrezzo(this.attrezzi[0]);
		assertEquals(this.stanzaPiena.getAttrezzi()[4].getNome(), "alap");
	}

	@Test
	void testStanzaMagicaPienaSogliaMagicaSuperataDiDuePrimoAttrezzo() {
		this.stanzaPiena.addAttrezzo(this.attrezzi[1]);
		this.stanzaPiena.addAttrezzo(this.attrezzi[0]);
		assertEquals(this.stanzaPiena.getAttrezzi()[0].getNome(), "pala");
	}

	@Test
	void testStanzaMagicaPienaSogliaMagicaSuperataAttrezzoInvertitoRimosso() {
		this.stanzaPiena.addAttrezzo(this.attrezzi[1]);
		this.stanzaPiena.removeAttrezzo(this.stanzaPiena.getAttrezzi()[3]);
		assertNull(this.stanzaPiena.getAttrezzi()[3]);
	}
}
