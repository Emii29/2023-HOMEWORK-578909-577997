package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public abstract class AbstractPersonaggio {
	private String nome;
	private boolean salutato;
	private String presentazione;
	
	public AbstractPersonaggio(String nome, String presentaz) {
		this.nome = nome;
		this.presentazione = presentaz;
		this.salutato = false;
		}
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setPresentazione(String presentaz) {
		this.presentazione = presentaz;
	}
	
	public String getPresentazione() {
		return this.presentazione;
	}
	
	
	public boolean haSalutato() {
		return this.salutato;
	}
	
	public String saluta() {
		StringBuilder risposta =
				new StringBuilder("Ciao, io sono ");
		risposta.append(this.getNome()+".");
		if (!salutato)
			risposta.append(this.presentazione);
		else
			risposta.append("Ci siamo gia' presentati.");
		this.salutato = true;
		return risposta.toString();
	}
	
	abstract public String agisci(Partita partita);
	abstract public String riceviRegalo(Attrezzo attrezzo, Partita partita);
	
	@Override
	public String toString() {
		return this.getNome();
	}
	
}