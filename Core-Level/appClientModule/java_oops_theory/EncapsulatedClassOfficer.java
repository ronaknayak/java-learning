package java_oops_theory;

/**
 * OOPS:
 * 
 * It is an object oriented programming system to represent all the real world
 * entities in terms of Objects and Classes. It provides SECURITY, REUSABILITY,
 * FLEXIBILITY and HIDING COMPLEXITY.
 * 
 * 
 * Data Binding, Data Hiding, Abstraction, Encapsulation & Tightly Encapsulated
 * Class (MODULE-1):
 * 
 * This module is targeted for to achieve security.
 * 
 * For example, There is one Officer named class and salary is an instance
 * variable and should be accessed with an object only, Two objects o1 and o2
 * are created and salary field is called. The object o1 gets a salary of 5000
 * and o2 gets 6000.
 * 
 * If an instance variable is called with an object, a location is created in
 * the memory. Now, two locations are created in the memory for o1.salary and
 * o2.salary. That is, one location of salary is binded with o1 and another
 * location of salary is binded with o2. This is is known as DATA BINDING.
 * 
 * *************************************************************************
 * 
 * If a field is declared as private, it cannot be accessed by any other class
 * outside the class, thereby hiding the fields within the class. This is known
 * as DATA HIDING.
 * 
 * By using PRIVATE MODIFIER we can implement Data Hiding. Some classes would
 * like to assign salary to emp1oyee object and they may give any amount of
 * salary. To control this, public int salary can be made it as private int
 * salary and give reading access by giving corresponding public methods.
 * 
 * e.g. After authentication, If we are authenticated successively, Banking
 * application returns our balance information by public double getBalance()
 * method and as variable balance is private no other class can access it
 * directly & modify.
 * 
 * The main advantage of data hiding is Security.
 * 
 * NOTE: It's highly recommended to declare data member (Variables) as private.
 * 
 * 
 * ABSTRACTION: --> Refer Bank_Abstraction File.
 * 
 * *************************************************************************
 * 
 * ENCAPSULATION is the technique of making the fields in a class private and
 * providing access to the fields via public methods.
 * 
 * If a field is declared private, it cannot be accessed by anyone outside the
 * class, thereby hiding the fields within the class. For this reason,
 * encapsulation is also referred to as DATA HIDING.
 * 
 * ADVANTAGE:
 * 
 * > The main benefit of encapsulation is the ability to modify our implemented
 * code without breaking the code of others who use our code. With this feature
 * Encapsulation gives maintainability, flexibility and extensibility to our
 * code.
 * 
 * For instance, consider a field is public in a class which is accessed by
 * other classes. Now later on, you want to add any extra logic while getting
 * and setting the variable. This will impact the existing client that uses the
 * API. So any changes to this public field will require change to each class
 * that refers it.
 * 
 * > Prevents the code and data being randomly accessed by other code defined
 * outside the class. Because to access those fields, We must go through by
 * set() method provided by that class.
 * 
 * 
 * 
 * 
 * To put more clear, Encapsulating data means not from user. But, from the
 * classes which are using our class data so that they can't assign wrong values
 * to our class data and leave us by changing our code. For that, Keep instance
 * variables protected (with an access modifier, often private) and a private
 * variable can be accessed through a public method by another class.
 * 
 * The advantage is the other class cannot assign wrong values to the variables.
 * The values passed by other class can be checked in a public method and if
 * found correct, assigned to the private variables; else rejected.
 * 
 * 
 * USECASE:
 * 
 * public ArrayList<Integer> getScores(){ return scores; }
 * 
 * Change getScores to return a copy of the scores list:
 * 
 * public ArrayList<Integer> getScores(){ return new ArrayList(scores); }
 * 
 * If you return the same scores list, the caller would be able to add or remove
 * elements from it, thereby rendering the average incorrect. This can be
 * prevented by returning a copy of the list.
 * 
 * CONCLUSION: If there is an Object type variable in Encapsulated class, We
 * have to design getMethod() in such a way that It returns a new copy of that
 * object. This is standard convention for this case.
 * 
 * 
 * TIGHTLY ENCAPSULATED CLASS:
 * 
 * A class is said to be tightly encapsulated, If and only if each and every
 * variable declared as private.
 * 
 * Whether class contains corresponding getter() and setter() method or not &
 * whether this methods are declared as public or not, this things we are not
 * required to check.
 * 
 * If Parent class is not tightly encapsulated then no child class in tightly
 * encapsulated.
 * 
 * 
 * 
 * Abstraction VS Encapsulation:
 * 
 * Abstraction is used for hiding the unwanted data and giving relevant data.
 * while Encapsulation means hiding the code and data into a single unit to
 * protect the data from outside world.
 */

public class EncapsulatedClassOfficer {

	private int salary;

	public int getSalary() {
		// Authenticate User
		return salary;
	}

	public void setSalary(int salary) {
		// Authenticate User
		if (salary > 0) {
			this.salary = salary;
		} else {
			throw new RuntimeException("Invalid Input for Salary.");
		}
	}

}
