package java_oops;

/**
 * static control flow, instance control flow & constructors (MODULE -3):
 * 
 * 
 * Static Control Flow:
 * 
 * Process:
 * 
 * Whenever we are executing a Java class the following sequence of steps will
 * be executed at the part of static control flow:
 * 
 * - Identification of static members from top to bottom.
 * 
 * - Execution of static variable assignment & static blocks from top to bottom.
 * 
 * - Execution of main() method.
 * 
 * 
 * Read Indirectly Write Only State (RIWOS):
 * 
 * Inside static block If we are trying to read a variable that read operation
 * is called Direct Read. If we are calling a method & within it If we are
 * trying to read a variable that read operation is called Indirect Read.
 * 
 * If a variable is just identified by JVM & original value not yet assigned
 * then the variable is said to be in RIWOS. If a variable is in RIWOS then we
 * can't perform Direct Read but we can perform Indirect Read.
 * 
 * If we are trying to read directly then we'll get CE.
 */

public class Demo_E {

	static int i = 10;

	static {
		createDay();
		// System.out.println(j);
		System.out.println("First static block " + i);
	}

	public static void main(String[] args) {
		System.out.println("main method");
		createDay();
	}

	static void createDay() {
		System.out.println("Outing at Anamol Ruturaj " + j);
	}

	static {
		System.out.println("Second static block");
	}

	static int j = 20;
}
