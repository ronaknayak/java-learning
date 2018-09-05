package java_oops_theory;

/**
 * Coupling, Cohesion, Object Type-Casting (MODULE-4):
 * ---------------------------------------------------------------------------
 * The degree of dependency between the components is called coupling.
 * 
 * If dependency is more then it is considered as TIGHTLY coupling and If
 * dependency is less then it is considered as LOOSELY coupling.
 * 
 * (ENTHUWARE) The less a class knows about the internal details of another
 * class the better. It means that the classes have low coupling. For low
 * coupling, a class should only expose public methods and another class should
 * only access those public methods.
 * 
 * Tightly coupling is not a good programming practice because It has several
 * serious disadvantages:
 * 
 * - Without affecting remaining components we can't modify any component.
 * Hence, ENHANCEMENT will become difficult.
 * 
 * - It suppresses REUSABILITY. Because tightly coupled class would not let us
 * to use their functionality without being dependent with other class. So, we
 * have to achieve that functionality by creating in our class.
 * 
 * - It reduces MAINTAINABILITY of the application.
 * 
 * Hence, we have to maintain dependency between the components as less as
 * possible. That is, Loosely coupling is a good programming practice.
 * 
 * 
 * 
 * ***********************************************************************
 * 
 * 
 * Cohesion means how focused is a class with respect to the functionality that
 * it provides. If it does multiple unrelated things, it is low on cohesion. Low
 * cohesion is a bad thing.
 * 
 * For every component a clear well defined functionality is defined then that
 * component is said to be follow HIGH-Cohesion.
 * 
 * (ENTHUWARE) By cohesion, you should think of Focus. High Cohesion implies
 * highly focused. A highly focused class does only one thing instead of doing
 * multiple things, which is also known as the SINGLE RESPONSIBILITY PRINCIPLE
 * like DAO pattern.
 * 
 * Disadvantages of LOW-Cohesion:
 * 
 * ENHANCEMENT become extreme difficult as for small change i.e. A small change
 * in Look and Feel, we have to cross-check to many things.
 * 
 * REUSABILITY goes down because to make any functionality of that component we
 * have to load entire component wherever we required. e.g. to use validation()
 * method we have to load entire SERVLET whose having other functionalities.
 * 
 * MAINTAINABILITY will become a big headache.
 * 
 * 
 * We can overcome these all issues by following High-Cohesion. It is good
 * programming practice. For instance, MVC MODEL.
 * 
 * 
 * Note(ENTHUWARE):
 * 
 * public class Customer{    
 * 
 * public void addToAccount(double amt){ ... }
 * 
 * public void withdrawFromAccount(double amt){ ... }
 * 
 * public void printAccountStatement(){ ... }
 * 
 * public void updateAddress(){ ... }    
 * 
 * public void sendEmail(Email em){ ... }
 * 
 * }
 * 
 * Cohesion means Focus. If a class does only one thing (or multiple highly
 * related operations), it is highly focused and that means it illustrates high
 * cohesion. In this case, Customer class is trying to do multiple unrelated
 * things - operating an account and managing address. Thus, it is not so
 * focused and is therefore less cohesive.
 * 
 * *********************************************************************
 * 
 * Type-Casting: Look in eBook
 */

public class Coupling {
	public static void main(String[] args) {

	}
}

// The below components are said to be TIGHTLY COUPLED with each other. Because
// dependency between the components is more.
class A1 {

	public String getMethod() {
		B1 b = new B1();

		return b.getMethod();
	}
}

class B1 {

	public String getMethod() {
		C1 c = new C1();

		return c.getMethod();
	}
}

class C1 {

	public String getMethod() {
		D1 d = new D1();

		return d.getMethod();
	}
}

class D1 {
	public String getMethod() {
		return "http";
	}
}