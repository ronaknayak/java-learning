package java_access_modifiers;

/**
 * Final Variables:
 * 
 * final instance variables:
 * 
 * If the value of a variable is varied from object to object such type of
 * variables are called Instance variables. For every object a separate copy of
 * instance variable will be created.
 * 
 * For instance variables we are not required to perform initialization
 * explicitly, JVM will always provide default values.
 * 
 * RULE:
 * 
 * For final instance variable compulsory we should perform initialization
 * before constructor completion. If we are trying to perform initialization
 * anywhere else then we'll get CE: can't assign a value to final variable
 * VAR_NAME.
 * 
 * 
 * 
 * final static variables:
 * 
 * If the value of a variable is not varied from object to object, such type of
 * variables are not recommended to declare as instance variables. We have to
 * declare those variables at class level by using static modifier.
 * 
 * In the case of instance variables for every object a separate copy will be
 * created. but in the case of static variables a single copy will be created at
 * class level and shared by every object of that class.
 * 
 * For static variables it's not required to perform initialization explicitly,
 * JVM will always provide default values.
 * 
 * RULE:
 * 
 * For final static variables compulsory we should perform initialization before
 * class loading completion. If we are trying to perform initialization anywhere
 * else then we'll get CE: can't assign a value to final variable VAR_NAME.
 * 
 * 
 * final local variables:
 * 
 * Sometimes to meet the temporary requirement of the program we have to declare
 * variables inside a method or block or constructor. such type of variables are
 * called local variables or temporary variables or stack variables or automatic
 * variables.
 * 
 * For local variables JVM wont provides any default values, compulsory we
 * should perform initialization explicitly before using that variable. i.e. If
 * we are not using it's not required to perform initialization for local
 * variable.
 * 
 * NOTE:
 * 
 * If we are not declaring any modifier then by default it is default. but this
 * rule is applicable only for instance and static variables but not for local
 * variables.
 */
public class Demo_D {

	// CE: variable name might not have been initialized
	// final String name;

	/** There are three ways for final variable assignment. */
	// 1) At the time of declaration.
	final String division = "PES";

	// 2) Inside instance block.
	// Internally, instance block executes as a first statement in constructor.
	final String business_unit;
	{
		business_unit = "MMC";
	}

	// 3) Inside constructor.
	final String loginId;

	public Demo_D() {
		loginId = "ronak.nayak";
	}

	/**
	 * If the static variable declared as final then compulsory we should
	 * perform initialization explicitly. Otherwise, we'll get CE: variable
	 * employeeId might not have been initialized
	 * 
	 * Because static variables loaded before constructor invocation.
	 */
	// final static String employeeId;

	/** There are two ways for static final variable assignment. */
	// 1) At the time of declaration.
	final static int employeeId = 11001376;

	final static String emailId;
	// 2) Inside static block.
	static {
		emailId = "ronak.nayak@einfochips.com";
	}

	public static void main(String[] args) {

		/**
		 * The only applicable modifier for local variable is final. By mistake
		 * if we are trying to apply any other modifier then we'll get CE: error
		 * illegal start of expression.
		 */
		// public String name;

		/**
		 * Even though local variable is final before using only we have to
		 * perform initialization. i.e. If we are not using then it's not
		 * required to perform initialization even it declared as final.
		 */
		final int counter;

		/**
		 * Formal parameters of a method act as local variables of that method.
		 * Hence, formal parameter can be declared as final. If formal parameter
		 * declared as final within a method we can't perform reassignment.
		 */
		calculate("2016");
	}

	public static void calculate(final String year) {

		// CE: can't assign value to final variable year
		// year = "2017";

		System.out.println("Final formal parameter:" + year);
	}
}
