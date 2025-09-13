package ProgramacionFuncional.ProgramacionFuncional.T0;

public class Test0 {

	public static void main(String[] args) {
		
		ITest0 test0 = () -> {
			System.out.println("Implementacion del metodo test0");
			return null;
		};
		
		Integer resultado = test0.operacion0(5, 10);
		
		System.out.println("Resultado de la operacion: " + test0.operacion0(5, 10));
		test0.test0();
		
		System.out.println(test0.saludo0());

	}

}
