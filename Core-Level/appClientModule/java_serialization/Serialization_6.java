package java_serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Case 2:
 * 
 * Conclusion 1:
 * 
 * Even though, parent class does not implements SerializablE interface we can
 * serialize child class object if child class implements SerializablE
 * interface.
 * 
 * i.e. to serialize child class object parent class need not to be
 * SerializablE. For example, Even though Object class doesn't implement
 * SerializablE we can create our own class which implements SerializablE
 * interface.
 * 
 * Conclusion 2:
 * 
 * At the time of serialization, JVM will check is any instance variable is
 * inheriting from Non-SerializablE parent or not. If any variable is inheriting
 * from Non-SerializablE parent then JVM ignores original value and save default
 * value to the file.
 * 
 * Conclusion 3:
 * 
 * At the time of DeSerialization JVM will check is any parent class is
 * Non-SerializablE or not. If any parent class is Non-SerializablE then JVM
 * will create separate object for every Non-SerializablE parent and share it's
 * instance variable to the current object.
 * 
 * Conclusion 4:
 * 
 * For this JVM always executes no-argument constructor of the Non-SerializablE
 * parent class. So, there should have programmer provided constructor or
 * compiler generated constructor. If the Non-SerializablE parent class doesn't
 * have no-argument constructor then we'll get RE: InvalidClassException.
 */

public class Serialization_6 {

	public static void main(String[] args) {
		
		Screen screen = new Screen();
		screen.iScreen = 10;
		screen.iShow = 5;
		try {

			FileOutputStream fileOutputStream = new FileOutputStream("emp.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					fileOutputStream);
			objectOutputStream.writeObject(screen);
			System.out.println("Serialization done...");
			
			FileInputStream fileIStream = new FileInputStream("emp.txt");
			ObjectInputStream stream = new ObjectInputStream(fileIStream);
			Screen scr = (Screen) stream.readObject();
			System.out.println("deserialization C -> P: " + scr.iScreen+"\t"+scr.iShow);

		} catch (IOException | ClassNotFoundException exception) {
			System.out.println(exception);
		}

	}
}

class Multiplex {
	
	int iScreen = 4;
	public Multiplex() {
		System.out.println("compulsory executed.");
	}
}

class Screen extends Multiplex implements Serializable {
	int iShow = 3;
	public Screen() {
		System.out.println("Screen constructor.");
	}
}