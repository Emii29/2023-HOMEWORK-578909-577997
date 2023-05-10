package tests;

import static org.junit.jupiter.api.Assertions.*;
import it.uniroma3.diadia.ambienti.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LabirintoTest {

	private Labirinto labirinto;
	private Stanza stanza1;
	private Stanza stanzaVincente;
	@BeforeEach
	void setUp() {
		this.labirinto = new Labirinto();
		this.stanza1 = new Stanza("stanza1");
		this.stanzaVincente = new Stanza("StanzaVincente");
	}
	@Test
	void testGetStanzaIniziale() {
		this.labirinto.setStanzaIniziale(stanza1);
		assertEquals(stanza1.getNome(), this.labirinto.getStanzaIniziale().getNome());
	}
	
	@Test
	void testGetStanzaVincente() {
		this.labirinto.setStanzaIniziale(stanza1);
		this.labirinto.setStanzaVincente(stanzaVincente);
		assertEquals(stanzaVincente.getNome(), this.labirinto.getStanzaVincente().getNome());
	}

	@Test
	void testSetStanzaCorrente() {
		this.labirinto.setStanzaCorrente(stanza1);
		this.labirinto.setStanzaIniziale(stanza1);
		assertEquals(this.labirinto.getStanzaIniziale().getNome(), this.labirinto.getStanzaCorrente().getNome());
	}

	@Test
	void testGetStanzaCorrente() {
		this.labirinto.setStanzaCorrente(stanza1);
		assertEquals(stanza1.getNome(), this.labirinto.getStanzaCorrente().getNome());
	}

}
