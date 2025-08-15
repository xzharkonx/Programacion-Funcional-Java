package ProgramacionFuncional.ProgramacionFuncional;

import ProgramacionFuncional.ProgramacionFuncional.E0.MainExample;
import ProgramacionFuncional.ProgramacionFuncional.E1.MainIFExamples;
import ProgramacionFuncional.ProgramacionFuncional.E2.ConsumerExamples;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        System.out.println( "Bienvenido a mi APP - Luis Eduardo GM." );
        // Ejercicio 0
        //new MainExample();
        
        // Ejercicio 1 Ejemplos variados.
        // new MainIFExamples().comparatorExample();
        // new MainIFExamples().runnableExample();
        // new MainIFExamples().callableExample();
        new MainIFExamples().actionListenerExample();
        
        // Ejercicio 2 Consumer
        // new ConsumerExamples().lista();
        
        // Ejercicio 3 Supplier
        // new SupplierExample().example();
    }
}
