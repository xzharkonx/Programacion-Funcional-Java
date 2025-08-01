package ProgramacionFuncional.ProgramacionFuncional.E2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public final class ConsumerExamples {

	static List<Object> lst = new ArrayList<>();
	
	public static void lista() {
		ConsumerExamples.lst.add("Helloo bro");
		ConsumerExamples.lst.add(2022);
		ConsumerExamples.lst.add(true);
		ConsumerExamples.lst.add(48.88f);
		// lst.forEach(System.out::println);

		// Consumidores. Acepta el valor pero no devuelve nada.
		// Consumer<T>
		// BiConsumer<>
		
		// ------ Ejemplo 1 Consumer ------
		
		// Mira como le podemos pasar cualquier valor, este se comportará como tipo T aunque sea un String,Integer,Boolean,etc...
		usingConsumer("Hola soy un valor de tipo T", System.out::println);
		
		// Con varios Consumers
		usingConsumer2("Hola soy un valor de tipo T", System.out::println
						// , v->lst.add(v)); // lambda.
						, lst::add // Llamando al método add() con método por referencia.
						, ConsumerExamples::printLst);
		
		
		
		// ------ Ejemplo 2 BiConsumer ------
		
		// usingBiconsumer(4, 1000
						 // , (e,v) -> System.out.println("En el index: " + e + " se intenta añadir " + v));
						 // Abstraemos el contenido del System en este método. con "option" + "command" + "m".
						 // , (e,v) -> printBefore(e, v)); // Luego utilizamos la referencia a métodos.
						 // , ConsumerExamples::printBefore); // Quedá más simple con la referencia a métodos.
		
		// Ordenamos, nos queda ahora en una sola línea.
		usingBiconsumer(4, 1000, ConsumerExamples::printBefore);	
		
		// Ahora usamos más de un BiConsumer.
		usingBiconsumer2(4, 1000, ConsumerExamples::printBefore
							    , lst::add // Entiende que es el método con 2 parametros: List.add(int index, Object element)
							    , ConsumerExamples::printAfter);	
		
	}
	
	// ------ Ejemplo 1 Consumer ------

	// Le agregamos un parametro de tipo T y un Consumer para que nos permita
	// pasarle una función de las que aceptan valores y no devuelven nada.
	// Se la vamos a poder pasar por parámetro a este método.
	private static <T> void usingConsumer(T value, Consumer<T> consume) {
		
		// Dentro del accept se estaría implementando nuestro System.out::println
		consume.accept(value);
		
	}
	
	// Ahora con varios Consumers, en las cuales aceptan un valor pero no devuelven nada.
	private static <T> void usingConsumer2(T value, Consumer<T> consume, Consumer<T> consume2, Consumer<T> consume3) {
		
		// Dentro del accept se estaría implementando nuestro System.out::println
		// Le pasamos el value a accept para cada consumer uno por uno. Forma consecutiva.
		// consume.accept(value);
		// consume2.accept(value);
		// consume3.accept(value);
		
		// va agregando las funciones encandenando el valor...
		// consume.andThen(consume2)
		// 	   .andThen(consume3)
		// 	   .accept(value);
		
		// Ahora en una variable de tipo Consumer<T>
		Consumer<T> consumerCompleted = consume.andThen(consume2)
				   							   .andThen(consume3);
		consumerCompleted.accept(value);
		
	}
	
	private static <T> void printLst(T value) {
		System.out.println("Se añadió a la lista el valor: \"" + value + "\" -- Total de valores en la lista: " + lst.size());
		lst.forEach(System.out::println);
		
	}
	
	// ------ Ejemplo 2 BiConsumer ------
	
	private static <T,U> void usingBiconsumer(T oneValue, U otherValue, BiConsumer<T,U> biconsume) {
		
		biconsume.accept(oneValue, otherValue);
		
	}
	
	private static void printBefore(Integer e, Integer v) {
		System.out.println("En el index: " + e + " se intenta añadir " + v);
	}
	
	private static <T,U> void usingBiconsumer2(T oneValue, U otherValue, BiConsumer<T,U> biconsume
																	   , BiConsumer<T,U> biconsume1
																	   , BiConsumer<T,U> biconsume2) {
		
		biconsume.andThen(biconsume1)
				 .andThen(biconsume2)
			 	 .accept(oneValue, otherValue);
		
	}
	
	private static void printAfter(Integer e, Integer v) {
		System.out.println("En el index: " + e + " se añadio el elemento: " + v);
		lst.forEach(System.out::println);
	}
}
