package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;

public class ComandoAiuto extends AbstractComando {
	static final private String[] elencoComandi = {"Comandi disponibili:", "vai", "aiuto", "fine", "prendi", "posa", "guarda", "regala", "saluta", "interagisci"};

	@Override
	public void esegui(Partita partita, IO io) {
		for(int i=0; i< elencoComandi.length; i++)
			io.mostraMessaggio(elencoComandi[i]);
	}

}
