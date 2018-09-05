package java_access_modifiers;

/**
 * static modifier:
 * 
 * static is the modifier applicable for methods and variables but not for
 * classes. we can't declare top level class with the static modifier but we can
 * declare inner class with static. such type of Inner class known as static
 * NESTED CLASS.
 * 
 * In the case of instance variable for every object a separate copy will be
 * created but in the case of static variable a single copy will be created at
 * class level and shared by every object of that class.
 * 
 * 
 * CASE 1: For static methods METHOD OVERLOADING concept is applicable. Hence
 * within same class we can declare 2 main methods.
 * 
 * CASE 2: Inheritance concept applicable for static methods including main()
 * method. Hence, while executing child class if child does not contain main()
 * then parent class main() will be executed.
 * 
 * CASE 3: It seems METHOD OVERRIDING concept is applicable for static methods
 * but it's not overriding but it's method hiding.
 * 
 * 
 * Inside method implementation if we are using at least one instance variable
 * then that method talks about a particular object.Hence, we should declare
 * method as INSTANCE method.
 * 
 * Inside method implementation if we are not using any instance variable then
 * that method nowhere related to a particular object. Hence, we have to declare
 * such type of method as STATIC method irrespective of whether we are using
 * static variables or not.
 * 
 * 
 * NOTE: For static methods, implementation should be available whereas for
 * abstract methods implementation is not available. Hence abstract static
 * combination is illegal for methods.
 */

public class Demo_E {

	/*
	 * We can't declare instance and static members(VARIABLES and METHODS) with
	 * the same name.
	 */
	static int staticVar = 10;
	int instanceVar = 20;

	public void instanceArea() {

		/**
		 * static members are created at the time of class loading so we can
		 * access from anywhere directly.
		 * */
		System.out.println("from instance area staticVar= " + staticVar);
		System.out.println("from instance area instanceVar= " + instanceVar);
	}

	public static void staticArea() {

		System.out.println("from static area staticVar= " + staticVar);

		/**
		 * From static area we can't access instance members directly because it
		 * nowhere related to object.
		 */
		// System.out.println("from static area instanceVar= "+instanceVar);
	}

	public static void main(String[] args) {

		Demo_E d = new Demo_E();
		d.staticVar = 50;
		d.instanceVar = 60;

		Demo_E de = new Demo_E();

		// Because static variable changed value is effected on both objects
		System.out.println("Static Variable = " + de.staticVar
				+ " Instance Variable = " + de.instanceVar);

	}

	public static void main(int[] args) {

	}
}
