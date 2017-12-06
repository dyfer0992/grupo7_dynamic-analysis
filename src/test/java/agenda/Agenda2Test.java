package agenda;

import junit.framework.*;
import org.junit.*;
import org.junit.Test;

import persona.Persona;
import agenda.Agenda2;

public class Agenda2Test extends TestCase {
	
	private Agenda2 agenda;
	private Persona p1;
	private Persona p2;
	private Persona p3;
	
	private static final String PROVINCIA_M = "Madrid";
	
	private void inicializacionPersonas() {
		agenda = new Agenda2();
		p1 = new Persona();
		p2 = new Persona();
		p3 = new Persona();
		
		p1.ponerNombre("Diego");
		p1.ponerApellidos("Trejos");
		p1.ponerAnioNacim(1992);
		p1.ponerCodPostal("28044");
		p1.ponerDireccion("Gran Via");
		p1.ponerPoblacion(PROVINCIA_M);
		p1.ponerProvincia(PROVINCIA_M);
		p1.ponerTelefono("65489756");
		
		p2.ponerNombre("Alvaro");
		p2.ponerApellidos("Arranz");
		p2.ponerAnioNacim(1994);
		p2.ponerCodPostal("25458");
		p2.ponerDireccion("Calle San Juan");
		p2.ponerPoblacion("Guadalajara");
		p2.ponerProvincia("Guadalajara");
		p2.ponerTelefono("94521658");
		
		p3.ponerNombre("Antonio");
		p3.ponerApellidos("Muñoz");
		p3.ponerAnioNacim(1992);
		p3.ponerCodPostal("28942");
		p3.ponerDireccion("Calle Juanito");
		p3.ponerPoblacion(PROVINCIA_M);
		p3.ponerProvincia(PROVINCIA_M);
		p3.ponerTelefono("61235489");
	}
	
	
	@Before
	public void setUp() {
		this.agenda = new Agenda2();
		inicializacionPersonas();
	}
	@After
	public void tearDown() { 
		//tareas a realizar después de cada test
	}
	
	@Test
	public void testAnniadirEnAgendaVacia() {
		assertTrue(agenda.aniadirPersona(p1));
	}
	
	@Test
	public void testAnniadirEnAgendaNoVacia() {
		agenda.aniadirPersona(p1);
		assertTrue(agenda.aniadirPersona(p2));
	}
	

}
