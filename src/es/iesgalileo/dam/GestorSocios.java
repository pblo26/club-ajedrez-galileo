package es.iesgalileo.dam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Optional;

/*
 * 
 * 1. Clases, objetos y metodos a usar:
 * 
 * - ArrayList<String> / <LocalDate>
 * *objetos: listaSocios / listaFechas
 * *metodos: add(), get(), size(), idexOf()
 * 
 * - LocalDate:
 * *objetos: fechas de nacimiento socios y hoy (LocalDate.now())
 * *metodos: of(), getYear(), getMonth(), isBefore(), isAfter()
 * 
 * - Random:
 * *objetos: azar (sin semilla para un sorteo aleatorio y real) y azarFijo (con semilla 42 para pruebas)
 * *metodos: nextInt()
 * 
 * - StringBuilder:
 * *objetos: informe
 * *metodos: append(), toString()
 * 
 * - Math (estatico, no instancia nada a diferencia de los anteriores. NO guarda información solo coge las operaciones y da una salida):
 * * Clase utilidades (metodos estaticos): Math.round(), Math.max(), Math.min()
 * 
 * 
 * 2. ¿Por qué la UT02 es más orientada a objetos? ¿Dónde viven ahora los datos y las operaciones que los tratan?
 * 
 * - A diferencia de la UT01 aqui ya empezamos a ver más clases y con ellas más objetos y metodos, la UT01 era como una presentación a Java.
 * - Los datos ahora viven en los objetos de las variables, antes en las variables.
 * 
 * 
 * 3. Cómo lo habrias hecho con conocimineto UT01 vs UT02
 * 
 * - Con el conocimiento de la UT01 podria haber hecho en una variable un array de tipo string con un cantidad FIJA de socios para guardar información.
 * - Con el conomiento de la UT02 soy capaz de crear con ArrayList un array dinamico, sin una cantidad fija de posibles socios en esa lista.
 * - Da muchisimas ventajas la primera es que no te preocupas por la cantidad asignada en el array, simplemente agregas, puedes contar la cantidad de socios sin
 * - tener que ir haciendo chapuzas para contarlos o para borrar o buscar socios en ese array, en definitva, es mucho más profesional y sencillo de usar.
 *  
 */

public class GestorSocios {

	public static Optional<Integer> buscarSocio(String nombre, ArrayList<String> listaSocios){
		
		int indice = listaSocios.indexOf(nombre);
		if (indice == -1) {
			return Optional.empty();
			
		} else {
			return Optional.of(indice);
		}
		
	}
	
	public static void esSocio(String nombreBuscado, ArrayList<String> listaSocios, ArrayList<LocalDate> listaFechas) {
		
		Optional<Integer> resultadoBusqueda = buscarSocio(nombreBuscado, listaSocios);
		
		if (resultadoBusqueda.isPresent()) {
			
			int posicion = resultadoBusqueda.get();
			String nombre = listaSocios.get(posicion);
			LocalDate fechaNacimiento = listaFechas.get(posicion);
			
			int ano = fechaNacimiento.getYear();
			var mes = fechaNacimiento.getMonth();
			
			System.out.println("<:) Socio encontrado: " + nombre + " | Nacido/a en el mes de " + mes + ", del año: " + ano);
		} else {
			System.out.println(">:( Socio no encontrado a nombre de: '" + nombreBuscado + "'");
		}
		
	}
	
	public static void main(String[] args) {
		
		//
		/*	pseudocodigo:
		 * 	dar alta socios -> consultar/buscar -> calcular estadisticas -> sortear -> mostrar informe
		 */
		
		Scanner teclado = new Scanner(System.in);
				
		ArrayList<String> listaSocios = new ArrayList<>();
		ArrayList<LocalDate> listaFechas = new ArrayList<>();
		
		StringBuilder informe1 = new StringBuilder("_-_-_-Club Ajedrez-_-_-_\n");
		StringBuilder informe2 = new StringBuilder(200);
				
		Random azarReal = new Random();
		Random azar = new Random(42);
		
		String socioExiste = "Walter White";
		String socioNoExiste = "Skyler White";
		
		listaSocios.add("Ross Ulbritch");
		listaFechas.add(LocalDate.of(2000, 10, 11));

		listaSocios.add("Walter White");
		listaFechas.add(LocalDate.of(1999, 6, 9));
		
		listaSocios.add("Antonio Escohotado");
		listaFechas.add(LocalDate.of(1998, 6, 7));
		
		listaSocios.add("Jhon McAfee");
		listaFechas.add(LocalDate.of(1997, 2, 28));

		listaSocios.add("Linus Torvals");
		listaFechas.add(LocalDate.of(1996, 12, 12));
		
			
		System.out.println("Existen: " + listaSocios.size() + " socios registrados.");
		
		esSocio(socioExiste, listaSocios, listaFechas);
		esSocio(socioNoExiste, listaSocios, listaFechas);
		
		System.out.println("_-_-_-Club Ajedrez-_-_-_-Listado Socios-_-_-_");
		
		teclado.close();
		
	}

}
