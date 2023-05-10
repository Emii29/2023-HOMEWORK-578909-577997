package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.StanzaMagica;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaMagicaTest {
	private StanzaMagica stanzaMagica;
	private Attrezzo[] attrezzi;
	
	@BeforeEach
	void setup() {
		this.attrezzi = new Attrezzo[3];
		this.attrezzi[0] = new Attrezzo("pala", 1);
		this.attrezzi[1] = new Attrezzo("scudo", 2);
		this.attrezzi[2] = new Attrezzo("spada", 3);
		this.stanzaMagica = new StanzaMagica("piena", 2);
		this.stanzaMagica.addAttrezzo(this.attrezzi[0]);
		this.stanzaMagica.addAttrezzo(this.attrezzi[1]);
		this.stanzaMagica.addAttrezzo(this.attrezzi[2]);
	}

	@Test
	void testStanzaMagicaPienaSogliaMagicaSuperata() {
		assertEquals(this.stanzaMagica.getAttrezzo("adaps").getNome(), "adaps");
	}

	@Test
	void testStanzaMagicaPienaSogliaMagicaSuperataDiUnAttrezzo() {
		this.stanzaMagica.addAttrezzo(this.attrezzi[1]);
		assertEquals(this.stanzaMagica.getAttrezzo("oducs").getNome(), "oducs");
	}
	
	@Test
	void testStanzaMagicaPienaSogliaMagicaSuperataDiDueAttrezzi() {
		this.stanzaMagica.addAttrezzo(this.attrezzi[1]);
		this.stanzaMagica.addAttrezzo(this.attrezzi[0]);
		assertEquals(this.stanzaMagica.getAttrezzo("alap").getNome(), "alap");
	}

	@Test
	void testStanzaMagicaPienaSogliaMagicaSuperataDiDuePrimoAttrezzo() {
		this.stanzaMagica.addAttrezzo(this.attrezzi[1]);
		this.stanzaMagica.addAttrezzo(this.attrezzi[0]);
		assertEquals(this.stanzaMagica.getAttrezzo("pala").getNome(), "pala");
	}

	@Test
	void testStanzaMagicaPienaSogliaMagicaSuperataAttrezzoInvertitoRimosso() {
		this.stanzaMagica.addAttrezzo(this.attrezzi[1]);
		this.stanzaMagica.removeAttrezzo(this.attrezzi[1]);
		assertNull(this.stanzaMagica.getAttrezzo("scudo"));
	}
	@Test
	void testIsMagica() {
		assertTrue(this.stanzaMagica.isMagica());
	}
}
