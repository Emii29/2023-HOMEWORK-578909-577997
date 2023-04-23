package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	String direzioneBloccata;
	String attrezzoNecessario;
	
	public StanzaBloccata(String nome, String direzione, String nomeAttrezzo) {
		super(nome);
		this.direzioneBloccata = direzione;
		this.attrezzoNecessario = nomeAttrezzo;
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if (direzioneBloccata.equals(direzione) && !(hasAttrezzo(attrezzoNecessario))) {
			return this;			
		}
		else
			return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		if (!(hasAttrezzo(attrezzoNecessario)))
		return ("La porta a " + direzioneBloccata + " e' bloccata, lascia a terra un: "+attrezzoNecessario+" per aprirla");
		else
			return super.getDescrizione();
	}
}