package java_io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * OutputStreamWriter:
 * 
 * It's sub-class of Writer class.
 * 
 * A Java Writer can be combined with an OutputStream. The Java
 * OutputStreamWriter class (java.io.OutputStreamWriter) is intended to wrap an
 * OutputStream, thereby turning the byte based output stream into a character
 * based Writer.
 * 
 * The Java OutputStreamWriter is useful if you need to write characters to a
 * file, encoded as e.g. UTF-8 or UTF-16. You can then write the characters
 * (char values) to the OutputStreamWriter and it will encode them correctly and
 * write the encoded bytes to the underlying OutputStream.
 * 
 * 
 * InputStreamReader:
 * 
 * It's sub-class of Reader class & converts bytes to characters.
 * 
 * The Java InputStreamReader class (java.io.InputStreamReader) is intended to
 * wrap an InputStream, thereby turning the byte based input stream into a
 * character based Reader.
 * 
 * The Java InputStreamReader is often used to read characters from files (or
 * network connections) where the bytes represents text. For instance, a text
 * file where the characters are encoded as UTF-8. You could use an
 * InputStreamReader to wrap a FileInputStream in order to read such a file.
 */

public class InputOutput_E1 {

	static void writeCharacterBasedData() {
		try {
			OutputStream outputStream = new FileOutputStream(
					"output-stream.txt");
			
			Writer writer = new OutputStreamWriter(outputStream);

			// write something in the file
			try {
				writer.write(70);
				writer.write(71);
				writer.write(72);
			} catch (IOException e) {
			} finally {
				try {
					writer.flush();
					writer.close();
				} catch (IOException e) {
				}
			}

			// read what we write
			FileInputStream in = new FileInputStream("output-stream.txt");

			try {
				for (int i = 0; i < 3; i++) {
					System.out.print("" + (char) in.read());
				}
			} catch (IOException e) {
			} finally {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		} catch (FileNotFoundException e) {
		}
	}

	static void readCharacterBasedData() {

		InputStream fileInputStream = null;
		InputStreamReader inputStreamReader = null;
		try {
			fileInputStream = new FileInputStream("fileinput.txt");
			inputStreamReader = new InputStreamReader(fileInputStream);
		} catch (FileNotFoundException e) {
		}

		try {
			int count = fileInputStream.read();
			while (count != -1) {
				System.out.print((char) count);
				count = fileInputStream.read();
			}
		} catch (IOException e) {
		} finally {
			try {
				inputStreamReader.close();
				fileInputStream.close();
			} catch (IOException e) {
			}
		}
	}

	public static void main(String[] args) {

		//writeCharacterBasedData();
		System.out.println("\n");
		readCharacterBasedData();
	}
}
