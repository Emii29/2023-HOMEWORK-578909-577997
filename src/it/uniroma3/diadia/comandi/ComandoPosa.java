package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.IO;

public class ComandoPosa implements Comando {
	private String nomeAttrezzo;
	
	@Override
	public void esegui(Partita partita, IO io) {
		Attrezzo daposare = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if (daposare != null) {
			partita.getGiocatore().getBorsa().removeAttrezzo(daposare);
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(daposare);
			io.mostraMessaggio("Hai lasciato a terra " + nomeAttrezzo + ".");
		}
		else
			io.mostraMessaggio("Non possiedi " + nomeAttrezzo + " nella borsa.");
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

}
