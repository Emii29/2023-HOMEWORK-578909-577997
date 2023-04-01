package tests;

import static org.junit.jupiter.api.Assertions.*;
import it.uniroma3.diadia.ambienti.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LabirintoTest {

	private Labirinto labirinto;
	private Stanza stanza1;
	@BeforeEach
	void setUp() {
		this.labirinto = new Labirinto();
		this.stanza1 = new Stanza("stanza1");
	}

	@Test
	void testGetStanzaVincente() {
		assertEquals("Biblioteca", this.labirinto.getStanzaVincente().getNome());
	}

	@Test
	void testSetStanzaCorrente() {
		this.labirinto.setStanzaCorrente(stanza1);
		assertEquals("stanza1", this.labirinto.getStanzaCorrente().getNome());
	}

	@Test
	void testGetStanzaCorrente() {
		this.labirinto.setStanzaCorrente(stanza1);
		assertEquals("stanza1", this.labirinto.getStanzaCorrente().getNome());
	}

}
