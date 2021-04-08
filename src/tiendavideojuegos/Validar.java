package tiendavideojuegos;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Validar {

    public static void validarFecha(LocalDate fecha) {
        if(fecha.isAfter(LocalDate.now())) {
        	throw new DateTimeException("Fecha no válida: la fecha introducida es posterior a la fecha actual");
        }
    }
    
    public static void validarNombre(String nombre) {
    	if(nombre.equals("") || nombre==null) {
    		throw new IllegalArgumentException("Nombre no válido: el nombre introducido es nulo o vacío");
    	}
    }
   
}
