package it.uniroma3.diadia;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	private Partita partita;
	private IOConsole console;


	public DiaDia(IOConsole console) {
		this.partita = new Partita();
		this.console = console;
	}

	public void gioca() {
		String istruzione; 
		console.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do		
			istruzione = console.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando daEseguire = new Comando(istruzione);

		/**
		 * Invocazione dei comandi da parte dell'utente 
		 */

		//Caso in cui non e' stato digitato nulla
		if (daEseguire.sconosciuto()) {
			console.mostraMessaggio("Digita qualcosa");
			return false;
		} 
		//Caso in cui viene invocato il comando fine
		else if (daEseguire.getNome().equals("fine")) {
			daEseguire.fine(console);
			return true;
		} 
		//Caso in cui viene invocato il comando vai
		else if (daEseguire.getNome().equals("vai"))
			daEseguire.vai(this.partita, this.console, daEseguire.getParametro());
		//Caso in cui viene invocato il comando prendi
		else if (daEseguire.getNome().equals("prendi"))
			daEseguire.prendi(this.partita, this.console, daEseguire.getParametro());
		//Caso in cui viene invocato il comando posa
		else if (daEseguire.getNome().equals("posa"))
			daEseguire.posa(this.partita, this.console, daEseguire.getParametro());
		//Caso in cui viene invocato il comando aiuto
		else if (daEseguire.getNome().equals("aiuto"))
			daEseguire.aiuto(this.console);
		//Caso in cui viene invocato il comando borsa
		else if (daEseguire.getNome().equals("borsa"))
			daEseguire.borsa(this.partita, this.console);
		//Caso in cui viene invocato il comando infostanza
		else if (daEseguire.getNome().equals("infostanza"))
			daEseguire.infostanza(this.partita, this.console);
		//Caso in cui il comando non e' riconosciuto	
		else
			console.mostraMessaggio("Comando sconosciuto, fai aiuto per conoscere i comandi disponibili");
		//Check se la stanza corrente e' quella vincente
		if (this.partita.vinta()) {
			console.mostraMessaggio("Hai vinto!");
			return true;
		}
		//Check se sono rimasti dei cfu al giocatore
		else if (this.partita.persa()) {
			console.mostraMessaggio("Hai perso.");
			return true;
		}
		//Ritorna false se nessuna delle condizioni precedenti e' soddisfatta
		else {
			return false;
		}
	}

	public static void main(String[] argc) {
		IOConsole console = new IOConsole();
		DiaDia gioco = new DiaDia(console);
		gioco.gioca();
	}
}