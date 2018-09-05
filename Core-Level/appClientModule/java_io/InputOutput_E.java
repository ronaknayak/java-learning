package java_io;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * PrintWriter:
 * 
 * It is the most enhanced writer to write character data to the file.
 * 
 * The main advantage of PrintWriter over FileWriter & BufferedWriter is we can
 * write any type of PRIMITIVE data directly to the file.
 * 
 * constructors:
 * 
 * PrintWriter p = new PrintWriter(String fileName);
 * 
 * PrintWriter p = new PrintWriter(File file);
 * 
 * PrintWriter p = new PrintWriter(Writer writer);
 * 
 * NOTE: PrintWriter can communicate directly with the file and by using any
 * writer object also.
 * 
 * The most enhanced writer to write character data to the file is PrintWriter
 * whereas the most enhanced reader to read character data from the file is
 * BufferedReader.
 * 
 * 
 * NOTE:
 * 
 * Readers and writers meant for handling character data (any primitive data
 * type) i.e. to store text data.
 * 
 * To handle binary data like images, movie files, jar files we should go for
 * streams.
 * 
 * We can use InputStream to read binary data and OutputStream to write binary
 * data. InputStreamReader class is parent class of FileReader & used to read
 * binary data. OutputStreamWriter class is parent class of FileWriter & used to
 * write binary data.
 * 
 * We can use ObjectInputStream & ObjectOutputStream to read & write objects to
 * a file respectively. i.e. For Serialization.
 */

public class InputOutput_E {
	public static void main(String[] args) {

		try {
			PrintWriter printWriter = new PrintWriter("kacha-mango.txt");

			/**
			 * print(AnyPrimitiveType)
			 * 
			 * We can pass any primitive type here & it stores value as is
			 * unlike write() method stores UNICODE value for integer value.
			 * 
			 * println(AnyPrimitiveType)
			 * 
			 * It's same as print(), but we we can also use this method as LINE
			 * SEPARATOR.
			 * 
			 * In addition to this methods, It also contains write(int i),
			 * write(char[] c), flush() etc.
			 */
			printWriter.write(100);
			printWriter.println("");
			printWriter.println(100);
			printWriter.println('A');
			printWriter.println(true);
			printWriter.print("IPICS Dev-Meeting");

			printWriter.flush();
			printWriter.close();
		} catch (IOException e) {
		}
	}
}
