package es.iesgalileo.dam;

import java.util.ArrayList;
import java.util.Scanner;

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

	public static void main(String[] args) {
		//
		/*	pseudocodigo:
		 * 	dar alta socios -> consultar/buscar -> calcular estadisticas -> sortear -> mostrar informe
		 */
		
		// instancia de arraylist tipo string vacio
		
		ArrayList<String> listaSocios = new ArrayList<>();
		
		Scanner teclado = new Scanner(System.in);
		
		
		
		System.out.println("club ajedrez galileo - listado socios");
		
		teclado.close();
		
	}

}
