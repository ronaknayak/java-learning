package java_access_modifiers;

/**
 * Class Level Modifiers:
 * 
 * 4) abstract modifier:
 * 
 * abstract method:
 * 
 * Even though we don't know about implementation, still we can declare a method
 * with abstract modifier. i.e. for abstract methods only declaration is
 * available but not implementation.
 * 
 * Hence, abstract method declaration should ends with SEMI-COLON.
 * 
 * By declaring method as abstract in the parent class we can provide guidelines
 * to the child classes such that which method child has to implement. So, we
 * can guarantee that child class definitely going to give implementation for
 * parent class method.
 * 
 * 
 * abstract method never talks about implementation, if any modifier talks about
 * implementation then it forms illegal combination with abstract modifier.
 * 
 * Illegal combinations of modifiers for methods with respect to abstract:
 * FINAL, STATIC, PRIVATE, SYNCHRONIZED, STRICTFP, NATIVE. If we form such
 * combinations we'll get CE: illegal combination of modifier abstract and
 * final.
 * 
 * So,only legal combinations with abstract method are <DEFAULT>, PUBLIC and
 * PROTECTED.
 * 
 * 
 * abstract class:
 * 
 * For any java class if we don't want to allow create an object because of
 * partial implementation, such type of class we have to declare with abstract
 * modifier. i.e. for abstract classes instantiation is not possible either
 * directly or indirectly.
 * 
 * Only allowed modifiers with abstract classes are PUBLIC,<DEFAULT> and
 * STRICTFP.
 * 
 * 
 * abstract class VS abstract method:
 * 
 * CONCLUSION 1: If a class contains at least one abstract method then
 * compulsory we should declare class as abstract or else we'll get CE: missing
 * method body , or declare abstract.
 * 
 * REASON: If a class contains at least one abstract method then implementation
 * is not complete and hence it is not recommended to create object. To restrict
 * object instantiation compulsory we should declare class as abstract.
 * 
 * 
 * CONCLUSION 2: Even though class doesn't contain any abstract method still we
 * can declare class as abstract if we don't want instantiation. i.e.abstract
 * class can contain zero number of abstract methods also.
 * 
 * If we are extending any abstract class, for each and every abstract method
 * present in parent class we have to provide implementation. Otherwise we have
 * to declare child class as abstract, in this case next level child class is
 * responsible to provide implementation.
 * 
 * 
 * ABSTRACT VS FINAL:
 * 
 * abstract methods we have to override in child classes to provide
 * implementation whereas final method can't be override. Hence, abstract final
 * combination is always illegal for methods.
 * 
 * For abstract class we should create child class to provide implementation but
 * for final classes we can't create child class.hence, abstract final is
 * ILLEGAL for classes.
 * 
 * abstract class can contain final methods(Though, it should be CONCRETE
 * methods). But reverse is not possible as final class can't have abstract
 * methods.
 * 
 * NOTE: It is highly recommended to use abstract modifier because it promotes
 * several OOPS features like INHERITANCE and POLYMORPHISM.
 */

public abstract class Demo_B {

	// Only visibility modifiers allowed i.e public, protected & <DEFAULT>
	abstract protected void m1();

	final void m2() {
	}

}
