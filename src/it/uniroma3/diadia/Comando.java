package it.uniroma3.diadia;


import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Questa classe modella un comando.
 * Un comando consiste al piu' di due parole:
 * il nome del comando ed un parametro
 * su cui si applica il comando.
 * (Ad es. alla riga digitata dall'utente "vai nord"
 *  corrisponde un comando di nome "vai" e parametro "nord").
 *
 * @author  docente di POO
 * @version base
 * 
 */

public class Comando {
	static final private String[] elencoComandi = {"Comandi disponibili:", "vai", "aiuto", "fine", "prendi", "posa", "borsa", "infostanza"};
	private String nome;
	private String parametro;

	public Comando(String istruzione) {

		Scanner scannerDiParole = new Scanner(istruzione);

		// prima parola: nome del comando
		if (scannerDiParole.hasNext())
			this.nome = scannerDiParole.next(); 

		// seconda parola: eventuale parametro
		if (scannerDiParole.hasNext())
			this.parametro = scannerDiParole.next();
	}

	public String getNome() {
		return this.nome;
	}

	public String getParametro() {
		return this.parametro;
	}
	public boolean sconosciuto() {
		return (this.nome == null);
	}

	public String[] getElencoComandi() {
		return elencoComandi;
	}


	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	public void aiuto(IOConsole console) {
		Comando aiuto = new Comando("");
		for(int i=0; i< aiuto.getElencoComandi().length; i++)
			console.mostraMessaggio(aiuto.getElencoComandi()[i]);
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	public void vai(Partita partita, IOConsole console, String direzione) {
		if(direzione==null)
			console.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			console.mostraMessaggio("Direzione inesistente.");
		else {
			partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			//Il giocatore perde 1 CFU per ogni spostamento
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1);
			//Stampa le statistiche della stanza corrente e del giocatore
			console.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
			console.mostraMessaggio("Cfu rimanenti: " + partita.getGiocatore().getCfu());
		}
	}
	/**
	 * Implementazione del comando prendi che permette di raccogliere un attrezzo da una stanza.
	 * @param nomeAttrezzo
	 */

	public void prendi(Partita partita, IOConsole console, String nomeAttrezzo) {
		Attrezzo daprendere = partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		//Caso in cui l'attrezzo richiesto esiste nella stanza
		if (daprendere != null && partita.getGiocatore().getBorsa().getPeso() + daprendere.getPeso() < partita.getGiocatore().getBorsa().getPesoMax()){
			partita.getGiocatore().getBorsa().addAttrezzo(daprendere);
			partita.getLabirinto().getStanzaCorrente().removeAttrezzo(daprendere);
			console.mostraMessaggio("Hai raccolto " + daprendere + ".");
		}
		else if (daprendere != null && partita.getGiocatore().getBorsa().getPeso() + daprendere.getPeso() > partita.getGiocatore().getBorsa().getPesoMax()){
			console.mostraMessaggio("La borsa non supporta tutto questo peso, lascia qualcosa a terra per prendere questo oggetto.");
		}
		//Caso in cui l'attrezzo richiesto non esiste nella stanza
		if (daprendere == null) {
			console.mostraMessaggio("Non ho trovato alcun attrezzo chiamato " + nomeAttrezzo + ".");
			console.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		}
	}
	public void borsa(Partita partita, IOConsole console) {
		console.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
	}

	public void posa(Partita partita, IOConsole console, String nomeAttrezzo){
		Attrezzo daposare = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if (daposare != null) {
			partita.getGiocatore().getBorsa().removeAttrezzo(daposare);
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(daposare);
			console.mostraMessaggio("Hai lasciato a terra " + nomeAttrezzo + ".");
		}
		else
			console.mostraMessaggio("Non possiedi " + nomeAttrezzo + " nella borsa.");
	}

	public void infostanza(Partita partita, IOConsole console) {
		console.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());	}

	public void fine(IOConsole console) {
		console.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}
}