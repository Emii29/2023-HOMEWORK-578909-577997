package tests;

import static org.junit.jupiter.api.Assertions.*;
import it.uniroma3.diadia.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class IOSimulatorTest {
	private Map<Integer, String> listaInput1;
	private Map<Integer, String> listaInput2;
	private Map<Integer, String> listaInput3;
	private List<String> listaOutput;

	
	@BeforeEach
	void setUp() {
		this.listaInput1 = new TreeMap<>();
		this.listaInput2 = new TreeMap<>();
		this.listaInput3 = new TreeMap<>();
		this.listaOutput = new ArrayList<>();
		
		/**
		 * Setup Lista input 1
		 */
		
		this.listaInput1.put(1, "prendi Osso");
		this.listaInput1.put(2, "guarda");
		this.listaInput1.put(3, "vai nord");
		this.listaInput1.put(4, "vai nord");
		this.listaInput1.put(5, "vai nord");
		
		/**
		 * Setup Lista input 2
		 */
		
		this.listaInput2.put(1, "vai nord");
		this.listaInput2.put(2, "vai nord");
		this.listaInput2.put(3, "vai nord");
		
		/**
		 * Setup Lista input 3
		 */

		this.listaInput3.put(1, "vai nord");
		this.listaInput3.put(2, "vai nord");
		this.listaInput3.put(3, "vai nord");
	}
	
	@Test
	void testIOSimulatorMonolocale() throws Exception {
		IOSimulator io = new IOSimulator(listaInput1);
		IOSimulator.IOSimulatorMonolocale(listaInput1, io);
		this.listaOutput = io.getListaOutput();
		assertEquals(listaOutput.get(1),"Hai raccolto Osso (2kg).");
		assertEquals(listaOutput.get(3),"Atrio\n"
				+ "Uscite:  nord\n"
				+ "Attrezzi nella stanza: ");
		assertEquals(listaOutput.get(4),"CFU rimanenti: 20");
		assertEquals(listaOutput.get(5),"\n"
				+ "Contenuto borsa raggruppato per peso: \n"
				+ "[Osso (2kg)]");
		assertEquals(listaOutput.get(7),"N10");
		assertEquals(listaOutput.get(8),"N11");
		assertEquals(listaOutput.get(9),"Hai vinto!");
	}

	@Test
	void testIOSimulatorBilocale() throws Exception  {
		IOSimulator io = new IOSimulator(listaInput2);
		IOSimulator.IOSimulatorBilocale(listaInput2, io);
		this.listaOutput = io.getListaOutput();
		assertEquals("N10", listaOutput.get(1));
		assertEquals("Hai vinto!", listaOutput.get(2));
	}

	@Test
	void testIOSimulatorCompleto() throws Exception  {
		IOSimulator io = new IOSimulator(listaInput3);
		IOSimulator.IOSimulatorCompleto(listaInput3, io);
		this.listaOutput = io.getListaOutput();
		assertEquals("N10", listaOutput.get(1));
		assertEquals("N11", listaOutput.get(2));
		assertEquals("Hai vinto!", listaOutput.get(3));
	}

}
