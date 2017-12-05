package Agenda;

import Persona.Persona;


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
	private NodoAgenda cab, cent;
	private int numPersonas;

	public Agenda2 () 
	{
		cent = new NodoAgenda (null, null);
		cab = new NodoAgenda (null, cent);
		numPersonas = 0;
	}

	public boolean aniadirPersona (Persona p)
	{
		NodoAgenda aux = this.cab;
		NodoAgenda ant = this.cab;
		NodoAgenda act = ant.sig;
		aux.info=p;
		boolean resul = false;

		if (this.cab.sig==this.cent) 
		{
			aux.sig=this.cent;
			this.cab.sig=aux;
			resul=true;
		}
		else{
			while (act!=this.cent) 
			{
				act=act.sig;
				ant=ant.sig;
			}
			numPersonas++;
			ant.sig=aux;
			aux.sig=act;
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
		if (cab.sig == null)
		{
			return true;
		}
		else
		{
			return false;
		}
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

