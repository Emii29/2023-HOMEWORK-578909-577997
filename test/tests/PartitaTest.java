package tests;

import it.uniroma3.diadia.ambienti.*;
import static org.junit.jupiter.api.Assertions.*;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PartitaTest {
	private Partita partita;
	private Stanza stanza1;
	
	@BeforeEach
	void setUp()  {
		Labirinto labirinto = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		this.partita = new Partita(labirinto);
		this.stanza1 = new Stanza("Stanza1");

	}

	@Test
	void testCheckPartitaVintaTrue() {
		this.partita.getLabirinto().setStanzaCorrente(this.partita.getLabirinto().getStanzaVincente());
		assertTrue(this.partita.vinta());
	}

	@Test
	void testCorrispondenzaStanzaVincente() {
		this.partita.getLabirinto().setStanzaCorrente(this.partita.getLabirinto().getStanzaVincente());
		assertEquals(this.partita.getLabirinto().getStanzaCorrente().getNome(),this.partita.getLabirinto().getStanzaVincente().getNome());
	}
	
	@Test
	void testCheckPartitaVintaFalse() {
		this.partita.getLabirinto().setStanzaCorrente(stanza1);
		assertFalse(this.partita.vinta());
	}

	@Test
	void testCheckPartitaPersaTrue() {
		this.partita.getGiocatore().setCfu(0);
		assertTrue(this.partita.persa());
	}

	@Test
	void testCheckPartitaPersaFalse() {
		this.partita.getGiocatore().setCfu(20);
		assertFalse(this.partita.persa());
	}
}
