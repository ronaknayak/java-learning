package java8;

/**
 * 
 * @author ronak.nayak
 * 
 * 
 * Functional Interfaces:
 * 
 * Once we write lambda expression we can call that expression just like a method, 
 * for this functional interfaces are required.
 * 
 * If an interface contain only one abstract method, such type of interfaces are called 
 * functional interfaces and the method is called functional method or single abstract 
 * method (SAM).
 * 
 * Example:
 * 1) Runnable: It contains only run() method
 * 2) Comparable: It contains only compareTo() method
 * 
 * 
 * Inside functional interface in addition to single Abstract method (SAM) we write any 
 * number of default and static methods.
 * 
 * In Java 8, Sun Micro System introduced @FunctionalInterface annotation to specify 
 * that the interface is Functional Interface.
 * 
 * 
 * Functional Interface VS Lambda Expressions:
 * ****************************************************************************
 * Once we write Lambda expressions to invoke it’s functionality, then Functional 
 * Interface is required. We can use Functional Interface reference to refer Lambda 
 * Expression.
 * 
 * Where ever Functional Interface concept is applicable there we can use Lambda 
 * Expressions.
 * 
 * Earlier we have to write separate implementation class to implement our interface
 * method even after having single method in interface. But, in case of Lambda 
 * Expressions based on context compiler automatically assume the type of parameters 
 * we are using within parenthesis for implementation and map it with interface 
 * declared abstract method.That's called type inference.
 * 
 * 
 * WithLamdaExpressionsSimple simple = 
 * 		(s) -> System.out.println("Called without separate implementation class: " + s);
 * 
 * Here as we are representing Lambda expressions by using WithLamdaExpressionsSimple 
 * interface, compiler assume it is as implementation for the interface method.
 * 
 * Thus, Functional Interface act as TYPE for lambda expression and it represent 
 * entire lambda expression and compiler map the entire lambda expression with 
 * the provided @FunctionalInterface method.
 */
public class Section_C {
	public static void main(String[] args) {
		String date = "09-07-2018";
		
		WithLamdaExpressionsSimple simple = 
				(s) -> System.out.println("Called without separate implementation class: " + s);
		simple.view(date);
		
		WithLamdaExpressionsReturn returnCase = number -> number * number;
		System.out.println(returnCase.square(5));
	}
}

@FunctionalInterface
interface FirstFunctionalInterface {
	public abstract void nightProcess();
	
	default void dayProcess() {
		System.out.println("FirstFunctionalInterface.dayProcess()");
	}
	
	static void noonProcess() {
		System.out.println("FirstFunctionalInterface.noonProcess()");
	}
}

interface WithLamdaExpressionsSimple {
	public void view(String date);
}

interface WithLamdaExpressionsReturn {
	public int square(int number);
}
