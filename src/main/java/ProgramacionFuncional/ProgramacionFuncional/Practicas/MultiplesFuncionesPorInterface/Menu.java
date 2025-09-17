package ProgramacionFuncional.ProgramacionFuncional.Practicas.MultiplesFuncionesPorInterface;

public interface Menu {
	public String opcion = "x";
	public String num1 = "0";
	public String num2 = "0";
	
	public static final String MENU = "Seleccione una operación:\n" +
			"s. Sumar\n" +
			"r. Restar\n" +
			"m. Multiplicar\n" +
			"d. Dividir\n" +
			"p. Potencia\n" +
			"rc. Raíz cuadrada\n" +
			"r3. Raíz cúbica\n" +
			"l. Logaritmo\n" +
			"seno. Seno\n" +
			"coseno. Coseno\n" +
			"tangente. Tangente\n" +
			"x. Salir";
	
	
	
	public void appMenu();
	
	default String[] mostrarMenu() {
		System.out.println(MENU);
		
		String[] seleccion = seleccionMenu();
		if (seleccion != null) {
			String opcion = seleccion[0];
			String num1 = seleccion[1];
			String num2 = seleccion[2];
			System.out.println("Operación a realizar: " + opcion);
			System.out.println("Número 1: " + num1);
			System.out.println("Número 2: " + num2);
		}
		return seleccion;
		
	}
	private String[] seleccionMenu() {
		
		String opcion = "x";
		String num1 = "0";
		String num2 = "0";
		/*
		System.out.println("Seleccione una operación:");
		System.out.println("s. Sumar");
		System.out.println("r. Restar");
		System.out.println("m. Multiplicar");
		System.out.println("d. Dividir");
		System.out.println("p. Potencia");
		System.out.println("rc. Raíz cuadrada");
		System.out.println("r3. Raíz cúbica");
		System.out.println("l. Logaritmo");
		System.out.println("seno. Seno");
		System.out.println("coseno. Coseno");
		System.out.println("tangente. Tangente");
		System.out.println("x. Salir");
		
		*/
		System.out.println("Entrada de datos...");
		System.out.println("-----------------");
		
		opcion = leerEntrada();
		if(opcion.equals("x")) {
			System.out.println("Saliendo del menú...");
			return null;
		} else {
			
			System.out.println("Ingrese el primer número:");
			num1 = leerEntrada();
			System.out.println("Ingrese el segundo número:");
			num2 = leerEntrada();
			
		}
		return new String[] {opcion, num1, num2};
		
	}
	
	private String leerEntrada() {
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		System.out.print("Ingrese su opción: ");
		return scanner.nextLine().trim().toLowerCase();
	}
	
}
