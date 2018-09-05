package java_io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * We can serialize any number of objects to the file, but in which order we
 * serialized in the same order we have to DeSerialize. Hence, proven order of
 * objects is important.
 * 
 * Otherwise, we'll get ClassCastException.
 */

public class Serialization_2 {
	public static void main(String[] args) {

		EmployeeBasic employee = new EmployeeBasic("Ronak Nayak", 20000.00);
		Department department = new Department();
		department.setDepartment("PES");
		try {

			FileOutputStream fileOutputStream = new FileOutputStream("emp.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					fileOutputStream);
			objectOutputStream.writeObject(employee);
			objectOutputStream.writeObject(department);
			
			objectOutputStream.flush();
			objectOutputStream.close();
			
			FileInputStream fileIStream = new FileInputStream("emp.txt");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileIStream);
			
			employee = (EmployeeBasic) objectInputStream.readObject();
			department = (Department) objectInputStream.readObject();

			System.out.println(employee.getName() + "|"
					+ department.getDepartment() + "|" + employee.getSalary());
			
			objectInputStream.close();
		} catch (IOException | ClassNotFoundException exception) {
			System.out.println(exception);
		}
	}
}

class EmployeeBasic implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1290623925592275585L;
	
	private String name;
	private double salary;

	public EmployeeBasic(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}
}

class Department implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String department;

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}