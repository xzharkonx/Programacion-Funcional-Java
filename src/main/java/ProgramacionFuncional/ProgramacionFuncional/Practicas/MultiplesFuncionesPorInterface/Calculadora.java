package ProgramacionFuncional.ProgramacionFuncional.Practicas.MultiplesFuncionesPorInterface;

public interface Calculadora {
	
	public void appOperaciones();
	
	default void operaciones(String op, String num1, String num2) {
		System.out.println("Iniciando operación...");
		System.out.println("-----------------");
		switch (op) {
			case "s":
				System.out.println("Suma: " + suma(Integer.parseInt(num1), Integer.parseInt(num2)));
				break;
			case "r":
				System.out.println("Resta: " + resta(Integer.parseInt(num1), Integer.parseInt(num2)));
				break;
			case "m":
				System.out.println("Multiplicación: " + multiplicacion(Integer.parseInt(num1), Integer.parseInt(num2)));
				break;
			case "d":
				System.out.println("División: " + division(Integer.parseInt(num1), Integer.parseInt(num2)));
				break;
			case "p":
				System.out.println("Potencia: " + potencia(Double.parseDouble(num1), Double.parseDouble(num2)));
				break;
			case "rc":
				System.out.println("Raíz cuadrada: " + raizCuadrada(Double.parseDouble(num1)));
				break;
			case "r3":
				System.out.println("Raíz cúbica: " + raizCubica(Double.parseDouble(num1)));
				break;
			case "l":
				System.out.println("Logaritmo: " + logaritmo(Double.parseDouble(num1)));
				break;
			case "seno":
				System.out.println("Seno: " + seno(Double.parseDouble(num1)));
				break;
			case "coseno":
				System.out.println("Coseno: " + coseno(Double.parseDouble(num1)));
				break;
			case "tangente":
				System.out.println("Tangente: " + tangente(Double.parseDouble(num1)));
				break;
			default:
				System.out.println("Operación no reconocida");
		}
	}
	
	private int suma(int a, int b) {
		return a + b;
	}
	
	private int resta(int a, int b) {
		return a - b;
	}
	
	private int multiplicacion(int a, int b) {
		return a * b;
	}
	
	private int division(int a, int b) {
		if(b == 0) {
			throw new ArithmeticException("No se puede dividir por cero");
		}
		return a / b;
	}
	
	private double potencia(double base, double exponente) {
		return Math.pow(base, exponente);
	}
	
	private double raizCuadrada(double numero) {
		if(numero < 0) {
			throw new IllegalArgumentException("No se puede calcular la raíz cuadrada de un número negativo");
		}
		return Math.sqrt(numero);
	}
	
	private double raizCubica(double numero) {
		return Math.cbrt(numero);
	}
	
	private double logaritmo(double numero) {
		if(numero <= 0) {
			throw new IllegalArgumentException("El logaritmo solo está definido para números mayores que cero");
		}
		return Math.log(numero);
	}
	
	private double seno(double angulo) {
		return Math.sin(Math.toRadians(angulo));
	}
	
	private double coseno(double angulo) {
		return Math.cos(Math.toRadians(angulo));
	}
	
	private double tangente(double angulo) {
		return Math.tan(Math.toRadians(angulo));
	}
	

}
