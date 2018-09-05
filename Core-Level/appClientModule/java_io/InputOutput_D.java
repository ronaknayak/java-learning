package java_io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Buffered Streams:
 * ---------------------------------------------------------------------------
 * By using FileReader we can read data character by character, which is not
 * convenient to the programmer & leads performance issue. This means each read
 * or write request is handled directly by the underlying OS. This can make a
 * program much less efficient, since each such request often triggers disk
 * access, network activity
 * 
 * To overcome, this problems we should go for BufferedWriter & BufferedReader.
 * 
 * Buffered input streams read data from a memory area known as a buffer; the
 * native input API is called only when the buffer is empty. Similarly, buffered
 * output streams write data to a buffer, and the native output API is called
 * only when the buffer is full.
 * 
 * BufferedWriter:
 * 
 * We can use BufferedWriter to write character data to the file.
 * 
 * constructors:
 * 
 * BufferedWriter b = new BufferedWriter(Writer w);
 * 
 * BufferedWriter never communicates directly with the file & compulsory it
 * should communicate via some writer object only.
 * 
 * BufferedWriter b = new BufferedWriter(Writer w, int bufferSize);
 * 
 * Apart from this we can also do,
 * 
 * BufferedWriter b = new BufferedWriter(new BufferedWriter(new FileWriter(new
 * File(String fileName))));
 * 
 * This is known as Two-level buffering, which may use to improve performance.
 * 
 * When compared with the FileWriter one extra capability is available in
 * BufferedWriter. That is, Inserting a new line character.
 * 
 * 
 * 
 * BufferedReader:
 * 
 * We can use BufferedReader to read character data from the file.
 * 
 * The main advantage of BufferedReader when compared with FileReader is we can
 * read data LINE BY LINE in addition to character by character.
 * 
 * constructors:
 * 
 * BufferedReader b = new BufferedReader(Reader r);
 * 
 * BufferedReader b = new BufferedReader(Reader r, int bufferSize);
 * 
 * NOTE: BufferedReader can't communicate directly with the file, compulsory it
 * should communicate via some reader object.
 * 
 * Whenever we are closing BufferedReader automatically underlying FileReader
 * will be closed & we are not required to close explicitly.
 * 
 * 
 * The most enhanced reader to read character data from the file is
 * BufferedReader.
 */

public class InputOutput_D {
	public static void main(String[] args) {

		writeByBufferedWriter();
		readByBufferedReader();
	}

	public static void writeByBufferedWriter() {

		File file = new File("mango.txt");
		try {
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			/**
			 * void write(int character)
			 * 
			 * To write a single character to the file.
			 * 
			 * write(char[] characters)
			 * 
			 * To write an array of characters to the file.
			 */
			bufferedWriter.write(66);

			/**
			 * void newLine()
			 * 
			 * To insert a LINE SEPARATOR.
			 */
			bufferedWriter.newLine();

			/**
			 * write(String s)
			 * 
			 * To write a string to the file.
			 */
			bufferedWriter.write("summer - 50 degree tempreture");

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
			 * 
			 * NOTE: Whenever we are closing BufferedWriter automatically
			 * underlying writers will be closed. That is, internal writers will
			 * be closed automatically& we are not required to close explicitly.
			 */
			bufferedWriter.flush();
			bufferedWriter.close();

		} catch (IOException e) {
		}
	}

	public static void readByBufferedReader() {

		try {
			FileReader fileReader = new FileReader("mango.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			/**
			 * String readLine()
			 * 
			 * It attempts to read next line from the file & returns it. If the
			 * next line not available then this method return null.
			 * 
			 * In addition to this method, BufferedReader has this methods:
			 * read(), read(char[] c), close() etc.
			 */
			String line = bufferedReader.readLine();
			while (line != null) {
				System.out.println(line);
				line = bufferedReader.readLine();
			}
			bufferedReader.close();

		} catch (IOException e) {
		}
	}
}
