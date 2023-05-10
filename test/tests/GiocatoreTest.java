package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

class GiocatoreTest {
	private Giocatore giocatore;
	
	@BeforeEach
	void setUp() {
		this.giocatore = new Giocatore();
	}

	@Test
	void testGetCfuIniziali() {
		assertEquals(this.giocatore.getCfu(), 20);
	}

	@Test
	void testGetCfuGenerale() {
		this.giocatore.setCfu(12);
		assertEquals(this.giocatore.getCfu(), 12);
	}
	
	@Test
	void testSetCfuGenerale() {
		this.giocatore.setCfu(14);
		assertEquals(this.giocatore.getCfu(), 14);
	}

}
