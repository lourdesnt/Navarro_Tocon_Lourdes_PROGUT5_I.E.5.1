package tiendavideojuegos;

import java.io.Serializable;
import java.time.LocalDate;
/**
 * Clase Videojuego
 * 
 * @author Lourdes
 *
 */
public class Videojuego implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo Código del videojuego (número entero no negativo)
	 */
	private int codigo;
	/**
	 * Atributo estático Contador del total de videojuegos (número entero no negativo)
	 */
	private static int c = 1;
	/**
	 * Atributo Nombre del videojuego (String)
	 */
	private String nombre;
	/**
	 * Atributo Fecha de lanzamiento del videojuego (LocalDate)
	 */
	private LocalDate fechaLanzamiento;
	/**
	 * Atributo Plataforma del videojuego, podrá ser: DS, WII, XBOX, PS2, PS3, PS4 o PC
	 */
	private Plataforma plataforma;
	
	/**
	 * Constructor predeterminado
	 */
	public Videojuego() {
		this.codigo = c; //El código viene determinado por el contador de videojuegos. El código será único para cada videojuego mientras que el contador se irá incrementando cada vez que registremos un nuevo videojuego
		c++;
	}

	/**
	 * Método getNombre
	 * @return Nombre del videojuego
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método setNombre
	 * @param nombre Nombre del videojuego
	 */
	public void setNombre(String nombre) {
		Validar.validarNombre(nombre); //Validamos primero el nombre
		this.nombre = nombre;	
	}

	/**
	 * Método getFechaLanzamiento
	 * @return Fecha de lanzamiento del videojuego
	 */
	public LocalDate getFechaLanzamiento() {
		return fechaLanzamiento;
	}

	/**
	 * Método setFechaLanzamiento
	 * @param fechaLanzamiento Fecha de lanzamiento del videojuego
	 */
	public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
		Validar.validarFecha(fechaLanzamiento); //Validamos primero si la fecha es correcta
		this.fechaLanzamiento = fechaLanzamiento;
	}

	/**
	 * Método getPlataforma
	 * @return Plataforma del videojuego
	 */
	public Plataforma getPlataforma() {
		return plataforma;
	}

	/**
	 * Método setPlataforma
	 * @param plataforma Plataforma del videojuego
	 */
	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}
	
	/**
	 * Método getCodigo
	 * @return Código del videojuego
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Método setCodigo
	 * @param codigo Codigo del videojuego
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * Método getC
	 * @return Contador de videojuegos
	 */
	public static int getC() {
		return c;
	}

	/**
	 * Método setC
	 * @param c Contador de videojuegos
	 */
	public static void setC(int c) {
		Videojuego.c = c;
	}

	/**
	 * Método toString
	 */
	@Override
	public String toString() {
		return "Código del videojuego: " + codigo +
				"\nNombre del videojuego: " + nombre +
				"\nPlataforma: " + plataforma + 
				"\nFecha de lanzamiento: " + fechaLanzamiento;
	}	
	
}
