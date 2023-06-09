package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;

public class ComandoNonValido extends AbstractComando {

	@Override
	public void esegui(Partita partita, IO io) {
		io.mostraMessaggio("Comando sconosciuto. Digita 'aiuto' per un elenco di comandi.");
	}
}
