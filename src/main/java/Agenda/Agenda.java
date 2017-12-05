package Agenda;

import Persona.Persona;


	public interface Agenda 
	{
		boolean aniadirPersona (Persona p);
		boolean eliminarPersona (String nombre);
		Persona quitarPrimero ();
		boolean estaVacia ();
		int numeroPersonas ();
		
	}
