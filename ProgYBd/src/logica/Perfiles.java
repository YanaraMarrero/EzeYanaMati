package logica;

public class Perfiles {

	private String nombre;
	private Fecha fechaNacimiento;
	private Fecha fechaFallecimiento;
	private String nacionalidad;
	private String ocupacion;
	private String logros;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Fecha getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Fecha fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Fecha getFechaFallecimiento() {
		return fechaFallecimiento;
	}

	public void setFechaFallecimiento(Fecha fechaFallecimiento) {
		this.fechaFallecimiento = fechaFallecimiento;
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
		return "Perfiles [nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", fechaFallecimiento="
				+ fechaFallecimiento + ", nacionalidad=" + nacionalidad + ", ocupacion=" + ocupacion + ", logros="
				+ logros + "]";
	}
}