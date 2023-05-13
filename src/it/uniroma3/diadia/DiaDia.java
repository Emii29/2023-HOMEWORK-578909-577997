package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il metodo gioca
 *
 * Questa e' la classe principale la quale crea e istanzia tutte le altre.
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
			"Per visualizzare una lista di comandi digita: 'aiuto'.";

	private Partita partita;
	private IO io;


	public DiaDia(IO io, Labirinto labirinto) {
		this.partita = new Partita(labirinto);
		this.io = io;
	}

	public void gioca() {
		String istruzione; 
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do		
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   

	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();
		
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita, this.io);
		if (this.partita.vinta())
			io.mostraMessaggio("Hai vinto!");
		if (this.partita.persa())
			io.mostraMessaggio("Hai esaurito i CFU...");
		return this.partita.isFinita();
	}


	public static void main(String[] argc) {
		IO io = new IOConsole();
		Labirinto labirinto = new LabirintoBuilder()
				 .addStanzaIniziale("Atrio")
				 .addAttrezzo("Osso", 5)
				 .addStanza("Aula N11")
				 .addStanza("Aula N10")
				 .addAttrezzo("Torcia",1)
				 .addStanzaBuia("Scantinato", "Torcia")
				 .addAttrezzo("Chiave", 3)
				 .addStanzaBloccata("Corridoio", "est", "Chiave")
				 .addStanzaVincente("Biblioteca")
				 .addAdiacenza("Atrio", "Corridoio", "nord")
				 .addAdiacenza("Atrio", "Aula N10", "sud")
				 .addAdiacenza("Atrio", "Aula N11", "est")
				 .addAdiacenza("Corridoio", "Biblioteca", "est")
				 .addAdiacenza("Aula N10", "Scantinato", "sud")
				 .getLabirinto();
		DiaDia gioco = new DiaDia(io, labirinto);
		gioco.gioca();
	}
}