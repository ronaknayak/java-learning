package java_io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Readers and writers meant for handling character data (any primitive data
 * type) i.e. to store text data.
 * 
 * To handle binary data like images, movie files, jar files we should go for
 * streams.
 * 
 * Streams:
 * ---------------------------------------------------------------------------
 * Java uses the concept of stream to make I/O operation fast.IO Streams are a
 * core concept in Java IO.
 * 
 * A stream is a sequence of data.In Java a stream is composed of bytes. You can
 * either read from a stream or write to a stream. A stream is connected to a
 * data source or a data destination.
 * 
 * Streams in Java IO can be either byte based (reading and writing bytes) or
 * character based (reading and writing characters).
 * 
 * 
 * Java application uses an input stream to read data from a source, it may be a
 * file,an array,peripheral device or socket. Java application uses an output
 * stream to write data to a destination, it may be a file,an array,peripheral
 * device or socket.
 * 
 * OutputStream class is an abstract class.It is the superclass of all classes
 * representing an output stream of bytes.
 * 
 * Methods:
 * 
 * public void write(int i) throws IOException - Used to write a byte to the
 * current output stream.
 * 
 * public void write(byte[] i) throws IOException - Used to write an array of
 * byte to the current output stream.
 * 
 * public void flush() throws IOException - flushes the current output stream.
 * 
 * public void close() throws IOException - close the current output stream.
 * 
 * 
 * InputStream class is an abstract class.It is the superclass of all classes
 * representing an input stream of bytes.
 * 
 * Methods:
 * 
 * public abstract int read()throws IOException - reads the next byte of data
 * from the input stream.It returns -1 at the end of file.
 * 
 * public int available()throws IOException - returns an estimate of the number
 * of bytes that can be read from the current input stream.
 * 
 * public void close()throws IOException - close the current output stream.
 */

public class InputOutput_F {

	static void writeData() {
		try {
			FileOutputStream outputStream = new FileOutputStream(
					"fileinput.txt");

			String str = "MS Dhoni is my favourite player";
			byte[] arr = str.getBytes();
			for (byte bCount : arr) {
				System.out.print(bCount + " ");
			}
			System.out.println("\n");

			outputStream.write(arr);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void readData() {
		try {
			FileInputStream inputStream = new FileInputStream("fileinput.txt");

			int count = inputStream.read();
			while (count != -1) {
				System.out.print((char) count);
				count = inputStream.read();
			}
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		writeData();
		readData();
	}
}
