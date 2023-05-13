package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	String direzioneBloccata;
	String attrezzoNecessario;
	
	public StanzaBloccata(String nome, String direzione, String nomeAttrezzo) {
		super(nome);
		this.direzioneBloccata = direzione;
		this.attrezzoNecessario = nomeAttrezzo;
	}
	/**
	 * Ritorna un riferimento alla stanza stessa se l'attrezzo sbloccante non e' presente nella stanza e se la direzione e' bloccata.
	 * Ritorna la stanza adiacente in quella direzione se l'attrezzo sbloccante e' presente nella stanza.
	 */
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if (direzioneBloccata.equals(direzione) && !(hasAttrezzo(attrezzoNecessario))) {
			return this;			
		}
		else
			return super.getStanzaAdiacente(direzione);
	}
	
	/**
	 * La descrizione cambia a seconda se l'attrezzo sbloccante e' presente o no nella stanza.
	 */
	
	@Override
	public String getDescrizione() {
		if (!(hasAttrezzo(attrezzoNecessario)))
		return ("La porta a " + direzioneBloccata + " e' bloccata, lascia a terra un: "+attrezzoNecessario+" per aprirla");
		else
			return super.getDescrizione();
	}
}