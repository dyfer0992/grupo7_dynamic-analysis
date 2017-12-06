package agenda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import parser.Parser;
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
	
	//Use a logger to log this exception
	private static final Logger LOGGER = Logger.getLogger( Agenda2.class.getName() );

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
	
	public boolean guardarAgenda () { 
	    NodoAgenda act = this.cab.sig;
		Parser p = new Parser();
	    boolean resultado = false;
	    PrintWriter output = null;
	    
		try {
			output = new PrintWriter(new BufferedWriter(new FileWriter("archivo.txt")));
		    
		    while(act.info != null) {
		    	p.ponerPersona(act.info);
		    	act = act.sig;
		        output.println(p.obtenerLinea());
		        resultado = true;
		    }
		} catch (IOException e) {
			LOGGER.log(Level.ALL, "Error al abrir fichero de escritura");
		} finally {
			if(output != null) output.close();
		}
	    
	    return resultado;
	}

	public boolean recuperarAgenda() {
		boolean resul = false;
	    Parser p = new Parser();
	    String cad;
	    BufferedReader bufferentrada = null;
	    
		try {
		    bufferentrada = new BufferedReader(new FileReader("archivo.txt"));

		    if ((cad = bufferentrada.readLine()) != null)
		    {
		      resul = true;
		      do
		      {
		        p.ponerLinea(cad);
		        Persona auxPersona = p.obtenerPersona();
		        if (auxPersona.tieneDatos()) {
		          aniadirPersona(auxPersona);
		        }
		      } while ((cad = bufferentrada.readLine()) != null);
		    }
		} catch (FileNotFoundException e) {
			LOGGER.log(Level.ALL, "No se encuentra el fichero de lectura");
		} catch (IOException e) {
			LOGGER.log(Level.ALL, "Error al abrir el fichero de lectura");
		} finally {
			try {
				if(bufferentrada != null) bufferentrada.close();
			} catch (IOException e) {
				LOGGER.log(Level.ALL, "Error al cerrar fichero de lectura");
			}
		}
	    
	    return resul;
	}
}

