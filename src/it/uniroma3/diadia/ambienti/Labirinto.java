package it.uniroma3.diadia.ambienti;

/**
 * Classe Labirinto che si occupa della gestione del labirinto.
 * @author Emilio Martis/Edoardo Piovano - 578909/577997
 * @version base
 */
public class Labirinto {
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private Stanza stanzaIniziale;
	
//	public Labirinto() {
//	}

//	private void creaStanze() {
//
//		/* crea gli attrezzi */
//		Attrezzo lanterna = new Attrezzo("lanterna",1);
//		Attrezzo osso = new Attrezzo("osso",3);
//		Attrezzo chiave = new Attrezzo("chiave",3);
//		Attrezzo piccone = new Attrezzo("piccone", 7);
//
//		/* crea stanze del labirinto */
//		Stanza atrio = new Stanza("Atrio");
//		Stanza aulaN11 = new Stanza("Aula N11");
//		Stanza aulaN10 = new Stanza("Aula N10");
//		Stanza laboratorio = new Stanza("Laboratorio Campus");
//		Stanza biblioteca = new Stanza("Biblioteca");
//		StanzaBuia stanzaBuia = new StanzaBuia("Stanza Buia", "lanterna");
//		StanzaBloccata segreteria = new StanzaBloccata("Segreteria", "est", "osso");
//		StanzaMagica stanzaMagica = new StanzaMagica("Stanza Magica", 2);
//
//		/* collega le stanze */
//		atrio.impostaStanzaAdiacente("nord", biblioteca);
//		atrio.impostaStanzaAdiacente("est", aulaN11);
//		atrio.impostaStanzaAdiacente("sud", aulaN10);
//		atrio.impostaStanzaAdiacente("ovest", laboratorio);
//		aulaN11.impostaStanzaAdiacente("est", laboratorio);
//		aulaN11.impostaStanzaAdiacente("ovest", atrio);
//		aulaN10.impostaStanzaAdiacente("nord", atrio);
//		aulaN10.impostaStanzaAdiacente("est", aulaN11);
//		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
//		laboratorio.impostaStanzaAdiacente("est", atrio);
//		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
//		laboratorio.impostaStanzaAdiacente("nord", stanzaBuia);
//		laboratorio.impostaStanzaAdiacente("sud", segreteria);
//		biblioteca.impostaStanzaAdiacente("sud", atrio);
//		segreteria.impostaStanzaAdiacente("nord", laboratorio);
//		segreteria.impostaStanzaAdiacente("est", stanzaMagica);
//
//		/* pone gli attrezzi nelle stanze */
//		aulaN10.addAttrezzo(lanterna);
//		atrio.addAttrezzo(osso);
//		aulaN11.addAttrezzo(chiave);
//		aulaN11.addAttrezzo(piccone);
//
//		// il gioco comincia nell'atrio
//		stanzaCorrente = atrio;  
//		stanzaVincente = biblioteca;
//	}

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}
	
	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;	
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}
	
	public void setStanzaIniziale(Stanza stanzaIniziale) {
		this.stanzaIniziale = stanzaIniziale;
	}
}