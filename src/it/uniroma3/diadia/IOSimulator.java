package it.uniroma3.diadia;
import java.util.*;

import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Labirinto;

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
	
	public static IOSimulator IOSimulatorMonolocale(Map<Integer,String> listaIstruzioni, IOSimulator io) throws Exception {
		IOSimulator ios1 = io;
		Labirinto labirinto = Labirinto.newBuilder("labirinto.txt").getLabirinto();
		DiaDia gioco = new DiaDia(ios1, labirinto);
		gioco.gioca();
		return ios1;
	}
	
	public static IOSimulator IOSimulatorBilocale(Map<Integer,String> listaIstruzioni, IOSimulator io) throws Exception {
		IOSimulator ios2 = io;
		Labirinto labirinto = Labirinto.newBuilder("labirinto2.txt").getLabirinto();
		DiaDia gioco = new DiaDia(ios2, labirinto);
		gioco.gioca();
		return ios2;
	}
	
	public static IOSimulator IOSimulatorCompleto(Map<Integer,String> listaIstruzioni, IOSimulator io) throws Exception {
		IOSimulator ios3 = io;
		Labirinto labirinto = Labirinto.newBuilder("labirinto3.txt").getLabirinto();
		DiaDia gioco = new DiaDia(ios3, labirinto);
		gioco.gioca();
		return ios3;
	}
}
