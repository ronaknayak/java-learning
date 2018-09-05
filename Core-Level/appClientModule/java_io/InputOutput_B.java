package java_io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * CHARACTER STREAMS:
 * --------------------------------------------------------------------------
 * 
 * The Java Reader (java.io.Reader) and Java Writer class (java.io.Writer) in
 * Java IO work much like the InputStream and OutputStream with the exception
 * that Reader and Writer are character based.
 * 
 * Reader:
 * ==========================================================================
 * The Java Reader is the abstract class and base class of all Reader's in the
 * Java IO API.
 * 
 * Notice, that while an InputStream returns one byte at a time, meaning a value
 * between 0 and 255 (or -1 if the stream has no more data), the Reader returns
 * a char at a time, meaning a value between 0 and 65535 (or -1 if the stream
 * has no more data).
 * 
 * Writer:
 * ==========================================================================
 * The Java Writer class is the abstract class base class of all Writers in the
 * Java IO API.
 * 
 * 
 * FileWriter:
 * 
 * We can use FileWriter to write character data to the file. In that respect it
 * works much like the FileOutputStream except that a FileOutputStream is byte
 * based, whereas a FileWriter is character based.
 * 
 * Constructors:
 * 
 * FileWriter fileWriter = new FileWriter(String fileName);
 * 
 * FileWriter fileWriter = new FileWriter(File file);
 * 
 * The above FileWriter are meant for overriding of existing data inside file.
 * Instead of overriding if we want to perform append operation then we have to
 * create FileWriter by using the following constructors:
 * 
 * FileWriter fileWriter = new FileWriter(String fileName, boolean append);
 * 
 * FileWriter fileWriter = new FileWriter(File file, boolean append);
 * 
 * NOTE:
 * 
 * If the specified file is not already available then all the above four
 * constructors will create that file.
 * 
 * Issue with FileWriter:
 * 
 * We have to insert LINE SEPARATOR(\n) manually which is varied from system to
 * system. It's difficulty to the programmer.
 * 
 * We can solve this issue by using BufferedWriter and PrintWriter classes.
 */

public class InputOutput_B {
	public static void main(String[] args) {

		// Methods of FileWriter

		try {
			File file = new File("mango.txt");
			FileWriter fileWriter = new FileWriter(file, true);
			/**
			 * write(int character)
			 * 
			 * To write a single character to the file.
			 * 
			 * write(char[] characters)
			 * 
			 * To write an array of characters to the file.
			 */
			fileWriter.write(100);
			fileWriter.write('\n');
			/**
			 * write(String s)
			 * 
			 * To write a string to the file.
			 */
			fileWriter.write("summer sunday");

			/**
			 * void flush()
			 * 
			 * To give the guarantee that last characters of the data also
			 * written to the file.
			 * 
			 * This concept is only applicable for writers & not for readers.
			 * 
			 * void close()
			 * 
			 * To close the resource.
			 */
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
		}

	}
}
