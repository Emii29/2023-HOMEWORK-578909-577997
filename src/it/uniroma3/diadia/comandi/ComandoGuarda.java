package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;

public class ComandoGuarda extends AbstractComando {

	@Override
	public void esegui(Partita partita, IO io) {
		io.mostraMessaggio("\n");
		io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("CFU rimanenti: " + partita.getGiocatore().getCfu());
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		io.mostraMessaggio("\n");	
	}

}
