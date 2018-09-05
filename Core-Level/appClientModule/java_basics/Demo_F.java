package java_basics;

/**
 * TYPES OF VARIABLES:
 * 
 * Division 1:
 * 
 * ->Based on the type of value represented by a variable, all variables are
 * divided into two types,
 * 
 * 1)primitive variables: can be used to represent primitive values.
 * 
 * e.g. int x=10;
 * 
 * 2)reference variable:can be used to refer objects.
 * 
 * e.g. Student s = new Student(); s is pointing to the objects.
 * 
 * 
 * 
 * Division 2:
 * 
 * ->Based on position of declaration and behavior all variables are divided
 * into three types,
 * 
 * 1) Instance variables:
 * 
 * -> If the value of a variable is varied from object to object, such type of
 * variables are called instance variables.
 * 
 * -> for every object, a separate copy of instance variable will be created.
 * 
 * -> Instance variables will be stored in HEAP memory as a part of objects, so
 * instance variables scope is exactly same as objects in memory.
 * 
 * -> We can't access instance variables from static area directly, but we can
 * access instance variables directly from instance area. e.g. method,
 * constructor.
 * 
 * 
 * 2) static variables:
 * 
 * -> If the value of a variable is not varied from object to object then it is
 * not recommended to declare variable as instance variable. we have to declare
 * such type of variable at class level by using static modifier.
 * 
 * -> In the case of instance variable for every object a separate will be
 * created but in the case of static variables a single copy will be created at
 * a class level & shared by every object of the class.
 * 
 * -> Static variables should be declare within the class directly but outside
 * of any method, block or constructor.
 * 
 * Remember:
 * 
 * -> Static variable will be created at the time of class loading & destroyed
 * at the time of class unloading. Hence, scope of static variable exactly same
 * as .CLASS file.
 * 
 * -> Static variables will be stored in METHOD AREA (just like stack memory
 * area it's for static variable storage).
 * 
 * Basic difference:
 * 
 * -> If we perform any changes for instance variables then those changes will
 * not be reflected for remaining objects because as we know for every object, a
 * separate copy of instance variable will be created.
 * 
 * -> But if we perform any changes for static variable then those changes will
 * be reflected for all objects because as we know we maintain a single copy of
 * variable & shared by every object of the class.
 * 
 * 
 * 3)Local variables:
 * 
 * -> Local variables will be stored inside stack memory area.
 * 
 * -> It is not recommended to perform initialization of local variables inside
 * logical blocks because there is no guarantee for the execution of this block
 * always at runtime.
 * 
 * It is highly recommended to perform initialization of local variables at the
 * time of declaration at least with default values.
 * 
 * -> The only applicable modifier for local variables is final.
 * 
 * 
 * CONCLUSIONS:
 * 
 * -> For instance and static variable JVM will provide default values and we
 * are not required to perform initialization explicitly. but for local variable
 * JVM will not provide default values, compulsory we should perform
 * initialization explicitly before using that variable.
 * 
 * -> Instance and static variables can be accessed by multiple threads
 * simultaneously and hence this are not thread safe. but in the case of local
 * variable for every thread a separate copy will be created and hence local
 * variables are thread safe.
 * 
 * 
 * 
 * -> Every variable in java should be either instance or static or local.
 * 
 * -> Every variable in java should be either primitive or reference. hence
 * various possible combinations of variables in java are,
 * 
 * 1) instance-primitive 2) static-reference 3) local-reference
 * 
 * 
 * The order of initialization of a class is:
 * 
 * 1. All static constants, variables and blocks.(Among themselves the order is
 * the order in which they appear in the code.)
 * 
 * 2. All non static constants, variables and blocks.(Among themselves the order
 * is the order in which they appear in the code.)
 * 
 * 3. Constructor.
 * */

public class Demo_F {

	String name = "Ronak";
	static double salary = 20000;

	long lDefault;
	float fDefault;
	char cDefault;

	public void printName() {
		// we can access instance variables directly from instance area.
		System.out
				.println("Access instance variables directly from instance area:"
						+ name);

		/*
		 * static variables are created when class loading i.e. at the begin of
		 * the program. so,we can access static variables directly from both
		 * instance and static area.
		 */
		System.out
				.println("Access static variables directly from instance area:"
						+ salary);
	}

	public void aboutLocalVar() {
		int x;
		// compile time error: variable x might not have been initialized.
		// System.out.println(x);
		if (true) {
			x = 10;
		}
		System.out.println("Access local var:" + x);

		// compile time error: illegal start of expression
		// public String name;
	}

	public void VarDefaultValues() {
		System.out.println(lDefault);
		System.out.println(fDefault);
		System.out.println(cDefault);
	}

	public static void main(String[] args) {

		// System.out.println(name);
		/**
		 * compile time error: non-static variable name can't be referenced from
		 * a static context. because static members are not at object
		 * level,unless they are existed at class level. instance variables are
		 * part of objects, therefore we can't access directly from static area
		 * directly. we can access by using object reference.
		 * */
		Demo_F demo = new Demo_F();
		System.out.println("Access instance variable from static area:"
				+ demo.name);
		demo.printName();

		/*
		 * we can access static either by object reference or by class name but
		 * recommended approach is to use class name. within the same class it
		 * is not required to class name and we can access directly.
		 */
		System.out.println("Access static variables using object reference "
				+ demo.salary);
		System.out.println("Access static variables using class name "
				+ Demo_F.salary);
		System.out.println("Access static variables within the class directly "
				+ salary);

		demo.aboutLocalVar();
		demo.VarDefaultValues();
	}

}
