package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio {
	private static String MESSAGGIO_CANE = "Woof! Ti ho tolto un CFU!";
	private static String CIBO_PREFERITO= "Osso";

	public Cane(String nome, String presentaz) {
		super(nome, presentaz);
	}

	@Override
	public String agisci(Partita partita) {
		String msg = MESSAGGIO_CANE;
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		StringBuilder risposta = new StringBuilder("Woof! grazie per avermi regalato un ");

		if(attrezzo.getNome().equals(CIBO_PREFERITO)) {
			risposta.append("il mio cibo preferito.");
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(new Attrezzo("Bracciale", 1));
		} else {
		risposta.append(attrezzo.getNome()+",ma non e' il mio cibo preferito, Woof!");
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		}
		
		return risposta.toString();
	}

}
