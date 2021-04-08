package tiendavideojuegos;

import java.io.Serializable;
import java.time.LocalDate;

public class Videojuego implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int codigo;
	private static int c = 1;
	private String nombre;
	private LocalDate fechaLanzamiento;
	private Plataforma plataforma;
	
	public Videojuego(String nombre, Plataforma plataforma, LocalDate fechaLanzamiento) {
		setNombre(nombre);
		setPlataforma(plataforma);
		setFechaLanzamiento(fechaLanzamiento);
		this.codigo = c++;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		Validar.validarNombre(nombre);
		this.nombre = nombre;	
	}

	public LocalDate getFechaLanzamiento() {
		return fechaLanzamiento;
	}

	public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
		Validar.validarFecha(fechaLanzamiento);
		this.fechaLanzamiento = fechaLanzamiento;
	}

	public Plataforma getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Código del videojuego: " + codigo +
				"\nNombre del videojuego: " + nombre +
				"\nPlataforma: " + plataforma + 
				"\nFecha de lanzamiento: " + fechaLanzamiento;
	}	
	
}
