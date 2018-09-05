package java_flow_control;

/** do-while loop(iterative statement) :
 * 
 * When to use:
 * 
 * -> If we want to execute loop body at least once then we should go for do-while.
 */

public class Demo_D {
	public static void main(String[] args) {
		
		/** Curly braces are optional and without having curly braces we can take only one statement and
		 * which should not be declarative.*/
		
		//do
		//	System.out.println("without curly braces");
		//while(true);
		
		//do;
		//	while(true);
		
		
		//CE
		//do
		//	int rem=5;
		//while(false);
		
		
		//do {
		//	int balance=12;
		//} while(true);
		
		
		//do while(true)
		//	System.out.println("here, while is a single statement");
		//while(false);
		
		
		//CE: unreachable statement
		//do {
		//	System.out.println("hello");
		//} while (true);
		//System.out.println("hi");
		
		do {
			System.out.println("Only once");
		}
		while(false);
		System.out.println("Next statement");
		
		
		/*int a=10,b=20;
		do {
			System.out.println("normal var");
		}while(a < b);
		System.out.println("a < b");
		*/
		
		int c=10,d=20;
		do {
			System.out.println("normal variable");
		} while (c > d);
		System.out.println("while c > d");
		
		
		//compile time error: unreachable statement
		/*final int e=10,f=20;
		do {
			System.out.println("final var");
		} while (e < f);
		System.out.println("e < f");
		*/
		
		final int g=10,h=20;
		do {
			System.out.println("For final variable compiler will whether next statement get execute or not.");
		} while (g > h);
		System.out.println("while g  > h should be false for final variable.");
	}
}
