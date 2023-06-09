package it.uniroma3.diadia;
import java.util.Scanner;
/**
 * Classe Console che si occupa della gestione dell'I/O
 * @author Docente di POO
 * @version base
 */
public class IOConsole implements IO{
	
	Scanner scannerDiLinee;
	
	public IOConsole(Scanner scanner) {
		this.scannerDiLinee = scanner;
	}
	
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}
	public String leggiRiga() {
		String riga = scannerDiLinee.nextLine();
		return riga;
	}
}
