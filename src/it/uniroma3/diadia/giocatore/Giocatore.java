package it.uniroma3.diadia.giocatore;
/**
 * Classe giocatore che si occupa delle statistiche del giocatore
 * @author Emilio Martis/Edoardo Piovano - 578909/577997
 * @version base
 * @see Borsa
 */
public class Giocatore {
	static final private int CFU_INIZIALI = 20;
	private int cfu;
	Borsa borsa;

	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}
	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}
	public Borsa getBorsa() {
		return borsa;
	}	
}