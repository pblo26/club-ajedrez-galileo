package es.iesgalileo.dam;

import java.time.LocalDate;
import org.apache.commons.lang3.StringUtils;
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
			
			System.out.println("<:) Socio encontrado: " + nombre + " | Nacido en el mes de " + mes + ", del año: " + ano);
		} else {
			System.out.println(">:( Socio no encontrado a nombre de: " + nombreBuscado);
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
		
		int anoActual = LocalDate.now().getYear();
		int sumaEdades = 0;
		
		int indiceMayor = 0;
		int indiceMenor = 0;
		
		int edadMaxima = Integer.MIN_VALUE;
		int edadMinima = Integer.MAX_VALUE;
		
		
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
		
		for (int i = 0; i < listaSocios.size(); i++) {
			
			LocalDate fechaNacimiento = listaFechas.get(i);
			int edadSocio = anoActual - fechaNacimiento.getYear();
			sumaEdades += edadSocio;
			
			edadMaxima = Math.max(edadMaxima, edadSocio);
			edadMinima = Math.min(edadMinima, edadSocio);
			
			if (fechaNacimiento.isBefore(listaFechas.get(indiceMayor))) {
				indiceMayor = i;
			}
			
			if (fechaNacimiento.isAfter(listaFechas.get(indiceMenor))) {
				indiceMenor = i;
			}
		}
		
		/*
		 * Metodos estaticos VS metodos de instancia
		 * 
		 * Estatico: ej. Math.round(mediaExacta)
		 * Es estatico porque ni instancia nada y el resultado depende solo de la entrada que le pases.
		 * 
		 * Instanciado:
		 * Sin embargo el instanciado ejemplo del "if (fechaNacimiento.isBefore...)", ahí necesita revisar
		 * dentro de los datos del objeto para poder devolver la salida, así que es instanciado.
		 */
		
		double mediaExacta = (double) sumaEdades / listaSocios.size();
		long edadMediaRedondeada = Math.round(mediaExacta);
		
		int indiceGanador = azarReal.nextInt(listaSocios.size());
		String socioGanador = listaSocios.get(indiceGanador);
		
		/*
		 * Usamos librearias externas como apache commons lang para poder hacer cosas que por defecto,
		 * no se podrian hacer en java sin librerias externas. Un ejemplo es:
		 * StringUtils.upperCase()/StringUtils.capitalize()
		 * O para cosas que sin estas librerias sería menos seguro de hacer y más tedioso
		 */
		
		String ganadorFormateado = StringUtils.capitalize(socioGanador);
		
		informe1.append("\n=========================================\n");
		informe1.append("       RESUMEN DEL CLUB DE AJEDREZ       \n");
		informe1.append("=========================================\n");
		informe1.append(" Listado de Socios (Total: ").append(listaSocios.size()).append("):\n");

		for (int i = 0; i < listaSocios.size(); i++) {
		    LocalDate fNac = listaFechas.get(i);
		    int edad = anoActual - fNac.getYear();
		    
		    informe1.append(" - ").append(listaSocios.get(i)).append(" (Nacido/a el ").append(fNac).append(" | Edad: ").append(edad).append(" años)\n");
		}

		informe1.append("\n ESTADÍSTICAS DEL CLUB:\n");
		informe1.append(" - Edad media: ").append(edadMediaRedondeada).append(" años\n");
		informe1.append(" - Socio de mayor edad: ").append(listaSocios.get(indiceMayor)).append("\n");
		informe1.append(" - Socio de menor edad: ").append(listaSocios.get(indiceMenor)).append("\n");

		informe1.append("\n RESULTADO DEL SORTEO:\n");
		informe1.append(" - El socio premiado es: ").append(ganadorFormateado).append("!\n");
		informe1.append("=========================================\n");

		
		System.out.println(informe1.toString());
			
		System.out.println("Existen: " + listaSocios.size() + " socios registrados.");
		
		esSocio(socioExiste, listaSocios, listaFechas);
		esSocio(socioNoExiste, listaSocios, listaFechas);
		
		System.out.println("Edad media del club: " + edadMediaRedondeada);
		System.out.println("Socio con más edad: " + listaSocios.get(indiceMayor));
		System.out.println("Socio con menor edad: " + listaSocios.get(indiceMenor));
		
		System.out.println("_-_-_-Club Ajedrez-_-_-_-Listado Socios-_-_-_");
		
		teclado.close();
		
	}

}
