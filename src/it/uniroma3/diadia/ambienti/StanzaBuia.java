package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {
	private String attrezzoNecessario;
	
	public StanzaBuia(String nome, String nomeAttrezzo) {
		super(nome);
		this.attrezzoNecessario = nomeAttrezzo;
	}
	
	public String getDescrizione() {
		if (hasAttrezzo(this.attrezzoNecessario)) {
			return this.toString();
		}
		else
			return ("Qui c'e' un buio pesto.");
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
}
