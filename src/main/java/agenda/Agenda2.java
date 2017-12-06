package agenda;

import persona.Persona;


class NodoAgenda 
{
	Persona info;
	NodoAgenda sig;
	NodoAgenda (Persona p, NodoAgenda siguiente) 
	{
		info = p;
		sig = siguiente;
	}
}


public class Agenda2 implements Agenda 
{
	private NodoAgenda cab;
	private NodoAgenda cent;

	public Agenda2 () 
	{
		cent = new NodoAgenda (null, null);
		cab = new NodoAgenda (null, cent);
	}

	public boolean aniadirPersona (Persona p)
	{
		NodoAgenda ant = this.cab;
		NodoAgenda act = ant.sig;
		NodoAgenda nuevoNodo;
		boolean resul = false;
		
		if (act.info == null) {
			nuevoNodo = new NodoAgenda(p, act);
			ant.sig = nuevoNodo;
			resul= true;
		} else {
			while(act.info != null && act.info.obtenerNombreApellidos().compareTo(p.obtenerNombreApellidos()) < 0) {
				ant = act;
				act = act.sig;
			}
		
			if (act == this.cent || act.info.obtenerNombreApellidos().compareTo(p.obtenerNombreApellidos()) > 0) {
				nuevoNodo = new NodoAgenda(p, act);
				ant.sig = nuevoNodo;
				resul= true;
			}
		}
		return resul;
	}

	public boolean eliminarPersona (String nombre)
	{
		NodoAgenda ant = this.cab;
		NodoAgenda act = ant.sig;
		boolean resul = false;
		if (act.info != null) 
		{
			while (act.info != null && act.info.obtenerNombreApellidos().compareTo(nombre) < 0)
			{
				act=act.sig;
				ant=ant.sig;
			}
			if(act.info != null && act.info.obtenerNombreApellidos().compareTo(nombre) == 0) {
				ant.sig=act.sig;
				resul = true;
			}
		}
		return resul;
	}
	
	public Persona quitarPrimero ()
	{
		Persona p = null;
		if (this.cab.sig.info != null) {
			p = this.cab.sig.info;
			this.cab.sig = this.cab.sig.sig;
		}
		return p;
	}
	
	
	public int numeroPersonas ()
	{
		int num = 0;
		NodoAgenda ant = this.cab;
		
		while(ant.sig != this.cent) {
			num++;
			ant = ant.sig;
		}
		
		return num;
	}
}

