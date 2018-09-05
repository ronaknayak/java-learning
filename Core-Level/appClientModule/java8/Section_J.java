package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
* 
* @author ronak.nayak
* 
* 
* Predefined Functional Interfaces:
* ****************************************************************************
* 
* 2) Function(I):
* 
* Functions are exactly same as predicates except that functions can return 
* any type of result but function should (can) return only one value and 
* that value can be any type as per our requirement.
* 
* Function interface present in Java.util.function package. Functional interface 
* contains only one method i.e., apply()
* 
* 
* The primary purpose for which Function<T, R> has been created for mapping 
* scenarios i.e when an object of a type is taken as input and it is 
* converted(or mapped) to another type. 
* 
* Common usage of Function is in streams where-in the map function of a stream 
* accepts an instance of Function to convert the stream of one type to a stream 
* of another type.
*/
public class Section_J {
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
		
		List<String> employeeNames = convertEmpListToNamesList(employees, functionEmployeeName());
		
		System.out.println(employeeNames);
	}

	public static List<String> convertEmpListToNamesList(List<Employee> employeeList,
			Function<Employee, String> funcEmpToString) {
		
		List<String> empNameList = new ArrayList<String>();
		
		employeeList.forEach(employee -> {
			empNameList.add(funcEmpToString.apply(employee));
		});
		return empNameList;
	}
	
	public static Function<Employee, String> functionEmployeeName() {
		return (Employee e)-> {
			return e.getFirstName();
		};
	}
}
