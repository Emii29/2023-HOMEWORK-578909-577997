package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoVai extends AbstractComando {

	/**
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita, IO io) {
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
		Stanza prossimaStanza = null;
		if (this.getParametro() == null) {
			io.mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
		}
		if(this.getParametro()!=null )// && (Direzione.valueOf(this.getParametro()).getClass() != Direzione.class))
			try {
			prossimaStanza = stanzaCorrente.getStanzaAdiacente(Direzione.valueOf(this.getParametro()));
			} catch(IllegalArgumentException e) {
				io.mostraMessaggio("Direzione inesistente");
				return;
			}
			
			if (prossimaStanza == null) {
			io.mostraMessaggio("Direzione inesistente");
			return;
		}

		partita.getLabirinto().setStanzaCorrente(prossimaStanza);
		io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getNome());
		Giocatore giocatore = partita.getGiocatore();
		giocatore.setCfu(giocatore.getCfu() - 1);
	}
}