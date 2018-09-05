package java_io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * FileReader:
 * 
 * We can use FileReader to read character data from the file. It works much
 * like the FileInputStream except the FileInputStream reads bytes, whereas the
 * FileReader reads characters.
 * 
 * constructor:
 * 
 * FileReader f = new FileReader(String fileName);
 * 
 * FileReader f = new FileReader(File file);
 * 
 * NOTE: By using FileReader we can read data character by character, which is
 * not convenient to the programmer.
 * 
 * 
 * Usage of FileWriter & FileReader is not recommended because:
 * 
 * While writing data by FileWriter we have to insert LINE SEPARATOR (\n)
 * manually, which is varied from system to system. It's difficult to the
 * programmer.
 * 
 */

public class InputOutput_C {
	public static void main(String[] args) {

		File file = new File("mango.txt");
		try {
			System.out.println("---------Approach-1---------");
			FileReader reader = new FileReader(file);

			/**
			 * int read()
			 * 
			 * It attempts to read next character from the file & returns it's
			 * UNICODE value.
			 * 
			 * If the next character is not available then this method returns
			 * -1.
			 * 
			 * As this method returns, UNICODE value (integer value), at the
			 * time of printing we have to perform type casting.
			 */
			int count = reader.read();
			while (count != -1) {
				System.out.print((char) count + " ");
				count = reader.read();
			}
			/**
			 * void close()
			 * 
			 * after completing read operation compulsory we have to close the
			 * resources.
			 */
			reader.close();
		} catch (IOException e) {
		}
		System.out.println("---------END---------");
		System.out.println("---------Approach-2---------");
		try {
			FileReader fileReader = new FileReader(file);

			char[] charArr = new char[(int) file.length()];

			/**
			 * int read(char[] c)
			 * 
			 * It attempts to read enough characters from the file into char
			 * array & returns number of characters copied from the file.
			 */
			fileReader.read(charArr);

			for (char ch : charArr) {
				System.out.print(ch + " ");
			}
			fileReader.close();
		} catch (IOException e) {
		}
	}
}
