package ProgramacionFuncional.ProgramacionFuncional.Practicas.MultiplesFuncionesPorInterface;

public class MultiplesFuncionesPorInterface implements Calculadora, Menu {

	public static void main(String[] args) {
		MultiplesFuncionesPorInterface app = new MultiplesFuncionesPorInterface();
		//app.appOperaciones();
		app.mostrarMenu();
		System.out.println("Operación realizada: " + opcion);
		System.out.println("Número 1: " + num1);
		System.out.println("Número 2: " + num2);
		app.operaciones(opcion,num1,num2);
		System.out.println("Fin de la aplicación.");
		
	}

	@Override
	public void appOperaciones() {
		int a = 10;
		int b = 5;
		
		System.out.println("Aplicación de operaciones matemáticas");
		operaciones("r","10","5");
		
		/*
		System.out.println("Suma: " + suma(a, b));
		System.out.println("Resta: " + resta(a, b));
		System.out.println("Multiplicación: " + multiplicacion(a, b));
		System.out.println("División: " + division(a, b));
		
		double base = 2.0;
		double exponente = 3.0;
		System.out.println("Potencia: " + potencia(base, exponente));
		
		double numero = 16.0;
		System.out.println("Raíz cuadrada: " + raizCuadrada(numero));
		System.out.println("Raíz cúbica: " + raizCubica(numero));
		
		System.out.println("Logaritmo: " + logaritmo(10.0));
		
		double angulo = 30.0;
		System.out.println("Seno: " + seno(angulo));
		System.out.println("Coseno: " + coseno(angulo));
		System.out.println("Tangente: " + tangente(angulo));
		*/
	}

	@Override
	public void appMenu() {
		// TODO Auto-generated method stub
		
	}

}
