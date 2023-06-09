package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoRegala extends AbstractComando {

	@Override
	public void esegui(Partita partita, IO io) {
		Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(this.getParametro());
		if (partita.getLabirinto().getStanzaCorrente().getPersonaggio() != null && partita.getGiocatore().getBorsa().hasAttrezzo(getParametro())) {
			io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getPersonaggio().riceviRegalo(attrezzo, partita));
			partita.getGiocatore().getBorsa().removeAttrezzo(partita.getGiocatore().getBorsa().getAttrezzo(getParametro())); 
		}
		else if (this.getParametro() == null) {
			io.mostraMessaggio("Specifica l'attrezzo da regalare.");
		}
		else
		io.mostraMessaggio("Non ci sono personaggi nella stanza.");
	}
}
