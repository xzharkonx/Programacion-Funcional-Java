package ProgramacionFuncional.ProgramacionFuncional.T0;

public interface ITest0 {

	public ITest0 test0();
	
	default Integer operacion0(Integer a, Integer b) {
		return a + b;
	}
	default String saludo0() {
		return "Hola programacion funcional";
	}
}
