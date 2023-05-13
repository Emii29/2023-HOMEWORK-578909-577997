package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {
	private String attrezzoNecessario;
	
	public StanzaBuia(String nome, String nomeAttrezzo) {
		super(nome);
		this.attrezzoNecessario = nomeAttrezzo;
	}
	/**
	 * La descrizione cambia a seconda se l'attrezzo illuminante e' presente nella stanza.
	 */
	public String getDescrizione() {
		if (hasAttrezzo(this.attrezzoNecessario)) {
			return this.toString();
		}
		else
			return ("Qui c'e' un buio pesto.");
	}
}
