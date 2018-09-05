package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
* 
* @author ronak.nayak
* 
* 
* Predefined Functional Interfaces:
* ****************************************************************************
* 
* 1) Predicate(I):
* 
* A predicate is a function with a single argument and returns boolean value.
* 
* To implement predicate functions in Java, Oracle people introduced Predicate 
* interface in 1.8 version (i.e.,Predicate<T>).
* 
* Predicate interface present in Java.util.function package. It’s a functional 
* interface and it contains only one method i.e., test()
* 
* 
* Where to use:
* 
* We can use them anywhere where you need to evaluate a condition on group/collection 
* of similar objects such that evaluation can result either in true or false.
* 
* So, essentially we can use predicate to first filter certain elements from a group 
* and then perform some operation on it.
* 
* 
* Advantages:
* 
* 1) They move your conditions (sometimes business logic) to a central place. 
* This helps in unit-testing them separately.
* 
* 2) Any change need not be duplicated into multiple places. 
* It improves MANAGEABILITY of code.
* 
* 3) The code e.g. “filterEmployees(employees, isAdultFemale())” is very much 
* readable than writing a if-else block.
*/
public class Section_I {
	public static void main(String[] args) {

		Employee e1 = new Employee(1, 23, "M", "Rick", "Beethovan");
		Employee e2 = new Employee(2, 13, "F", "Martina", "Hengis");
		Employee e3 = new Employee(3, 43, "M", "Ricky", "Martin");
		Employee e4 = new Employee(4, 26, "M", "Jon", "Lowman");
		Employee e5 = new Employee(5, 19, "F", "Cristine", "Maria");
		Employee e6 = new Employee(6, 15, "M", "David", "Feezor");
		Employee e7 = new Employee(7, 68, "F", "Melissa", "Roy");
		Employee e8 = new Employee(8, 79, "M", "Alex", "Gussin");
		Employee e9 = new Employee(9, 15, "F", "Neetu", "Singh");
		Employee e10 = new Employee(10, 45, "M", "Naveen", "Jain");

		List<Employee> employees = new ArrayList<Employee>();
		employees.addAll(Arrays.asList(new Employee[] { e1, e2, e3, e4, e5, e6, e7, e8, e9, e10 }));

		System.out.println(EmployeePredicates.filterEmployees(employees, EmployeePredicates.isAdultMale()));
		
		System.out.println(EmployeePredicates.filterEmployees(employees, EmployeePredicates.isAdultFemale()));
		
		System.out.println(EmployeePredicates.filterEmployees(employees, EmployeePredicates.isAgeMoreThan(50)));
		
		//Employees other than above collection of "isAgeMoreThan(50)" can be get using negate()
        System.out.println(EmployeePredicates.filterEmployees(employees, EmployeePredicates.isAgeMoreThan(50).negate()));
        
        //Employees combination of isAdultFemale() + isAgeMoreThan(50)
		System.out.println(EmployeePredicates.filterEmployees(employees,
				EmployeePredicates.isAdultFemale().and(EmployeePredicates.isAgeMoreThan(50))));
		
		 //Employees combination of isAdultFemale() OR isAgeMoreThan(50)
		System.out.println(EmployeePredicates.filterEmployees(employees,
				EmployeePredicates.isAdultFemale().or(EmployeePredicates.isAgeMoreThan(50))));
	}
}

class Employee {
	private Integer id;
	private Integer age;
	private String gender;
	private String firstName;
	private String lastName;

	public Employee(Integer id, Integer age, String gender, String fName, String lName) {
		this.id = id;
		this.age = age;
		this.gender = gender;
		this.firstName = fName;
		this.lastName = lName;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return (this.firstName+" "+this.lastName) + " - " + this.age.toString();
	}
}

class EmployeePredicates {
	public static Predicate<Employee> isAdultMale() {
		return p -> p.getAge() > 21 && p.getGender().equalsIgnoreCase("M");
	}

	public static Predicate<Employee> isAdultFemale() {
		return p -> p.getAge() > 18 && p.getGender().equalsIgnoreCase("F");
	}

	public static Predicate<Employee> isAgeMoreThan(Integer age) {
		return p -> p.getAge() > age;
	}

	/**
	 * It is basically to make code clean and less repetitive. So, in this function
	 * we pass the list of employees and we pass a predicate, then this function
	 * will return a new collection of employees satisfying the condition mentioned
	 * in parameter predicate.
	 */
	public static List<Employee> filterEmployees(List<Employee> employees, Predicate<Employee> predicate) {
		return employees.stream().filter(predicate).collect(Collectors.<Employee>toList());
	}
}