package agenda;

import junit.framework.*;
import org.junit.*;
import org.junit.Test;

import agenda.Agenda2;

public class Agenda2Test extends TestCase {
	
	private Agenda2 agenda;
	
	@BeforeClass
	public static void setUpClass() throws Exception { 
		//Inicialización general de variables, escritura del log...
	}
	@AfterClass
	public static void tearDownClass() throws Exception { 
		//Liberación de recursos, escritura en el log...
	}
	@Before
	public void setUp() { 
		//Inicialización de variables antes de cada Test
		this.agenda = new Agenda2();
	}
	@After
	public void tearDown() { 
		//Tareas a realizar después de cada test
	}
	
	@Test
	public void testPrueba() {
		assertTrue(true);
	}
	
	

}
