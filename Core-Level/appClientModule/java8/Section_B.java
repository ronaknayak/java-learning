package java8;

/**
 * 
 * @author ronak.nayak
 * 
 * 
 * What Lambda expression ?
 * ****************************************************************************
 * Lambda Expression is just an anonymous (nameless) function. That means the function 
 * which doesn’t have the name, return type and access modifiers.
 * 
 * 
 * Syntax of Lambda Expression:
 * ****************************************************************************
 * 0. A type of variable which get the value retrieved from Lambda expression
 * 
 * 1.A comma separated list of formal parameters enclosed in parenthesis (If
 * there are more than one parameter)
 * 
 * 2.The arrow token ->
 * 
 * 3.A body, which consists of a single expression or a statement block. Need to
 * be enclosed in curly braces if there are multiple block of statements.
 * 
 * 
 * Sample 1: 
 * typeOfVar = public void print() { 
 * 		System.out.println(); 
 * }
 * 
 * Equivalent Lambda expression:
 * typeOfVar = () -> System.out.println("India VS RSA 4th ODI");
 * 
 * Sample 2: 
 * typeOfVar = public Integer calculate(Integer a) { 
 * 		return a * 2;
 * }
 * 
 * Equivalent Lambda expression:
 * typeOfVar = (Integer a) -> a * 2;
 * 
 * Sample 3:
 * typeOfVar = (Integer a, Integer b) -> {
 * 		if(b == 0) return 0;
 * 		return a/b;
 * }
 *
 * If the type of the parameter can be decided by compiler automatically 
 * based on the context then we can remove types also.
 * The above Lambda expression we can rewrite as (a,b) -> return a/b;
 * 
 * Also, If Lambda expression return something then we can remove return 
 * keyword.
 * (a,b) -> a/b;
 *
 *
 * Lambda as interface type:
 * 
 * interface Greet {
 * 		public void print();
 * }
 * 
 * In Java7 we must provide separate implementation class for this interface.
 * 
 * class GreetImpl implements Greet {
 * 		public void print() {
 * 			System.out.println("India VS RSA 4th ODI");
 * 		}
 * }
 * Greet greet =  new GreetImpl();
 * greet.print();
 * 
 * Equivalent Lambda expression:
 * Greet greet = () -> System.out.println("India VS RSA 4th ODI");
 * 
 * 
 * Notes:
 * 
 * If we use Lambda as interface type then that interface must have 
 * only  one method declared with same method signatures.
 * 
 * Using Lambda expression Java internally map the function implementation 
 * with the method declared in interface.
 */
public class Section_B {

	public static void main(String[] args) {
		
		Greeting greeting = () -> System.out.println("Happy BirthDay!!!");
		greeting.wish();
	}
}

@FunctionalInterface
interface Greeting {
	public void wish();
}