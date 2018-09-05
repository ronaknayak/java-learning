package java_exception_handling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * As a part of 1.7 version in exception the following two concepts introduced:
 * 
 * 1. try-with-resources statement(Automatic Resource Management):
 * 
 * A resource is an object that must be closed after the program is finished
 * with it. The try-with-resources statement ensures that each resource is
 * closed at the end of the statement.
 * 
 * Until 1.6 version it is highly recommended to write finally block to close
 * resources which are open at the part of try block.
 * 
 * From 1.7 version onwards the main advantage of try with resources is whatever
 * resources we open at a part of try block, will be closed automatically and we
 * are not required to close automatically. e.g. Database Connection
 * 
 * Therefore, complexity of the code will be reduced.
 * 
 * We don't have need to write finally block. So that length of the code will be
 * reduced and readability of the code will be improved.
 * 
 * 
 * 
 * 
 * Note(ENTHUWARE):
 * 
 * > There are a few things to note:
 * 
 * 1. Once a Connection object is closed, you cannot access any of the
 * subsequent objects such as Statement and ResultSet that are retrieved from
 * that Connection.
 * 
 * 2. The references declared in the try block (in this case, c and ResultSet)
 * are not visible outside the try block. Not even in the catch block.
 * 
 * 3. When a resource is created in the try-with-resources block ( in this case,
 * c), it is closed at the end of the try block irrespective of whether there is
 * an exception in the try block or not.
 * 
 * 4. Catch and finally blocks are executed after the resource opened in
 * try-with-resources is closed.
 * 
 * 
 * 
 * 
 * You need to know the following points regarding try-with-resources statement
 * for the exam:
 * 
 * 1. The resource class must implement java.lang.AutoCloseable interface. Many
 * standard JDK classes such as BufferedReader, BufferedWriter implement
 * java.io.Closeable interface, which extends java.lang.AutoCloseable.
 * 
 * 2. Resources are closed at the end of the try block and before any catch or
 * finally block.
 * 
 * 3. Resources are not even accessible in the catch or finally block.
 * 
 * 4. Resources are closed in the reverse order of their creation.
 * 
 * 5. Resources are closed even if the code in the try block throws an
 * exception.
 * 
 * 6. java.lang.AutoCloseable's close() throws Exception but java.io.Closeable's
 * close() throws IOException.
 * 
 * 7. If code in try block throws exception (or an exception thrown while
 * opening a resource) and an exception also thrown while closing is resource,
 * the exception thrown while closing the resource is suppressed. The caller
 * gets the exception thrown in the try block.
 * 
 * 8. The AUTO-CLOSEABLE VARIABLES defined in the try-with-resources statement
 * are implicitly final. Thus, they cannot be reassigned.
 * 
 */

public class Demo_I {

	public static void main(String[] args) throws SQLException {

		System.out.println("end");
		try (PrintWriter writer = new PrintWriter("abc.txt")) {

			// use writer resource based on our requirement
			writer.write("Ronak Nayak");

			/*
			 * writer will be closed automatically once control reaches at the
			 * end of try block either normally or abnormally and we are not
			 * responsible to close explicitly.
			 */
		} catch (IOException e) {
			System.out.println("There is problem in writting data into file.");
		}

		/**
		 * Conclusion 1:
		 * 
		 * We can declare multiple resources but this resources should be
		 * separated with the semicolon.
		 * 
		 * All resources should be AutoCloseable resources. A resources said to
		 * be AutoCloseable if and only if corresponding class implements
		 * java.lang.AutoCloseable interface.
		 * 
		 * All IO related resources, database related resources and network
		 * related resources are already implements AutoCloseable interface
		 * directly or indirectly. Being a programmer we are not required to do
		 * anything. Just, we should aware the point.
		 * 
		 * */
		try (FileWriter fileWriter = new FileWriter("output.txt");
				FileReader fileReader = new FileReader("input.txt")) {
			fileWriter.write("Happy Sunday!!!!!!");
		} catch (IOException e) {
			// handle exception
			e = new IOException();
		}

		/**
		 * Conclusion 2:
		 * 
		 * AutoCloseable interface came in 1.7 version and it contains only one
		 * method i.e.public void close() throws Exception
		 */

		/**
		 * Conclusion 3:
		 * 
		 * All resource reference variables are implicitly final and hence
		 * within the try block we can't perform reassignment. Otherwise we'll
		 * get compile time error.
		 */
		try (FileInputStream inputStream = new FileInputStream(new File(
				"output.txt"))) {

			// inputStream = new FileInputStream("output.txt");
		} catch (IOException ex) {

		}

		/**
		 * Conclusion 4:
		 * 
		 * Until 1.6 version try should be associated with either catch or
		 * finally but from 1.7 version onwards we can take only try with
		 * resource without catch or finally.
		 */
		try (Connection conn = DriverManager.getConnection("")) {
			// database connection related code
		}

		/**
		 * Conclusion 5:
		 * 
		 * close is the only method in AutoCloseable and it gets automatically
		 * invoked at runtime.
		 * 
		 * close() method is automatically called for all IO, database and
		 * network related resources, if it throws an exception, it will be
		 * suppressed.
		 */

		/**
		 * Conclusion 6:
		 * 
		 * If an exception is thrown in both try block and finally block, the
		 * method returns the exception thrown in finally block.
		 * 
		 * For try-with-resources, if exception is thrown in try block and in
		 * try-with-resources statement, then method returns the exception
		 * thrown in try block.
		 */

		/**
		 * Conclusion 7:
		 * 
		 * Observe that the declaration of try-with-resources statement is
		 * wrong. The type of the resource must be specified in the try itself.
		 * i.e. it should be: try(Statement st = c.createStatement())
		 */
		Statement st = null;
		Connection c = DriverManager.getConnection(
				"jdbc:derby://localhost:1527/sample", "app", "app");
		// try (st = c.createStatement()) {
		//
		// }
	}
}
