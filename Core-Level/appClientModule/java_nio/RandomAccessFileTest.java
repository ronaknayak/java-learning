package java_nio;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile class:
 * 
 * RandomAccessFile implements DataInput as well as DataOutput interfaces.
 * 
 * RandomAccessFile is a special kind of file in Java which allows
 * non-sequential or random access to any location in file. This means you don't
 * need to start from 1st line if you want to read line number 10, you can
 * directly go to line 10 and read.
 * 
 * The RandomAccessFile class treats the file as an array of Bytes. And you can
 * write your data in any position of the Array. To do that, IT USES A POINTER
 * THAT HOLDS THE CURRENT POSITION.
 * 
 * When you write data which exceeds current size of file caused random access
 * file to be extended. For reading data from random access, you can either open
 * the file into read only mode(r) or read write mode(rw).
 * 
 * By the way, if end of file is reached before your program read desired number
 * of bytes, an EOFException will be thrown.
 * 
 * 
 * RandomAccessFile does not extend from InputStream or OutputStream. But it
 * does implement java.io.DataOutput and java.io.DataInput interfaces
 * 
 * 
 * The mode argument specifies the access mode in which the file is to be
 * opened. The permitted values and their meanings are:
 * 
 * "r": Open for reading only. Invoking any of the write methods of the
 * resulting object will cause an IOException to be thrown.
 * 
 * "rw": Open for reading and writing. If the file does not already exist then
 * an attempt will be made to create it.
 * 
 * "rws": Open for reading and writing, as with "rw", and also require that
 * every update to the file's CONTENT OR METADATA be written synchronously to
 * the underlying storage device.
 * 
 * "rwd": Open for reading and writing, as with "rw", and also require that
 * every update to the file's CONTENT be written synchronously to the underlying
 * storage device.
 */

public class RandomAccessFileTest {
	public static void main(String[] args) {

		String data = "KitKat (4.4 - 4.4.21)";
		writeToRandomAccessFile("store.txt", 100, data);
		System.out.println("success...");
	}

	public static void writeToRandomAccessFile(String file, int position,
			String record) {

		try {
			/**
			 * In order to write data into random access file, you first need to
			 * create an instance of RandomAccessFile class in read and write
			 * mode. You can do this by passing "rw" as mode to the constructor.
			 */
			RandomAccessFile fileStore = new RandomAccessFile(file, "rws");
			// moves file pointer to position specified
			fileStore.seek(position);

			/**
			 * The current position of the file pointer can be obtained by
			 * calling the getFilePointer() method.
			 */
			long pointer = fileStore.getFilePointer();
			System.out.println("Current position:" + pointer);

			// writing String to RandomAccessFile
			fileStore.writeUTF(record);

			fileStore.close();

			readFromRandomAccessFile(file, position);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String readFromRandomAccessFile(String file, int position) {

		String record = null;
		try {
			RandomAccessFile fileStore = new RandomAccessFile(file, "rw");

			// moves file pointer to position specified
			fileStore.seek(position);

			// reading String from RandomAccessFile
			record = fileStore.readUTF();
			System.out.println(record);

			fileStore.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return record;
	}

}
