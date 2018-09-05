package java_collection;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Comparable VS Comparator:
 * 
 * > A Comparable object is capable of comparing itself with another number. A
 * Comparator object is capable of comparing two different objects.
 * 
 * For predefined Comparable classes default natural sorting order is already
 * available. If we are not satisfied with that we can define our own customized
 * sorting by using Comparator. e.g. String
 * 
 * For predefined Non-Comparable classes default natural sorting order is not
 * available. Compulsory we should define sorting by using Comparator object
 * only. e.g. StringBuffer
 * 
 * 
 * > In case of Comparable, If we need to sort using other fields of the class,
 * we’ll have to change that class’s compareTo() method to use those fields.
 * 
 * We can sort class objects using any field even without touching that class
 * itself; That class does not need to implement java.lang.Comparable or
 * java.util.Comparator interface.
 * 
 * 
 * > The Comparable interface is only allow to sort a single property.
 * 
 * To sort with multiple properties, we can utilize Comparator. For that, we can
 * keep multiple Comparator implementations for each property we wish to sort.
 * We can even implement some generic Comparator, if have many fields to be
 * sorted.
 */

public class Collection_O {
	public static void main(String[] args) {

		Employee employee = new Employee(104, "Pratik Soni");
		Employee employee2 = new Employee(103, "Ronak Nayak");
		Employee employee3 = new Employee(101, "Anil RajPurohit");
		Employee employee4 = new Employee(106, "Jimmi Prajapati");
		Employee employee5 = new Employee(103, "Ronak Nayak");
		Employee employee6 = new Employee(109, "Anil RajPurohit");

		TreeSet<Employee> employees = new TreeSet<Employee>();
		employees.add(employee);
		employees.add(employee2);
		employees.add(employee3);
		employees.add(employee4);
		employees.add(employee5);
		employees.add(employee6);
		System.out.println("Natural Sorting for All Users: " + employees);
		for (Employee emp : employees) {
			System.out.println(emp.getEid() + ":" + emp.getEmpName());
		}

		// TreeSet<Employee> employeesSet = new TreeSet<Employee>(
		// new EmployeeIdComparator());

		TreeSet<Employee> employeesSet = new TreeSet<Employee>(
				new EmployeeNameComparator());
		employeesSet.add(employee);
		employeesSet.add(employee2);
		employeesSet.add(employee3);
		employeesSet.add(employee4);
		employeesSet.add(employee5);
		employeesSet.add(employee6);
		System.out.println("User specific Sorting: " + employeesSet);
	}
}

class Employee implements Comparable<Employee> {

	int eid;
	String empName;

	public Employee(int eid, String empName) {
		this.eid = eid;
		this.empName = empName;
	}

	public int getEid() {
		return eid;
	}

	public String getEmpName() {
		return empName;
	}

	@Override
	public String toString() {
		return empName + "-" + eid;
	}

	@Override
	public int compareTo(Employee obj) {
		int idNew = this.eid;
		Employee employee = obj;
		int idPresent = employee.eid;

		if (idNew < idPresent) {
			return -1;
		} else if (idNew > idPresent) {
			return 1;
		} else {
			return 0;
		}
	}

}

class EmployeeIdComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee Newobj, Employee presentObj) {

		return presentObj.eid - Newobj.eid;
	}
}

class EmployeeNameComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee Newobj, Employee presentObj) {

		return Newobj.empName.compareTo(presentObj.empName);
	}
}