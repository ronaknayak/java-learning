package java_oops_theory;

/**
 * POLYMORPHISM:
 * 
 * The same method called different times gives different outputs is known as
 * POLYMORPHISM. In other words it means, one method with multiple
 * implementation, for a certain class of action. And which implementation to be
 * used is decided at runtime depending upon the situation (i.e., data type of
 * the object).
 * 
 * Reference is same and runtime objects are different. Usage of parent
 * reference to hold different child objects is the concept of POLYMORPHISM.
 * 
 * e.g. List l = new ArrayList(); List l = new LinkedList(); List l = new
 * Stack(); List l = new Vector();
 * 
 * **************************************************************************
 * 
 * REASON for using -> Parent p = new Child();
 * 
 * When we don't know which runtime type of object will passed. i.e.When we
 * don't know what runtime object return from called method.
 * 
 * e.g. Element returning from ArrayList object can be any type. It may be User
 * object, Channel object, VTG object or String object etc. Hence, return type
 * of get() method is object, which can hold any object.
 * 
 * Parent class reference can be used to hold Child objects. But, by using that
 * reference we can call only methods available in Parent class, overriding
 * methods from Parent class to Child class & we can't call Child specific
 * methods.
 * 
 * 
 * When to use -> Child c = new Child();
 * 
 * When we know exact runtime type of object will passed.
 * 
 * In this case, we can call both Parent class and Child class methods.
 */
public class Polymorphism_Dynamic {

	public void disp() {
		System.out.println("disp() method of parent class");
	}

	public void abc() {
		System.out.println("abc() method of parent class");
	}
}
