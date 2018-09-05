package java_basics;

/** main() method:
 * 
 * -> Whether class contains main() or not and whether main() declared according or not
 * these things will not be checked by compiler. At Runtime JVM is responsible to check
 * these things.
 * 
 * -> At runtime if JVM is unable to find main() then we'll get runtime exception saying
 * NoSuchMethodError:main
 * 
 * -> JVM always searches for the main() with signatures,
 * 
 * public: To call by JVM from anywhere in the system.
 * 
 * static: main() is class level method and it is nowhere related to any object,
 * so without existing object JVM has to call this method. 
 * 
 * void: main() will not return anything to JVM.
 * 
 * main: this is the name which is configured inside JVM.
 * 
 * String[]: command line arguments.
 * 
 * */

public class Demo_H {
	
	/* Even though the main() syntax is strict the following changes are acceptable.*/
	
	/**
	 * (1) In java anywhere order of modifier is not important so that we can take
	 * static public instead of public static.
	 * 
	 * (2) We can declare String[] in any acceptable form.
	 * 
	 * (3) Instead of args we can take any valid java identifier.
	 * 
	 * (4) We can replace String[] with var-arg parameter.
	 * 
	 * (5) We can declare main() with the following modifiers.
	 * 		final, synchronized, strictfp
	 * 
	 */
	
	/*static final synchronized strictfp public void main(String... list) {
		System.out.println("check validity");
		
		//Like normal method call
		main(new int[]{1,2,3});
		
	}*/
	
	
	
	/** Case 1: overloading of the main method is possible but JVM will always call
	 * String[] argument main method only.
	 * 
	 * The other overloaded method we have to call explicitly, like a normal call.*/
	public static void main(int[] args) {
		System.out.println("overloaded method");
	}
	
	
	/** Case 2: Inheritance concept applicable for the main method. If child class 
	 * does not contain main method then parent class main method will be executed.
	 * 
	 * NOTE: In java,While executing Child class compiler generates two class files 
	 * one each for parent class and child class.
	 * */
	
	
	
	/** Case 3: It seems overriding applicable for main method but it is not overriding
	 * but it is method hiding. */
	public static void main(String[] args) {
		System.out.println("parent method");
	}
	
	
	/** From 1.7 version onwards to run a java program main method is mandatory.
	 * Hence, even though class contains static block, program will not be executed
	 * without main() method. */
}

