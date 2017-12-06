package agenda;

import java.io.IOException;

import persona.Persona;


	public interface Agenda 
	{
		boolean aniadirPersona (Persona p);
		boolean eliminarPersona (String nombre);
		Persona quitarPrimero ();
		int numeroPersonas ();
		boolean guardarAgenda () throws IOException;
		boolean recuperarAgenda () throws IOException;
		
	}
