package java_serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Customized Serialization:
 * 
 * Need of Customized Serialization: In default Serialization there may be
 * chance of loss of information because of TRANSIENT keyword.
 * 
 * In Serialization, at sender side & receiver side if we do some extra work
 * then we can able to recover loss of information. This extra work is nothing
 * but Customized Serialization.
 * 
 * 
 * We can implement Customized Serialization by using the following two methods
 * in corresponding class:
 * 
 * private void writeObject(ObjectOutputStream o) throws Exception
 * 
 * This method will be executed automatically at the time of serialization &
 * it's a call back method i.e. automatically called by JVM.
 * 
 * Hence, while performing serialization if we want to do any extra work we have
 * to write corresponding code in this method only.
 * 
 * private void readObject(ObjectInputStream o) throws Exception
 * 
 * This method will be executed automatically at the time of DeSerialization &
 * it's a call back method.
 * 
 * Hence, while performing DeSerialization if we want to do any extra work we
 * have to write corresponding code in this method only.
 * 
 * As this methods called by JVM automatically, syntax must be like this.
 */

public class Serialization_4 {
	public static void main(String[] args) {

		Account account = new Account();

		try {

			FileOutputStream fileOutputStream = new FileOutputStream("emp.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					fileOutputStream);
			
			/**
			 * Whenever we serialize an object JVM will check whether Account
			 * class contains writeObject() or not. If JVM found, then it'll
			 * invoke user defined writeObject().
			 */
			objectOutputStream.writeObject(account);
			
			objectOutputStream.flush();
			objectOutputStream.close();

			FileInputStream fileIStream = new FileInputStream("emp.txt");
			ObjectInputStream stream = new ObjectInputStream(fileIStream);
			
			/**
			 * Whenever we DeSerialize an object JVM will check whether Account
			 * class contains readObject() or not. If JVM found, then it'll
			 * invoke user defined readObject().
			 */
			account = (Account) stream.readObject();
			System.out.println(account.getUsername() + " - "
					+ account.getPassword());
			
			stream.close();
		} catch (IOException | ClassNotFoundException exception) {
			System.out.println(exception);
		}
	}
}

class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String username = "ronaknayak8699";
	transient String password = "krishna";

	private void writeObject(ObjectOutputStream oos) throws Exception {
		/*
		 * Below method meant for default serialization. After this method call
		 * ronaknayak8699 and null would be written in file.
		 */
		oos.defaultWriteObject();

		// Extra work done here & that object will be written in file.
		String encryPwd = "123" + this.password;
		oos.writeObject(encryPwd);
	}

	private void readObject(ObjectInputStream ois) throws Exception {
		/*
		 * Below method meant for default DeSerialization. After this method
		 * call ronaknayak8699 and null would be read from file.
		 */
		ois.defaultReadObject();
		
		// Extra work done here & that object will be read from file.
		String decryPwd = (String) ois.readObject();
		this.password = decryPwd.substring(3);
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}