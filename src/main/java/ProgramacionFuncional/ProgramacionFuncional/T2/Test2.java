package ProgramacionFuncional.ProgramacionFuncional.T2;

import java.util.function.Consumer;

public class Test2 {
	
	
	public static void main(String[] args) {
		
		System.out.println("Holas");
		//usingConsumer(2,Test2::suma);
		
		usingConsumerOut(2,Test2::suma,Test2::suma2,Test2::suma3);
		
	}
	
	private static <T> void usingConsumer(T value, Consumer<T> consume) {
		consume.accept(value);
	}
	
	private static <T> void usingConsumerOut(T value, Consumer<T> consume, Consumer<T> consume1, Consumer<T> consume2) {
		//consume.accept(value);
		consume.andThen(consume1).andThen(consume2).accept(value);
		System.out.println("------ Cambiamos orden de ejecución de las funciones--------");
		consume.andThen(consume2).andThen(consume1).accept(value);
		//consume2.accept(value);
		
		
	}
	
	public static void suma(Integer n1) {
		System.out.println("Valor: "+String.valueOf(n1*2));

	}
	
	public static void suma2(Integer n1) {
		System.out.println("Valor: "+String.valueOf(n1*3));
		// return String.valueOf(n1*3);

	}

	public static void suma3(Integer n1) {
		System.out.println("Valor: "+String.valueOf(n1*5));
		// return String.valueOf(n1*5);

	}

}
