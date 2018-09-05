package java_io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Object graph in serialization:
 * 
 * Whenever we are serializing an object, the set of all Objects which are
 * reachable from that object will be serialized automatically. This group of
 * objects is nothing but Object-Graph.
 * 
 * In object graph every object should be SerializablE. Otherwise, we'll get
 * java.io.NotSerializableException: java_serialization.BusinessUnit
 */

public class Serialization_3 {
	public static void main(String[] args) {

		EmployeeDetails details = new EmployeeDetails();

		try {

			FileOutputStream fileOutputStream = new FileOutputStream("emp.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					fileOutputStream);
			objectOutputStream.writeObject(details);

			FileInputStream fileIStream = new FileInputStream("emp.txt");
			ObjectInputStream stream = new ObjectInputStream(fileIStream);
			
			details = (EmployeeDetails) stream.readObject();
			System.out.println("Graph Deserialization:"
					+ details.Depdetails.unit.businessUnit);

		} catch (IOException | ClassNotFoundException exception) {
			System.out.println(exception);
		}
	}
}

class EmployeeDetails implements Serializable {
	DepartmentDetails Depdetails = new DepartmentDetails();
}

class DepartmentDetails implements Serializable {
	BusinessUnit unit = new BusinessUnit();
}

class BusinessUnit implements Serializable {
	String businessUnit = "mmc";

	public String getBU() {
		return businessUnit;
	}
}
