package it.uniroma3.diadia.personaggi;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import java.util.*;

public class Strega extends AbstractPersonaggio {

	private static final String MESSAGGIO_SALUTATA = "Solo perche' mi hai salutato, non ti mando in uno scantinato!";
	private static final String MESSAGGIO_NON_SALUTATA = "Sei proprio una brutta persona, vai nella stanza con meno attrezzi!";

	public Strega(String nome, String presentaz) {
		super(nome, presentaz);
	}

	@Override
	public String agisci(Partita partita) {
		String msg;
		List<Stanza> stanzeAdiacenti = new ArrayList(partita.getLabirinto().getStanzaCorrente().getMapStanzeAdiacenti().values());

		Stanza maxAtrezzi = stanzeAdiacenti.get(0);
		Stanza minAtrezzi = stanzeAdiacenti.get(0);

		for(Stanza s : stanzeAdiacenti) {
			if(s != null) {
				if(s.getAttrezzi().size() > maxAtrezzi.getAttrezzi().size())
					maxAtrezzi = s;
				if(s.getAttrezzi().size() < minAtrezzi.getAttrezzi().size())
					minAtrezzi = s;
			}
		}

		if(this.haSalutato()) {
			partita.getLabirinto().setStanzaCorrente(maxAtrezzi);
			msg = MESSAGGIO_SALUTATA;
		} else {
			partita.getLabirinto().setStanzaCorrente(minAtrezzi);
			msg = MESSAGGIO_NON_SALUTATA;
		}

		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		return "HIHIHIHIHIHI";
	}

}
