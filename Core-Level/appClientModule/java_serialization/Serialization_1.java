package java_serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Serialization:
 * 
 * It is the process to convert normal object from Java supported form to a File
 * supported form or Network supported form. This conversion process is called
 * serialization. i.e. It's a mechanism of writing the state of an object into a
 * byte stream.
 * 
 * The process of converting object from File supported form or Network
 * supported form to Java supported form is called DeSerialization.
 * 
 * 
 * We can perform serialization only for serializable objects. An object is said
 * to be serializable if the corresponding class implements Serializable
 * interface. So, It must be implemented by the class whose object you want to
 * persist.
 * 
 * Serializable interface present in java.io package and does not contain any
 * method, it is a marker interface.
 * 
 * If we are trying to serialize a non-Serializable object we'll get CE:
 * NotSerializableException.
 * 
 * It is mainly used to travel object's state on the network.
 * 
 * ObjectOutputStream(c):
 * 
 * The Java ObjectOutputStream class (java.io.ObjectOutputStream) enables you to
 * write Java objects to an OutputStream instead of just raw bytes. You wrap an
 * OutputStream in a ObjectOutputStream and then you can write objects to it.
 * 
 * ObjectInputStream(c):
 * 
 * The Java ObjectInputStream class (java.io.ObjectInputStream) enables you to
 * read Java objects from an InputStream instead of just raw bytes. You wrap an
 * InputStream in a ObjectInputStream and then you can read objects from it.
 * 
 * 
 * 
 * transient keyword:
 * 
 * At the time of serialization if we don't want to serialize the value of a
 * particular variable to meet the security constraint, we have to declare these
 * variable with transient keyword.
 * 
 * At the time of serialization, JVM ignores original value of transient
 * variable and saves default value.
 * 
 * 
 * transient VS static:
 * 
 * static variables are not part of object. Hence, they won't participate in
 * serialization process. Due to this, declaring static variable as transient
 * there is no impact.
 * 
 * transient VS final:
 * 
 * final variables will be participate in serialization directly by their
 * values. Hence, declaring final variable with transient there is no impact.
 */

public class Serialization_1 {

	public static void objSerialization() {

		Employee employee = new Employee("Ronak Nayak", 20000.00);
		try {
			/**
			 * By using FileOutputStream and ObjectOutputStream classes we can
			 * achieve serialization. As FileOutputStream accept only binary
			 * form, first ObjectOutputStream convert normal object into binary
			 * form and send it to FileOutputStream.
			 */
			FileOutputStream fileOutputStream = new FileOutputStream("emp.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					fileOutputStream);
			objectOutputStream.writeObject(employee);

			objectOutputStream.flush();
			objectOutputStream.close();
			System.out.println("Serialization Done");
		} catch (IOException exception) {
			System.out.println(exception);
		}
	}

	public static void objDeSerialization() {

		try {
			/**
			 * 
			 * By using FileInputStream and ObjectInputStream classes we can
			 * achieve DeSerialization. FileInputStream sends binary data to
			 * ObjectInputStream, where ObjectInputStream convert binary data to
			 * normal object form.
			 */
			FileInputStream fileInputStream = new FileInputStream("emp.txt");
			ObjectInputStream objectInputStream = new ObjectInputStream(
					fileInputStream);

			Employee employee = (Employee) objectInputStream.readObject();
			System.out
					.println(employee.getName() + "\t" + employee.getSalary());
			
			objectInputStream.close();
		} catch (IOException | ClassNotFoundException exception) {
			System.out.println(exception);
		}
	}

	public static void main(String[] args) {

		objSerialization();
		objDeSerialization();
	}
}

class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private transient double salary;

	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}