package logica;

public class Perfil {

	private int id;
	private String nombre;
	private Fecha fechaNac;
	private Fecha fechaFall;
	private String nacionalidad;
	private String ocupacion;
	private String logros;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Fecha getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Fecha fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Fecha getFechaFall() {
		return fechaFall;
	}

	public void setFechaFall(Fecha fechaFall) {
		this.fechaFall = fechaFall;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getLogros() {
		return logros;
	}

	public void setLogros(String logros) {
		this.logros = logros;
	}

	@Override
	public String toString() {
		return "Perfil [id=" + id + ", nombre=" + nombre + ", fechaNac=" + fechaNac + ", fechaFall=" + fechaFall
				+ ", nacionalidad=" + nacionalidad + ", ocupacion=" + ocupacion + ", logros=" + logros + "]";
	}

	
}