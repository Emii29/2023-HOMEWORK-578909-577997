package it.uniroma3.diadia;
import java.util.*;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;

public class IOSimulator implements IO{

	private Map<Integer, String> listaInput;
	private List<String> listaOutput;
	int indiceIstruzione;

	public IOSimulator(Map<Integer, String> listaIstruzioni) {
		this.indiceIstruzione = 0;
		this.listaInput = new TreeMap<>(listaIstruzioni);
		this.listaOutput = new ArrayList<>();
	}
	
	@Override
	public void mostraMessaggio(String messaggio) {
		listaOutput.add(messaggio);
	}

	@Override
	public String leggiRiga() {
		this.indiceIstruzione++;
		return this.getIstruzione(indiceIstruzione);
	}

	public String getIstruzione(int indice) {
		this.indiceIstruzione = indice;
		return listaInput.get(indice);
	}

	public int getIndiceIstruzione() {
		return this.indiceIstruzione;
	}
	
	public void setIndiceIstruzione(int indice) {
		this.indiceIstruzione = indice;
	}

	public boolean hasNextIstruzione() {
		return listaInput.containsKey(this.indiceIstruzione++);
	}

	public String nextIstruzione() {
		return listaInput.get(this.indiceIstruzione++);
	}
	
	public List<String> getListaOutput(){
		return this.listaOutput;
	}
	
	public static IOSimulator IOSimulatorMonolocale(Map<Integer,String> listaIstruzioni, IOSimulator io) {
		IOSimulator ios1 = io;
		Labirinto labirinto = new LabirintoBuilder()
				 .addStanzaIniziale("Atrio")
				 .addAttrezzo("osso", 5)
				 .addStanzaVincente("Biblioteca")
				 .addAdiacenza("Atrio", "Biblioteca", "nord")
				 .getLabirinto();
		DiaDia gioco = new DiaDia(ios1, labirinto);
		gioco.gioca();
		return ios1;
	}
	
	public static IOSimulator IOSimulatorBilocale(Map<Integer,String> listaIstruzioni, IOSimulator io) {
		IOSimulator ios2 = io;
		Labirinto labirinto = new LabirintoBuilder()
				 .addStanzaIniziale("Atrio")
				 .addAttrezzo("osso", 5)
				 .addStanza("Aula N10")
				 .addAttrezzo("piccone", 4)
				 .addStanzaVincente("Biblioteca")
				 .addAdiacenza("Atrio", "Biblioteca", "nord")
				 .addAdiacenza("Atrio", "Aula N10", "est")
				 .getLabirinto();
		DiaDia gioco = new DiaDia(ios2, labirinto);
		gioco.gioca();
		return ios2;
	}
	
	public static IOSimulator IOSimulatorCompleto(Map<Integer,String> listaIstruzioni, IOSimulator io) {
		IOSimulator ios3 = io;
		Labirinto labirinto = new LabirintoBuilder()
				 .addStanzaIniziale("Atrio")
				 .addAttrezzo("Osso", 5)
				 .addStanza("Aula N11")
				 .addStanza("Aula N10")
				 .addAttrezzo("Torcia",1)
				 .addStanzaBuia("Scantinato", "Torcia")
				 .addAttrezzo("Chiave", 3)
				 .addStanzaBloccata("Corridoio", "est", "Chiave")
				 .addStanzaVincente("Biblioteca")
				 .addAdiacenza("Atrio", "Corridoio", "nord")
				 .addAdiacenza("Atrio", "Aula N10", "sud")
				 .addAdiacenza("Atrio", "Aula N11", "est")
				 .addAdiacenza("Corridoio", "Biblioteca", "est")
				 .addAdiacenza("Aula N10", "Scantinato", "sud")
				 .getLabirinto();
		DiaDia gioco = new DiaDia(ios3, labirinto);
		gioco.gioca();
		return ios3;
	}
}
