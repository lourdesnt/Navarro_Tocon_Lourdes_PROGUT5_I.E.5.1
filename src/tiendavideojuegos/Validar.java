package tiendavideojuegos;

import java.time.DateTimeException;
import java.time.LocalDate;
/**
 * Clase Validar
 * 
 * @author Lourdes
 *
 */
public class Validar {

	/**
	 * Método validarFecha, que comprueba si la fecha de lanzamiento no es superior a la fecha actual. Si no es así, se lanza un error
	 * @param fecha Fecha de lanzamiento del videojuego
	 */
    public static void validarFecha(LocalDate fecha) {
        if(fecha.isAfter(LocalDate.now())) {
        	throw new DateTimeException("Fecha no válida: la fecha introducida es posterior a la fecha actual");
        }
    }
    
    /**
     * Método validadNombre, que comprueba si el nombre no es vacío ni nulo. Si no es así, se lanza un error
     * @param nombre Nombre del videojuego
     */
    public static void validarNombre(String nombre) {
    	if(nombre.equals("") || nombre==null) {
    		throw new IllegalArgumentException("Nombre no válido: el nombre introducido es nulo o vacío");
    	}
    }
   
}
