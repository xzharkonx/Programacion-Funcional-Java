package ProgramacionFuncional.ProgramacionFuncional.E0;

@FunctionalInterface
public interface Operation {

	float operation(); 
	
	// De JAVA 9 para arriba se pueden utilizar interfaces de tipo private.
	private void interfacePrivateMethod() {
		System.out.println("Llamado al método privado");
		interfaceStaticMethod("1");
	 }
	
	static void interfaceStaticMethod(String n) {
		System.out.println("Llamado al método estático de una interfaz "+n);
	}
			
	default void interfaceDefaultMethod() {
		interfacePrivateMethod();
		interfaceStaticMethod("2");
		System.out.println("Llamado al método default de una interfaz");
	}
}
