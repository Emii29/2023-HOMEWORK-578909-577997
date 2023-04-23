package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.IO;

public class ComandoPrendi implements Comando {
	private String nomeAttrezzo;
	
	@Override
	public void esegui(Partita partita, IO io) {
		Attrezzo daprendere = partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		//Caso in cui l'attrezzo richiesto esiste nella stanza
		if (daprendere != null && partita.getGiocatore().getBorsa().getPeso() + daprendere.getPeso() < partita.getGiocatore().getBorsa().getPesoMax()){
			partita.getGiocatore().getBorsa().addAttrezzo(daprendere);
			partita.getLabirinto().getStanzaCorrente().removeAttrezzo(daprendere);
			io.mostraMessaggio("Hai raccolto " + daprendere + ".");
		}
		else if (daprendere != null && partita.getGiocatore().getBorsa().getPeso() + daprendere.getPeso() > partita.getGiocatore().getBorsa().getPesoMax()){
			io.mostraMessaggio("La borsa non supporta tutto questo peso, lascia qualcosa a terra per prendere questo oggetto.");
		}
		//Caso in cui l'attrezzo richiesto non esiste nella stanza
		if (daprendere == null) {
			io.mostraMessaggio("Non ho trovato alcun attrezzo chiamato " + nomeAttrezzo + ".");
			io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

}
