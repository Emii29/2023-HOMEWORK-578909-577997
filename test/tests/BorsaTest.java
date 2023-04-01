package tests;


import static org.junit.jupiter.api.Assertions.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BorsaTest {
	private Borsa borsa;
	private Attrezzo attrezzoUno;
	private Attrezzo attrezzo12;
	
	
	@BeforeEach
	void setUp() {
		this.borsa = new Borsa();
		this.attrezzoUno = new Attrezzo("uno", 1);
		this.attrezzo12 = new Attrezzo("12", 12);
	}

	@Test
	void testAddAttrezzoPerPesoTrue() {
		assertTrue(this.borsa.addAttrezzo(attrezzoUno));
	}
	
	@Test
	void testAddAttrezzoPerPesoFalse() {
		assertFalse(this.borsa.addAttrezzo(attrezzo12));
	}
	
	@Test
	void testAddAttrezzoPerNumeroTrue() {
		for (int i=0; i<7; i++) {
			this.borsa.addAttrezzo(attrezzoUno);
		}
		assertTrue(this.borsa.addAttrezzo(attrezzoUno));
	}
	
	@Test
	void testAddAttrezzoPerNumeroFalse() {
		for (int i=0; i<12; i++) {
			this.borsa.addAttrezzo(attrezzoUno);
		}
		assertFalse(this.borsa.addAttrezzo(attrezzoUno));
	}

	@Test
	void testGetAttrezzoTrue() {
		this.borsa.addAttrezzo(attrezzoUno);
		assertEquals(attrezzoUno, borsa.getAttrezzo("uno"));
	}
	
	@Test
	void testGetAttrezzoNull() {
		assertNull(borsa.getAttrezzo("uno"));
	}


	@Test
	void testIsEmpty() {
		assertTrue(this.borsa.isEmpty());
	}

	@Test
	void testRemoveAttrezzoVuota() {
		assertFalse(this.borsa.removeAttrezzo(attrezzoUno));
	}
	
	@Test
	void testRemoveAttrezzoPiena() {
		this.borsa.addAttrezzo(attrezzoUno);
		assertTrue(this.borsa.removeAttrezzo(attrezzoUno));
	}
}
