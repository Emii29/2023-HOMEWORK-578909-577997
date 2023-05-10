package tests;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StanzaTest {
	private Stanza stanzaVuota;
	private Stanza stanzaConUnAttrezzo;
	private Stanza stanzaPiena;
	private Attrezzo[] attrezzi;
	
	@BeforeEach
	void setup() {
		this.attrezzi = new Attrezzo[3];
		this.attrezzi[0] = new Attrezzo("pala", 1);
		this.attrezzi[1] = new Attrezzo("scudo", 2);
		this.attrezzi[2] = new Attrezzo("spada", 3);
		this.stanzaVuota = new Stanza("vuota");
		this.stanzaPiena = new Stanza("piena");
		this.stanzaConUnAttrezzo = new Stanza("semipiena");
		this.stanzaConUnAttrezzo.addAttrezzo(this.attrezzi[2]);
		this.stanzaPiena.addAttrezzo(this.attrezzi[0]);
		this.stanzaPiena.addAttrezzo(this.attrezzi[1]);
		this.stanzaPiena.addAttrezzo(this.attrezzi[2]);
		this.stanzaPiena.impostaStanzaAdiacente("nord", stanzaConUnAttrezzo);
		this.stanzaConUnAttrezzo.impostaStanzaAdiacente("sud", stanzaPiena);
	}

	@Test
	void testImpostaStanzaAdiacente() {
		this.stanzaPiena.impostaStanzaAdiacente("est", stanzaVuota);
		assertEquals(this.stanzaVuota,this.stanzaPiena.getStanzaAdiacente("est"));
	}

	@Test
	void testGetStanzaAdiacenteStanzaVuota() {
		assertNull(this.stanzaVuota.getStanzaAdiacente("sud"));
	}

	@Test
	void testGetMappaStanzeAdiacenti() {
		Map<String,Stanza> mappaStanzeAdiacentiLocale = new HashMap<>();
		mappaStanzeAdiacentiLocale.put("nord", stanzaConUnAttrezzo);
		assertEquals(this.stanzaPiena.getMapStanzeAdiacenti().keySet(),mappaStanzeAdiacentiLocale.keySet());
		assertEquals(this.stanzaPiena.getMapStanzeAdiacenti().get("nord").getNome(),mappaStanzeAdiacentiLocale.get("nord").getNome());
	}

	@Test
	void testGetDirezioni() {
		List<String> listaDirezioni = new ArrayList<>();
		listaDirezioni.add("nord");
		assertEquals(listaDirezioni,this.stanzaPiena.getDirezioni());
	}
	
	@Test
	void testGetStanzaAdiacenteStanzaConUnAttrezzoSbagliata() {
		assertNull(this.stanzaConUnAttrezzo.getStanzaAdiacente("ovest"));
	}	

	@Test
	void testGetStanzaAdiacenteStanzaConUnAttrezzoGiusta() {
		assertEquals(this.stanzaPiena, this.stanzaConUnAttrezzo.getStanzaAdiacente("sud"));
	}	
	
	@Test
	void testGetDescrizioneStanzaVuota() {
		assertEquals(this.stanzaVuota.getDescrizione(), "vuota\nUscite: \nAttrezzi nella stanza: ");
	}

	@Test
	void testGetDescrizioneStanzaConUnAttrezzo() {
		assertEquals(this.stanzaConUnAttrezzo.getDescrizione(), "semipiena\nUscite:  sud\nAttrezzi nella stanza: " + this.attrezzi[2].toString() + " ");
	}

	@Test
	void testGetDescrizioneStanzaPiena() {
		assertEquals(this.stanzaPiena.getDescrizione(), "piena\nUscite:  nord\nAttrezzi nella stanza: " + this.attrezzi[0].toString() + " " + this.attrezzi[1].toString() + " " + this.attrezzi[2].toString() + " ");
	}

	@Test
	void testAddAttrezzoStanzaVuota() {
		Attrezzo chiodo;
		chiodo = new Attrezzo("chiodo", 0);
		assertTrue(stanzaVuota.addAttrezzo(chiodo));
	}

	@Test
	void testAddAttrezzoStanzaConUnAttrezzo() {
		Attrezzo chiodo;
		chiodo = new Attrezzo("chiodo", 0);
		assertTrue(stanzaConUnAttrezzo.addAttrezzo(chiodo));
	}

	@Test
	void testAddAttrezzoStanzaPiena() {
		Attrezzo chiodo;
		chiodo = new Attrezzo("chiodo", 0);
		assertTrue(stanzaPiena.addAttrezzo(chiodo));
	}

	@Test
	void testHasAttrezzoStanzaVuota() {
		assertFalse(stanzaVuota.hasAttrezzo(this.attrezzi[2].getNome()));
	}
	
	@Test
	void testHasAttrezzoStanzaConUnAttrezzo() {
		assertTrue(stanzaConUnAttrezzo.hasAttrezzo(this.attrezzi[2].getNome()));
	}

	@Test
	void testHasAttrezzoStanzaPiena() {
		assertTrue(stanzaPiena.hasAttrezzo(this.attrezzi[2].getNome()));
	}
	
	@Test
	void testGetAttrezzoStanzaVuota() {
		assertNull(stanzaVuota.getAttrezzo("pala"));
	}

	@Test
	void testGetAttrezzoStanzaConUnAttrezzo() {
		assertEquals(this.attrezzi[2],stanzaConUnAttrezzo.getAttrezzo(this.attrezzi[2].getNome()));
	}

	@Test
	void testGetAttrezzoStanzaSenzaUnAttrezzo() {
		assertNull(stanzaConUnAttrezzo.getAttrezzo(this.attrezzi[0].getNome()));
	}
	
	@Test
	void testGetAttrezzoStanzaPiena() {
		assertEquals(this.attrezzi[0],stanzaPiena.getAttrezzo(this.attrezzi[0].getNome()));
	}

	@Test
	void testRemoveAttrezzoStanzaVuota() {
		assertFalse(this.stanzaVuota.removeAttrezzo(this.attrezzi[2]));
	}

	@Test
	void testRemoveAttrezzoPresenteInStanza() {
		assertTrue(this.stanzaConUnAttrezzo.removeAttrezzo(this.attrezzi[2]));
	}

	@Test
	void testRemoveAttrezzoNonPresenteInStanza() {
		assertFalse(this.stanzaConUnAttrezzo.removeAttrezzo(this.attrezzi[1]));
	}

	@Test
	void testRemoveAttrezzoStanzaPiena() {
		assertTrue(this.stanzaPiena.removeAttrezzo(this.attrezzi[0]));
	}

}
