package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;

public class ComandoNonValido implements Comando {

	@Override
	public void esegui(Partita partita, IO io) {
		io.mostraMessaggio("Comando sconosciuto. Digita 'aiuto' per un elenco di comandi.");
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

}
