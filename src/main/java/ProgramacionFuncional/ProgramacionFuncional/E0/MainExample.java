package ProgramacionFuncional.ProgramacionFuncional.E0;

public class MainExample implements Operation{
	
	/**
	 *
	 *	Programación funcional: Se trabaja con funciones, Qué se hace, no el Cómo,
	 *	como la imperativa. Menos propensa a errores, ya que evita los denominados
	 *	efectos secundarios. Más abstracta.
	 *
	 *	Mayor trabajo para el compilador.
	 *
	 */

	public MainExample() {
		// Podemos mandar a llamar los métodos staticos normalmente.
		// Operation.interfaceStaticMethod();
		// Podemos invocar los DefaultMethods normalente siempre y cuando
		// implementemos la Interfaz además de declarar el método si no dará error.
		// interfaceDefaultMethod();
		
		// Como no se pueden instanciar las interfaces al igual que las clases abstractas
		// pero lo que si es que se pueden crear Clases anónimas. Entonces es lo que haremos.
		
		Operation o1 = multiplication(); // Ahora ya tenemos nuestra Clase anónima.
		Operation o2 = () -> 3 * 3.3f; // A modo de lambda. Implementamos su unico método abstracto.
		Operation o3 = () -> o1.operation(); // Es como si reemplazará la interfaz.
		Operation o4 = o1::operation; // Por método de referencia, con los dos :: 
		float operacion = o1.operation(); // Mira como también lo permite porque devuelve un float
		Operation operacion2 = o1::operation;
		
		// Esta se la pasaremos ahora a nuestro método porque esta es una interfaz.
		// printResultOfThis(o1);
		printResultOfThis(o2);
		
		// Directo del float del método abstracto.
		// printResultOfThist(operacion); // Pero tira error porque ahora es un float.
		System.out.println("Directo Float: " + operacion);
		// o2.interfaceDefaultMethod();
		printResultOfThis(o3);
		
		// O bien pasarlo directamente por parametro. Nos ahorra mucho codigo. 
		printResultOfThis(()->3.4f * 5);
		
		// Ahora con otro método podemos implementarlo dentro de esta clase.
		// Solo debemos retornar el tipo de dato.
		// - Todo esto es una Clase anonima/lambda: ()-> anyMethod()
		// - Todo lo que va despues de -> Es la implementación de su único metodo abstracto de esa Funtional Interface.
		printResultOfThis(()-> anyMethod()); // 0.4
		// Por método de referencia.
		// - Si es el método es private entonces utilizamos this::
		printResultOfThis(this::anyMethod); // 0.4
		// - Si es el método es static entonces utilizamos el nombre de su clase MainExample::
		// printResultOfThis(MainExample::anyMethod); // 0.4
		
		
		
		
		
		Operation o5 = new Operation(){

			@Override
			public float operation() {
				System.out.println("Ahora con una clase anónima.");
				return 3.2f + 4.8f;
			}
			
		};
		System.out.println(o5.operation());
	}

	private Operation multiplication() {
		return new Operation() {

			@Override
			public float operation() {
				float value1 = 3.3f;
				float value2 = 3;
				print("Primer valor: " + value1);
				print("Segundo valor: " + value2);
				return value1 * value2;
			}
			
			// Este metodo solo vive dentro de esta
			// clase anónima y se utiliza en operation()
			// que es el unico método de la FuntionalIterface
			private void print(String value){
				System.out.println(value);
			}
			
		};
	}
	
	private void printResultOfThis(Operation operation) {
		// operation.interfaceDefaultMethod();
		System.out.println(operation.operation());
	}

	private float anyMethod() {// Para utilizarla por método de referencia se llama con this::
	// Para utilizarla por método de referencia se llama con el nombre de la Clase MainExample::
	// static float anyMethod() { 
		// Para que se vean los decimales como un float agregamos f al final del divisor.
		return 2/5f;
	}
	
	@Override
	public float operation() {
		// TODO: Solo lo declaramos para que no de error en la Implementación de la interfaz.
		return 100;
	}
	 
}
