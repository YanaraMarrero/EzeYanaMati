package logica;

public class Imagen {

	private int imagen_id;
	private String titulo;
	private String imagen;

	public int getImagen_id() {
		return imagen_id;
	}

	public void setImagen_id(int imagen_id) {
		this.imagen_id = imagen_id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Imagen [imagen_id=" + imagen_id + ", titulo=" + titulo + ", imagen=" + imagen + "]";
	}
}