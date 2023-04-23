package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.giocatore.*;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Labirinto
 * @see Giocatore
 * @version base
 */

public class Partita {
	private Giocatore giocatore;
	private Labirinto labirinto;

	public Partita(){
		this.labirinto = new Labirinto();
		this.giocatore = new Giocatore();
	}

	/**
	 * Ritorna l'oggetto labirinto
	 * @return
	 */
	public Labirinto getLabirinto() {
		return labirinto;
	}

	public void setLabirinto (Labirinto labirinto) {
		this.labirinto = labirinto;
	}
	/**
	 * Ritorna l'oggetto giocatore
	 * @return
	 */
	public Giocatore getGiocatore() {
		return giocatore;
	}

	public void setGiocatore (Giocatore giocatore) {
		this.giocatore = giocatore;
	}	

	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return labirinto.getStanzaCorrente().getNome().equals(labirinto.getStanzaVincente().getNome());

	}
	/**
	 * Persa:
	 * @return true se hai perso la partita, false in caso contrario
	 */
	public boolean persa() {
		return this.giocatore.getCfu() == 0;
	}
	
	public boolean isFinita() {
		return (vinta() || persa());
	}
}
