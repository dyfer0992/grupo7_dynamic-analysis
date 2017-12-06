package persona;

public class Persona 
{
	private String nombre;
	private String apellidos;
	private String direccion;
	private String poblacion;
	private String provincia;
	private String codigoPostal;
	private String telefono;
	private int anioNacim;
	
	public Persona () 
	{
		nombre = "";
		apellidos = "";
		direccion = "";
		poblacion = "";
		provincia = "";
		codigoPostal = "";
		telefono = "";
		anioNacim = 0;
	}
	public boolean tieneDatos ()
	{
		return  !nombre.equals("") && !apellidos.equals("") && !telefono.equals("");	
	}
	
	public void ponerNombre (String nombreNuevo)
	{
		this.nombre = nombreNuevo;
	}
	
	public void ponerApellidos (String apellidosNuevo)
	{
		this.apellidos = apellidosNuevo;
	}
	
	public void ponerDireccion (String calle)
	{
		this.direccion = calle;
	}
	
	public void ponerPoblacion (String poblacionNueva)
	{
		this.poblacion = poblacionNueva;
	}
	
	public void ponerProvincia (String provinciaNueva)
	{
		this.provincia = provinciaNueva;
	}
	
	public void ponerCodPostal (String codPostal)
	{
		this.codigoPostal = codPostal;
	}
	
	public void ponerTelefono (String tfno)
	{
		this.telefono = tfno;
	}
	
	public void ponerAnioNacim (int anio)
	{
		this.anioNacim = anio;
	}
	
	public String obtenerNombre ()
	{
		return nombre;
	}
	
	public String obtenerApellidos ()
	{
		return apellidos;
	}
	
	public String obtenerNombreApellidos() {
		return nombre + " " + apellidos;
	}
	
	public String obtenerDireccion ()
	{
		return direccion;
	}
	
	public String obtenerPoblacion ()
	{
		return poblacion;
	}
	
	public String obtenerProvincia ()
	{
		return provincia;
	}
	
	public String obtenerCodigo ()
	{
		return codigoPostal;
	}
	
	public String obtenerTelefono ()
	{
		return telefono;
	}
	
	public int obtenerAnioNacim ()
	{
		return anioNacim;
	}
}
