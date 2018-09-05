package java_oops;

import java.io.IOException;

/**
 * > POLYMORPHISM is the ability for classes to provide different implementation
 * of method that are called by the same name.
 * 
 * Method Overloading:
 * 
 * Method Overloading means having two or more methods with the same name in a class
 * and the number of parameter or types of parameter or at least Sequence of
 * Data type of parameters should be different.
 * 
 * Having overloading concept in java simplifies the programming.
 * 
 * Return type can be different.
 * 
 * Method signature must be different.
 * 
 * In Overloading method resolution(means which method to invoke) always takes
 * care by compiler based on reference type. Hence, Overloading is also
 * considered as compile time POLYMORPHISM or static POLYMORPHISM or early
 * BINDING.
 * 
 * While resolving Overloaded methods compiler will always keeps the precedence
 * in below order:
 * 
 * a) Widening b) AutoBoxing c) VarArg
 * 
 * NOTE: In overloading we have to check only method names(which must be same) &
 * arguments(which must be different). All remaining are not required to check.
 * But, in overriding we have check each and everything.
 */

public class Demo_A {

	public static void typePromotion(byte a) {
		System.out.println("type promotion: byte");
	}

	public static void typePromotion(short a) {
		System.out.println("type promotion: short");
	}

	public static void typePromotion(char a) {
		System.out.println("type promotion: char");
	}

	public static void typePromotion(int a) {
		System.out.println("type promotion: int");
	}

	public static void typePromotion(long a) {
		System.out.println("type promotion: long");
	}

	public static void typePromotion(float a) {
		System.out.println("type promotion: float");
	}

	public static void typePromotion(double a) {
		System.out.println("type promotion: double");
	}

	public static void checkPriority(Object objArgs) {
		System.out.println("Object class args");
	}

	public static void checkPriority(String strArgs) {
		System.out.println("String class args");
	}

	public static void showCase(String strArgs) {
		System.out.println("string args");
	}

	public static void showCase(StringBuffer strArgs) {
		System.out.println("stringbuffer args");
	}

	public static void showCase(StringBuilder strArgs) {
		System.out.println("stringbuilder args");
	}

	public static void sum(int intArgs) {
		System.out.println("General method");
	}

	public static void sum(Integer integerArgs) {
		System.out.println("Wrapper method");
	}

	public static void sum(int... varArgs) {
		System.out.println("Var-Arg method");
	}

	public static void multiply(Integer num, Integer integerArgs) {
		System.out.println("two Integer class args");
	}

	public static void multiply(Integer intArgs, int num) {
		System.out.println("two Integer class args");
	}
	
	public static void multiply(int intArgs, Integer num) {
		System.out.println("two Integer class args");
	}

	public static void checkArguments(int a, int b) {
		System.out.println("both int version.");
	}

	public static void checkArguments(int a, double b) {
		System.out.println("int & double version.");
	}

	public static void checkArguments(double a, int b) {
		System.out.println("double & int version.");
	}
	
	public static void checkArgumentsNew(int a, double b) {
		System.out.println("int & double types.");
	}

	public static void checkArgumentsNew(double a, int b) {
		System.out.println("double & int types.");
	}

	public static void checkParentChild(Object obj) {
		System.out.println("Parent Version");
	}

	public static void checkParentChild(String str) {
		System.out.println("Child Version");
	}

	public static void checkReturnType() {
		System.out.println("void return type");
	}

	public static double checkReturnType(int a) {
		return 0;
	}

	public static int checkReturnType(int a, double b) {
		return (int) (a + b);
	}

	public static void checkModifiers() {
		System.out.println("public modifier");
	}

	private static void checkModifiers(int a) {
		System.out.println("private modifier");
	}

	public final static void checkModifiers(double a) {
		System.out.println("final modifier");
	}

	public static void exceptionThrows() throws IOException {
		System.out.println(" throws IO Exception ");
	}

	public static void exceptionThrows(String str) throws Exception {
		System.out.println(" throws Exception ");
	}

	public static void main(String[] args) {

		/**
		 * Case 1: Automatic type promotion in overloading:
		 * 
		 * While resolving overloaded methods If exact matched method is not
		 * available then we won't get any compile time error immediately.
		 * 
		 * First, It'll promote argument to the next level and check whether
		 * matched method is available or not. If matched method is available
		 * then it'll be configured else compiler promotes argument once again
		 * to the next level.
		 * 
		 * This process will be continued until all possible promotions. Still,
		 * If the matched method is not available then we'll get CE.
		 * 
		 * (char,byte,short) -> int -> long -> float -> double
		 */
		typePromotion(10);

		/**
		 * Case 2: In overloading methods resolution, child argument will get
		 * more priority than parent argument.
		 * 
		 * Reason: If our work get completed at child level then what is the
		 * need to go for parent level :)
		 */
		checkPriority("check priority");
		checkPriority(null);

		/**
		 * Case 3: In overloading more specific version will get highest
		 * priority.
		 * 
		 * NOTE: String, StringBuilder & StringBuffer are independent classes
		 * and direct child classes of Object class.
		 */
		showCase("Check version");
		showCase(new StringBuffer("check version"));

		// CE: reference showCase() is ambiguity.
		// showCase(null);

		/**
		 * Case 4: Method arguments must be different (At least order of
		 * arguments).
		 * 
		 * Exact match will get chance first or else type promotion take place.
		 */
		checkArguments(10, 20.0);

		/**
		 * Case 5: CE:The method checkArgumentsNew is ambiguous.
		 */
		// ambiguity problem
		// checkArgumentsNew(10, 20);
		// Can't find applicable method
		// checkArgumentsNew(10.0, 20.0);
		checkArgumentsNew(10.0, 20);

		/**
		 * Case 6: Wrapper type has more priority than VAR-ARG method but less
		 * priority than Automatic promoted type.
		 */
		sum(10);

		/**
		 * Case 7: Parent reference and Child object.
		 * 
		 * Reason: In overloading compiler resolve methods based on reference &
		 * not by RUNTIME OBJECT.
		 */
		Object obj = new String("Ronak");
		checkParentChild(obj);

		/**
		 * Case 8: What if, methods are overloaded with Wrapper class
		 * parameters.
		 */
		// CE:
		//multiply(10, 20);

		/**
		 * Case 9: Method return type may or may not same. So, no restriction
		 * for method return type.
		 * */
		checkReturnType();

		/**
		 * Case 10: private, static and final methods can be overloaded and even
		 * for access modifiers there is no restrictions.
		 * */
		checkModifiers(10);

		/**
		 * Case 11: Throws clause (There is no restriction for throwing
		 * exception.).
		 * */
		try {
			exceptionThrows();
		} catch (IOException e) {
		}
	}
}
