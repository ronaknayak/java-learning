package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
* 
* @author ronak.nayak
* 
* 
* Predefined Functional Interfaces:
* ****************************************************************************
* 
* 3) Consumer(I):
* 
* Consumer<T> is an in-built functional interface introduced in Java 8 in the 
* java.util.function package.
* 
* Consumer can be used in all contexts where an object needs to be consumed, 
* i.e. taken as input, and some operation is to be performed on the object 
* without returning any result. 
* 
* accept() method is the primary abstract method of the Consumer functional 
* interface. i.e. accept() method takes as input the type T and returns 
* no value.
* 
* In case of consumer type parameter would be input. 
* i.e. For Consumer<Employee> we pass Employee object as input.
* 
* 
* 
* 4) Supplier(I):
* 
* Supplier<T> is an in-built functional interface introduced in Java 8 in the 
* java.util.function package.
* 
* Supplier can be used in all contexts where there is no input but an output 
* is expected.
* 
* get() method is the primary abstract method of the Supplier functional 
* interface. i.e. get() method takes no input and returns an output of type T.
* 
* In case of supplier type parameter would be output. 
* i.e. For Supplier<Employee> we get Employee object as return value.
* 
*/
public class Section_K {
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
		
		printEmpList(employees, consumeEmployee());
		
		String[] roles = supplyRoles().get();
		System.out.println("\nRole Access:");
		for (String role : roles) {
			System.out.println(role);
		}
		
	}

	public static void printEmpList(List<Employee> employeeList,
			Consumer<Employee> consumerEmp) {
		
		employeeList.forEach(employee -> {
			consumerEmp.accept(employee);
		});
	}
	
	public static Consumer<Employee> consumeEmployee() {
		 return emp -> System.out.println(emp);
	}
	
	public static Supplier<String[]> supplyRoles() {
		 return () -> new String[] { "Admin", "Sales Person", "Technical Assistant" };
	}
}
