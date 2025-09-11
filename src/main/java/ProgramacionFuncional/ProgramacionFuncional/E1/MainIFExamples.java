package ProgramacionFuncional.ProgramacionFuncional.E1;

import java.awt.Toolkit;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainIFExamples {

	
	// Interfaces funcionales de las que dispone Java apara trabajar.
	
	// 2. Callable<T>
	// Es una Interfaz funcional, usaremos esta en los ejemplos.
	
	// 3. Runable
	// Esta tiene un método abstracto, con lo cual es una interfaz funcional.
	
	// 1. ActionListener
	// Para eventos, pero mira que es una Interfaz porue la podemos pasar por lambda
	// o de referencia a métodos porque es una Interfaz funcional porque tiene un
	// método abstracto con lo cuál el actionPerfomed nos permite trabajar con ella
	// de manera funcional aunque no esté anotada.
	
	// Predicate<T>
	// Estas nos servirá cuando veamos los Streams, es bastante amplia,
	// tiene varios métodos que podremos ocupar, pero mira que solo tiene un 
	// método abstracto "test" con lo cuál está se vuelve una Functional Interface.
	
	// Todas estas nos ayudan a trababajar de manera funcional con los streams.
	
	// 6. Supplier<T>
	// 5. Consumer<T>
	// El objetivo de este ejemplo muestra como crear una función que acepte por
	// parametro 1 valor (Objeto) de tipo T a tratar (Objeto) y una función
	// que tomarà ese valor y se ejecutará, también podemos ampliar esta función para 
	// agregar una serie de funciones que se ejecuten teniendo por parametro de entrada el valor T.
	// Por lo que esta funcion cosume tanto el valor como la función o funciones que ejecutará ese valor.
	
	// 5.1. BiConsumer<T, U>
	// El objetivo de este ejemplo muestra como crear una función que acepte por
	// parametro 2 valores (Objeto) de tipo T y U a tratar (Objetos) y una función
	// que tomarà esos valores y se ejecutará, también podemos ampliar esta función para 
	// agregar una serie de funciones que se ejecuten teniendo por parametros de entrada el valor T y U.
	// Por lo que esta funcion cosume tanto ambos valores T y U como la función o funciones que ejecutará esos valores.
	
	// 7. Function<T, R>
	// Este recibe 2 tipos el de entrada y el de retorno.
	
	// 8. BiFunction<T, R>
	// Acepta 2 tipos y retorna otro del tipo que le especifiquemos.
	
	// 4. Comparator<T>
	// Para comparar. Tiene muchisimos pero el que nos interesa es compare.
	
	// ------------------------------------------------------------------------------------------
	
	// 4. comparatorExample();
	// El objetivo para este ejemplo en el que se utilizo un TreSet que recibe
	// por parametro una interfaz de Comparable para que este tenga una función
	// anonima llama compare la cual podamos implementar a nuestra manera dentro 
	// de la misma capa donde estemos mandando a llamar nuestro comparator y 
	// mandarla a llamar.
	
	// 3. runableExample();
	// El objetivo de esta interfaz es "Correr un Hilo aparte" para realizar
	// alguna ejecución de alguna función determinada, solo va y ejecuta y no devuelve nada.
	
	// 2. callableExample();
	// El objetivo de esta interfaz es ir a hacer alguna llamada a
	// a un método o función para que realice alguna operación pero
	// que este nos devuelva un valor.
	
	// 1. actionListenerExample();
	// El objetivo de está interfaz es ir a ejecutar algo mediante algún evento como
	// hacer clic en el botón izquierdo del mouse y a su vez está accion ejecutará
	// un método donde hará cosas y termine sin devolver nada.
	
	
	// ------ Ejemplo de Comparator ------
	// -- Dependiendo del tipo de dato es de lo que comparará.
	public static void comparatorExample() {
		TreeSet<Integer> tree = new TreeSet<>(MainIFExamples::compare);
		tree.add(4);
		tree.add(8);
		tree.add(1);
		//	tree.add(4);
		//	tree.add(8);
		//	tree.add(1);
		tree.forEach(System.out::println);
	}
	
	// Al iniciar, el primer valor que le enviemos será tomado por "a y b",
	// luego el siguiente valor "a" que agreguemos solo lo comparará con "b" que tendrá el valor anterior,
	// luego el siguiente valor "a" que agreguemos lo volverá a comparara con "b" del valor que ya tenía
	// osea el primero y así sucesivamente con lo que se le pase.
	private static int compare (Integer a, Integer b) {
		
		
		// Si hay un número menor entonces lo agrega al final del tree y termina.
		// De mayor a menor los ordena.
		if(a < b) {
			System.out.println("-A: " + a);
			System.out.println("B: " + b);
			return 1;
		}
		
		// Si hay un número mayor entonces lo agrega al principio del tree y termina.
		// De menor a mayor los ordena.
		//	if(a > b) {
			//	return 1;
		//	}
		
		
		// Si es un valor igual entonces no lo incluyas, para ello retornamos 0.
		if(a == b) {
			System.out.println(a + " a==b " + b);
			return 0;
		}
		
		// Si retornamos -1 agrega el número al final del tree.
		System.out.println("A: " + a);
		System.out.println("B: " + b);
		return -1; 
	}
	
	
	// ------ Ejemplo de Runnable ------
	// -- Con método por referencia.
	public static void runnableExample() {
		
		Thread thread = new Thread(MainIFExamples::runBehavior);
		thread.start();
	}
	
	private static void runBehavior() {
		int i = 0;
		while(i++ != 100) {
			System.out.println("Llamada a run() No: " + i);
		}
	}
	
	
	// ------ Ejemplo 2 de Runable ------
	// -- Clase con clase anónima.
	public static void runnableExample2() {	
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				int i = 0;
				while(i++ != 100) {
					System.out.println("Llamada a run() No: " + i);
				}
			}		
		});
		thread.start();
	}
	
	
	// ------ Ejemplo 3 de Runable ------
	// -- Clase con Lambda.
	public static void runnableExample3() {		
		Thread thread = new Thread(() -> {
					int i = 0;
					while(i++ != 100) {
						System.out.println("Llamada a run() No: " + i);
					}
			});
		thread.start();
	}
	
	
	// ------ Ejemplo de Callable ------
	public static void callableExample() {
		try {
			// Para poner a correr un hilo.
			ExecutorService executor = Executors.newSingleThreadExecutor();
			
			// Este método submit se le puede pasar una Interfaz Callable o bien Runnable.
			// Con Runnable no devolvera nada pero con Callable si.
			// Pero mira que nosotros creamos una función en la cual le devolvemos un String.
			// Entonces con executor.submit ejecuta esa función devolviendole lo que esperamos
			// en el futuro.
			Future<String> future = executor.submit(MainIFExamples::operation);
			
			// En este otro ejemplo, mira como es una FunctionExpresion y esta devuelve el String
			// de operation();
			// Future<String> future = executor.submit(() -> MainIFExamples.operation());
			
			// Como isDone() es una función abstracta dentro de esta interfaz no vale
			// para comprobar, tendríamos que definirla.
			// if(future.isDone()) {
				System.out.println(future.get());
			//}
			executor.shutdown(); // Detenemos el executor para que se detenga el programa.
			
		}catch(InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("Linea Original del tiempo.");
	}
	
	private static String operation() {
		Character[] charArray = new Character[] {'S','o','y',' ','u','n','a',' ','c','a','d','e','n','a'};
		StringBuffer bffer = new StringBuffer("Recomponiendo cadena -> ");
		
		// Ahora ocuparemos el stream apartir de la clase tipo del dato y se lo pasamos.
		Arrays.stream(charArray)
			  .forEach(character -> { // Recorremos el array de caracteres.
				  System.out.println(character); // Mostramos el caracter que le vamos a pasar.
				  bffer.append(character); // Le agregamos el caracter.
				  sleep(); // Dormimos el hilo. Ejecutamos este método declarado abajo.
			  });
		
		// Por último imprimimos por pantalla el nombre del hilo.
		System.out.println(Thread.currentThread()
								 .getName());
		return bffer.toString(); // Devolvemos los caracteres que juntamos en nuestro StringBuffer.
	}
	
	private static void sleep() {
		try {
			Thread.sleep(1000);
			System.out.println("Un segundo despueés...");
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	// ------ Ejemplo de ActionListener ------
	public static void actionListenerExample() {
		JFrame frame = new JFrame();
		frame.setSize(Toolkit.getDefaultToolkit()
							 .getScreenSize());
		JButton btn = new JButton("Exit");
		btn.setSize(frame.getSize());
		// En la siguiente línea mira como se utiliza un lambda de ActionListener
		// btn.addActionListener(event -> System.exit(0)); // Está es la línea del ejemplo
		
		// Otra forma de hacerlo y añadiendo más funcionalidades.
		// Creamos un nuevo método o bien seleccionamos todo el contenido y con las
		// teclas [MAC¡¡ option + command + m]
		// teclas [WINDOWS¡¡ alt + shift + m]
		btn.addActionListener(event -> out()); // Está es la línea del ejemplo
		frame.getContentPane()
			 .add(btn);
		frame.setVisible(true);	
	}

	private static void out() {
		System.out.println("Saliendo...");
		System.exit(0);
	}
	
}
