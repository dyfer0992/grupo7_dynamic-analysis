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
	private int numPersonas;

	public Agenda2 () 
	{
		cent = new NodoAgenda (null, null);
		cab = new NodoAgenda (null, cent);
		numPersonas = 0;
	}

	public boolean aniadirPersona (Persona p)
	{
		NodoAgenda ant = this.cab;
		NodoAgenda act = ant.sig;
		NodoAgenda nuevoNodo;
		boolean resul = false;

		if (this.cab.sig==this.cent) 
		{
			nuevoNodo = new NodoAgenda(p, act);
			ant.sig = nuevoNodo;
			numPersonas = 1;
			resul=true;
		}
		else{
			while (act!=this.cent) 
			{
				act=act.sig;
				ant=ant.sig;
			}
			numPersonas++;
			nuevoNodo = new NodoAgenda(p, act);
			ant.sig = nuevoNodo;
			resul = true;
		}
		return resul;
	}

	public boolean eliminarPersona (String nombre)
	{
		NodoAgenda ant = this.cab;
		NodoAgenda act = ant.sig;
		if (this.cab != this.cent) 
		{
			while (act.info.obtenerNombre()!=nombre)
			{
				act=act.sig;
				ant=ant.sig;
			}
			act=act.sig;
			ant.sig=act;
			return true;
		}
		else return false;
	}
	public Persona quitarPrimero ()
	{
		Persona p = new Persona();
		if (this.cab == this.cent)
		{
			p = this.cab.sig.info;
			this.cab.sig = cab.sig.sig;

			numPersonas--;
		}
		return p;
	}
	public boolean estaVacia ()
	{
		return this.cab == this.cent;
	}
	public int numeroPersonas ()
	{
		NodoAgenda aux = cab;
		int i = 0;
		if (aux.sig != null)
		{
			while (aux.sig != cent)
			{
				i++;
				aux = aux.sig;
			}
			return i;
		}
		else
		{
			return 0;
		}
	}
}

