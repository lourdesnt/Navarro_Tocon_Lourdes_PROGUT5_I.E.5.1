package tiendavideojuegos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Gestion {
	
	static Scanner sc;
	static Map<Integer, Videojuego> videojuegos;
	static boolean cambiosPendientes = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		sc = new Scanner(System.in);
		videojuegos = new HashMap<>();
		
		lecturaFichero();
		
		String opcion;
		
		do {
			menu();
			opcion = sc.nextLine();

			switch (opcion) {
				case "0": salir();
						break;
				case "1": aniadirVideojuego();
						break;
				case "2": listarVideojuegos();
						break;
				case "3": borrarVideojuego();
						break;
				case "4": guardarCambios();
						break;
				case "5": recuperarDatos();
						break;
				default: System.out.println("Opción no válida. Introduzca una opción válida, por favor.");
			}

		} while(!opcion.equals("0"));
		
		sc.close();
		
	}

	public static void menu() {
		System.out.println("========================================");
		System.out.println("======== Gestión de Videojuegos ========");
		System.out.println("========================================");
		System.out.println("1.- Añadir un videojuego.");
		System.out.println("2.- Listar videojuegos.");
		System.out.println("3.- Borrar un videojuego.");
		System.out.println("4.- Guardar datos en fichero.");
		System.out.println("5.- Recuperar datos desde fichero.");
		System.out.println("");
		System.out.println("");
		System.out.println("0.- Salir de la aplicación.");
		System.out.println("========================================");
		System.out.println("Introduzca la opción elegida:");
	}
	
	public static void lecturaFichero() {
		try{
			File f = null;
			FileInputStream fe = null;
			ObjectInputStream ois = null;
				try {
					f = new File("videojue.dat");
					if (f.exists()){
						fe = new FileInputStream(f);
						ois = new ObjectInputStream(fe);
						while(true){
							Videojuego v = (Videojuego) ois.readObject();
							videojuegos.put(v.getCodigo(), v);
						}
					}
				} catch(EOFException eof) {
					System.out.println(" --------------------------");
				} catch(FileNotFoundException fnf) {
					System.out.println("No existen datos grabados " + fnf);
				} catch(IOException e){
					e.printStackTrace();
				} catch(Throwable e) {
					e.printStackTrace();
				} finally {
					if (ois != null) {
						ois.close();
						fe.close();
					}
				}
			} catch(IOException e){
				e.printStackTrace();
			}
	}
	
	public static void aniadirVideojuego() {
		System.out.println("Introduzca los datos del videojuego:");
		boolean error = true;
		do {
			error = false;
			try {
				System.out.println("Nombre del videojuego:");
				String nombre = sc.nextLine();
				System.out.println("");
				System.out.println("Plataforma principal:");
				Plataforma plataforma = Plataforma.valueOf(sc.nextLine());
				System.out.println("");
				System.out.println("Fecha de lanzamiento:");
				LocalDate fechaLanzamiento = LocalDate.parse(sc.nextLine());
				System.out.println("");
				
				Videojuego v = new Videojuego(nombre, plataforma, fechaLanzamiento);
				videojuegos.put(v.getCodigo(), v);
				System.out.println("Se ha creado el nuevo videojuego.");
				cambiosPendientes=true;
				
			} catch(IllegalArgumentException e) {
				System.err.println("Dato no válido");
				error=true;
			} catch(DateTimeException d) {
				System.err.println("Fecha no válida");
				error=true;
			}
		} while(error);
		System.out.println("");
	}
	
	public static void listarVideojuegos() {
		videojuegos.values().forEach(System.out::println);
		System.out.println("");
	}
	
	public static void borrarVideojuego() {
		System.out.println("Introduzca el código del videojuego a borrar:");
		int codigo = Integer.parseInt(sc.nextLine());
		if(videojuegos.containsKey(codigo)) {
			System.out.println("Se va a proceder a borrar de la lista:");
			System.out.println(videojuegos.get(codigo).toString());
			System.out.println("¿Desea continuar con el borrado? (S/N)");
			String eleccion = sc.nextLine().toUpperCase();
			if(eleccion.equals("S")) {
				videojuegos.remove(codigo);
				System.out.println("Videojuego borrado");
				cambiosPendientes = true;
			} else {
				System.out.println("Se ha cancelado el borrado");
			}
		}
		System.out.println("");
	}
	
	public static void guardarCambios() {
		if(cambiosPendientes) {
			try{
				FileOutputStream fs = new FileOutputStream("videojue.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fs);
				for (Videojuego v: videojuegos.values()){
					oos.writeObject(v);
				}
				if (oos != null){
					oos.close();
					fs.close();
				}
				System.out.println("Los datos se han guardado correctamente en el fichero videojue.dat");
				cambiosPendientes = false;
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		System.out.println("");
	}
	
	public static void recuperarDatos() {
		if(cambiosPendientes) {
			System.out.println("Ha realizado cambios que no ha guardado en disco.");
			System.out.println("Si continúa la carga del archivo se restaurarán los datos");
			System.out.println(" de disco y se perderán los cambios no guardados.");
			System.out.println("¿Desea continuar con la carga y restaurar los datos del archivo? (S/N)");
			String eleccion = sc.nextLine().toUpperCase();
			if(eleccion.equals("S")) {
				lecturaFichero();
				cambiosPendientes = false;
				System.out.println("Se han recuperado los datos correctamente");
			} else {
				System.out.println("Se ha cancelado la recuperación de los datos");
			}
		} else {
			lecturaFichero();
			System.out.println("Se han recuperado los datos correctamente");
		}
		
		System.out.println("");
	}
	
	public static void salir() {
		if(cambiosPendientes) {
			System.out.println("Ha realizado cambios que no ha guardado en disco.");
			System.out.println("¿Desea guardarlos antes de salir? (S/N)");
			String eleccion = sc.nextLine().toUpperCase();
			if(eleccion.equals("S")) {
				guardarCambios();
			} else {
				System.exit(0);
			}
		}
		System.exit(0);
	}
}
