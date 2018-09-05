package java_serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Serialization with respect to Inheritance:
 * 
 * Case 1:
 * 
 * If parent class is SerializablE then by default every child class is
 * SerializablE. That is SerializablE nature is inheriting from parent to child.
 * 
 * Hence, even though child class does not implement SerializablE if parent
 * class implements SerializablE then we can serialize child class object.
 * 
 * Note: Object class does not implements SerializablE interface. But,
 * GenericServlet implements SerializablE therefore all the Servlet classes in
 * Java by default SerializablE.
 */

public class Serialization_5 {
	public static void main(String[] args) {

		Download download = new Download();

		try {

			FileOutputStream fileOutputStream = new FileOutputStream("emp.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					fileOutputStream);
			objectOutputStream.writeObject(download);

			FileInputStream fileIStream = new FileInputStream("emp.txt");
			ObjectInputStream stream = new ObjectInputStream(fileIStream);
			download = (Download) stream.readObject();
			System.out.println("Serialization P -> C:" + download.maxSpeed);
			
		} catch (IOException | ClassNotFoundException exception) {
			System.out.println(exception);
		}

	}
}

class Upload implements Serializable {
	String maxSpeed = "4mbps";
}

class Download extends Upload {
	String maxSpeed = "2mbps";
}