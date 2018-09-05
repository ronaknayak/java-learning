package java_oops_theory;

/**
 * IS-A Relationship, HAS-A Relationship, Overloading, Overriding & Method
 * Hiding (MODULE-2):
 * 
 * This module is targeted about how to achieve Extensibility.
 * 
 * IS-A relationship is also known as Inheritance.
 * 
 * The main advantage of IS-A relationship is code REUSABILITY.
 * 
 * By using inheritance we can reuse methods and fields of parent class and also
 * for specific implementation we can add new methods and fields also. We use
 * inheritance for METHOD OVERRIDING and for CODE REUSABILITY.
 * 
 * The subclass object calls the super class method without any hesitation and
 * straightway.
 * 
 * e.g. We can call methods of DatabaseConnection class in all DAO classes by
 * extending that class (HIERARCHICAL INHERITANCE). Here, we can overcome the
 * headache of creating DatabaseConnection object.
 * 
 * ************************************************************************
 * 
 * CONCLUSIONS:
 * 
 * - Whatever methods parent class has by default available to the child class.
 * Hence, by child class reference we can call both parent class & child class
 * methods.
 * 
 * - Parent class reference can be used to hold child class objects. Hence, by
 * using parent class reference we can call parent class methods & those methods
 * we have OVERRIDED from parent class into child class. But, we can't call
 * child class specific methods.
 * 
 * 
 * The most common methods which are applicable for any type of child, we have
 * to define in parent class. The specific methods which are applicable for a
 * particular child we have to define in child class.
 * 
 * class Loan {
 * 
 * //Common methods for all types of loan.
 * 
 * }
 * 
 * class HomeLoan extends Loan { //specific methods }
 * 
 * class VehicleLoan extends Loan { //specific methods }
 * 
 * class PersonalLoan extends Loan { //specific methods }
 * 
 * Code Redundancy Problem - If we don't use Inheritance concept we have to
 * write common methods for all types of loans. Also, If any modification come
 * we need to update common methods for all types of loans.
 * 
 * e.g. Total Java API is implemented based on inheritance concept. The most
 * common methods which are applicable for any Java object are defined in object
 * class. Hence, every class in Java is the child class of object either
 * directly or indirectly. So that Object class methods by default available to
 * every Java class without rewriting. Hence, Object class act as root for all
 * Java classes.
 * 
 ***************************************************************************** 
 * 
 * Different Flavors of Inheritance:
 * 
 * 1. In single inheritance, one class extends one class only.
 * 
 * 2. In multilevel inheritance, the ladder of single inheritance increases.
 * Multiple classes are involved in inheritance, but one class extends only one.
 * The LOWER MOST SUBCLASS can make use of all its super classes members.
 * 
 * 3. In hierarchical inheritance one class is extended by more than one class.
 * It is one-to-many relationship. (Like two sons of a father; one son's
 * property cannot be shared by other but both can share the property of
 * father).
 * 
 * 4. Multiple inheritance and Hybrid inheritance are not supported in Java.
 * Though, By using interfaces you can have multiple as well as hybrid
 * inheritance in Java
 * 
 * 5. Cyclic Inheritance is not allowed in Java. For instance,
 * 
 * class A extends B {} & class B extends A {}
 * 
 * Also, class A extends A
 * 
 * **************************************************************************
 * 
 * WHY inheritance doesn't support MULTIPLE INHERITANCE ?
 * 
 * There may be chance of of ambiguity problem. Hence, we can't achieve multiple
 * inheritance by using Inheritance.
 * 
 * e.g. class FirstParent { void m() {} } & class SecondParent { void m() {} }
 * 
 * class Child extends First, Second { void m() {} }
 * 
 * HERE, compiler will ambiguity that which class m() method to call.
 * 
 * 
 * WHY ambiguity problem won't be there in INTERFACES ?
 * 
 * e.g. interface A { void write(); } & interface B { void write(); }
 * 
 * interface C extends A, B { void write(); }
 * 
 * class Child implements C { void write() {} }
 * 
 * Even though multiple method declarations are available but implementation is
 * unique. Hence, There is no chance of ambiguity problem in interfaces.
 * 
 * Strictly speaking through interfaces we won't get any Inheritance.
 * 
 * So, We can call write() method by using either A or B or C references and
 * Child class object as per the requirement. But, If we want different
 * implementation than there should be separate implementation class for each.
 * 
 * **********************************************************************
 * 
 * Note:
 * 
 * The derived class inherits all the members and methods that are declared as
 * public or protected. If declared as private it can not be inherited by the
 * derived classes. The private members can be accessed only in its own class.
 * But, derived class can declare same private method in it's own.
 * 
 * The derived class cannot inherit a member of the base class if the derived
 * class declares another member with the same name. Because, It will result in
 * overriding.
 * 
 * Inheritance & Abstract Classes:
 * 
 * The super classes are more general than their subclasses. Usually, the super
 * classes are made abstract so that the objects of its prototype cannot be
 * made. So the objects of only the subclasses can be used. To make a class
 * abstract, the keyword abstract is used in the class definition.
 * 
 * ************************************************************************
 * 
 * HAS-A relationship is also known as Composition or Aggregation. There is no
 * specific keyword to implement HAS-A relation. But, most of the time we are
 * depending on NEW keyword.
 * 
 * The main advantage of HAS-A relationship is REUSABILITY of the code.
 * 
 * e.g. class Car {
 * 
 * Engine e = new Engine(); // Car HAS-A Engine reference
 * 
 * }
 * 
 * class Engine {
 * 
 * Engine specific functionality
 * 
 * }
 * 
 * DIFFERENCE between Composition & Aggregation:
 * 
 * Without existing container object If there is no chance of existing contained
 * objects then container and contained objects are strong associated and this
 * is strong association is nothing but COMPOSITION.
 * 
 * e.g. University class consist of several Department classes. Without existing
 * University class there is no chance of existing Department class. Hence,
 * University class and Department class are strongly associated & this strong
 * association is nothing but COMPOSITION.
 * 
 * Without existing container object If there is a chance of contained objects
 * then container & contained objects are weakly associated and this weak
 * association is nothing but AGGREGATION.
 * 
 * e.g. Department class consist of several Professor classes. Without existing
 * Department class there may be a chance of existing Professor objects. Hence,
 * Department class and Professor objects are weakly associated & this weak
 * association is nothing but AGGREGATION.
 * 
 * Note: In Composition, container object holds directly contained objects
 * whereas in Aggregation container object holds just references of contained
 * objects.
 * 
 * IS-A VS HAS-A:
 * 
 * If we want total functionality of a class automatically then we should go for
 * IS-A relationship.
 * 
 * If we want part of the functionality then we should go for HAS-A
 * relationship.
 * 
 * ************************************************************************
 * 
 * Method Overloading: Refer java_oops.Demo_A file.
 * 
 * ************************************************************************
 * 
 * Method Overriding: Refer java_oops.Demo_B file.
 * 
 * ************************************************************************
 */
public class InheritanceVehicle {

	String color;
	int speed;
	int size;

	public void attributes() {
		System.out.println("Color : " + color);
		System.out.println("Speed : " + speed);
		System.out.println("Size : " + size);
	}

	private void showVehicle() {
		System.out.println("Welcome at our show-room.");
	}
}
