package ProgramacionFuncional.ProgramacionFuncional.E3;

import java.time.LocalDate;
import java.util.Random;
import java.util.function.Supplier;

public class SupplierExample {
	
	// Supplier<T>
	// Solo tiene un método T get() que devuelve ese método.
	
	public static void example() {
		// Supplier<LocalDate> date = () -> LocalDate.now(); // LAMBDA
		Supplier<LocalDate> date = LocalDate::now; // Método de referencia a la Clase.
		
		// Ahora para un número aleatorio.
		// Creamos un Objeto
		Random random = new Random();
		// Utilizamos la referencia de métodos a Objetos
		Supplier<Integer> randomInt = random::nextInt;
		
		// Ahora llamamos al método Supplier que creamos para que nos devuelva los datos.
		usingSupplier(date);
		usingSupplier(randomInt);
		usingSupplier(randomInt);
		usingSupplier(randomInt);
		
		// Puede ser con un Objeto cualquiera, nos devolvera lo que ejecutemos.
		Supplier<HotDog> hotdog = HotDog::new;
		usingSupplier(hotdog); // Imprimira la referencia del Objeto, llama al toString.
	}
	
	// Le pasamos un Supplier de tipo generico T
	public static <T> void usingSupplier(Supplier<T> supplier) {
		
		// Ahora imaginemos que tenemos cierto código y lo queremos llamar.
		System.out.println("Hacemos cierto código");		
		System.out.println("Se obtiene: " + supplier.get());
	}
	

}
