package ProgramacionFuncional.ProgramacionFuncional.T3;

import java.util.function.Supplier;

public class Test3 {

	public static void main(String[] args) {
		
		Supplier<Integer> calculo = Test3::calculadora;
		Supplier<Integer> calcular = Test3::calculos;
		
		usingSupplier(calculo);
	}
	
	static <T> void usingSupplier(Supplier<T> supplier) {
		System.out.println("Numero calculado mediante funcion: "+10*(Integer)supplier.get());
		
	}
	
	public static Integer calculadora() {
		return 10;
	}
	
	private static Integer calculos() {
		return 10*5;
	}
	
}
