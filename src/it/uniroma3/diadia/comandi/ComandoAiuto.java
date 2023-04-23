package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;

public class ComandoAiuto implements Comando {
	static final private String[] elencoComandi = {"Comandi disponibili:", "vai", "aiuto", "fine", "prendi", "posa", "borsa", "infostanza"};

	@Override
	public void esegui(Partita partita, IO io) {
		for(int i=0; i< elencoComandi.length; i++)
			io.mostraMessaggio(elencoComandi[i]);
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}
}
