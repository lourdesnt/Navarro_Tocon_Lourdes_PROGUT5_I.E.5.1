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
	 * Atributo C�digo del videojuego (n�mero entero no negativo)
	 */
	private int codigo;
	/**
	 * Atributo est�tico Contador del total de videojuegos (n�mero entero no negativo)
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
	 * Atributo Plataforma del videojuego, podr� ser: DS, WII, XBOX, PS2, PS3, PS4 o PC
	 */
	private Plataforma plataforma;
	
	/**
	 * Constructor predeterminado
	 */
	public Videojuego() {
		this.codigo = c; //El c�digo viene determinado por el contador de videojuegos. El c�digo ser� �nico para cada videojuego mientras que el contador se ir� incrementando cada vez que registremos un nuevo videojuego
		c++;
	}

	/**
	 * M�todo getNombre
	 * @return Nombre del videojuego
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * M�todo setNombre
	 * @param nombre Nombre del videojuego
	 */
	public void setNombre(String nombre) {
		Validar.validarNombre(nombre); //Validamos primero el nombre
		this.nombre = nombre;	
	}

	/**
	 * M�todo getFechaLanzamiento
	 * @return Fecha de lanzamiento del videojuego
	 */
	public LocalDate getFechaLanzamiento() {
		return fechaLanzamiento;
	}

	/**
	 * M�todo setFechaLanzamiento
	 * @param fechaLanzamiento Fecha de lanzamiento del videojuego
	 */
	public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
		Validar.validarFecha(fechaLanzamiento); //Validamos primero si la fecha es correcta
		this.fechaLanzamiento = fechaLanzamiento;
	}

	/**
	 * M�todo getPlataforma
	 * @return Plataforma del videojuego
	 */
	public Plataforma getPlataforma() {
		return plataforma;
	}

	/**
	 * M�todo setPlataforma
	 * @param plataforma Plataforma del videojuego
	 */
	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}
	
	/**
	 * M�todo getCodigo
	 * @return C�digo del videojuego
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * M�todo setCodigo
	 * @param codigo Codigo del videojuego
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * M�todo getC
	 * @return Contador de videojuegos
	 */
	public static int getC() {
		return c;
	}

	/**
	 * M�todo setC
	 * @param c Contador de videojuegos
	 */
	public static void setC(int c) {
		Videojuego.c = c;
	}

	/**
	 * M�todo toString
	 */
	@Override
	public String toString() {
		return "C�digo del videojuego: " + codigo +
				"\nNombre del videojuego: " + nombre +
				"\nPlataforma: " + plataforma + 
				"\nFecha de lanzamiento: " + fechaLanzamiento;
	}	
	
}
