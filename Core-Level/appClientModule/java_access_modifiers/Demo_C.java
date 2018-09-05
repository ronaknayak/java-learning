package java_access_modifiers;

/**
 * Member(method or variable) Level Modifiers:
 * 
 * 1. public member:
 * 
 * If we declare a member as public then we can access that member from anywhere
 * but corresponding class should be visible that means it should be public.
 * 
 * For example, Even though, method is public we can't access that method from
 * outside of package if corresponding class is not declared as public. If both
 * are public then only we can access.
 * 
 * CONCLUSION: Before checking member visibility we have to check first class
 * visibility.
 * 
 * 
 * 2. default member:
 * 
 * If we declare a member as default, then we can access that member only with
 * in current package and we can't access from outside of package. Hence,
 * default access is known as PACKAGE LEVEL ACCESS.
 * 
 * 
 * 3. private member:
 * 
 * If we declare member as private. then we can access that member only within
 * current class.
 * 
 * abstract methods should be available to the child classes to provide
 * implementation whereas private methods are not available to the child
 * classes. Hence, private abstract combination is illegal for methods.
 * 
 * 
 * 4. protected member (<DEFAULT> + Child classes of another package):
 * 
 * If a member declared as protected then we can access that member within
 * current package anywhere but outside package only in child classes.
 * 
 * NOTE:
 * 
 * Within current package we can access protected members either by parent class
 * reference or by child reference. But, from outside of package we can access
 * protected members only by using child class reference. If we try to use it by
 * parent class then we'll get CE: Method_Name has protected access in
 * Package_Name.Class_Name.
 * 
 * RULE: e.g. Although, class B extends class A and 'i' is a protected member of
 * A, B still cannot access i (now this is imp) through A's reference because B
 * is not involved in the implementation of A.
 * 
 * We can access protected members from outside package only in child classes
 * and we should use that child class reference only. For example,
 * 
 * package first; class A { protected void make() { } }
 * 
 * package second; class B extends A { }
 * 
 * class C extends B { }
 * 
 * If we access make() from C class then we can access it by using C class
 * reference only.
 * 
 * Therefore, A a = new B(); a.make() is invalid from outside of package.
 */
public class Demo_C {

	protected void property() {
		System.out.println("outside package, need child class reference.");
	}
}