package it.uniroma3.diadia;
import java.util.Scanner;
/**
 * Classe Console che si occupa della gestione dell'I/O
 * @author Docente di POO
 * @version base
 */
public class IOConsole {
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}
	public String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		return riga;
	}
}
