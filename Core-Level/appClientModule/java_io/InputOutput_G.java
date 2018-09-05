package java_io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Data Streams:
 * ----------------------------------------------------------------------------
 * Data streams support binary I/O of primitive data type values (boolean, char,
 * byte, short, int, long, float, and double) as well as String values. All data
 * streams implement either the DataInput interface or the DataOutput interface.
 * 
 * You wrap an InputStream in a DataInputStream and then you can read Java
 * primitives from the DataInputStream. That is why it is called DataInputStream
 * - because it reads data (numbers) instead of just bytes.
 * 
 * 
 * DataInputStream(c):
 * 
 * The DataInputStream is handy if the data you need to read consists of Java
 * primitives larger than one byte each, like int, long, float, double etc.
 * 
 * DataOutputStream(c):
 * 
 * The Java DataOutputStream class enables you to write Java primitives to
 * OutputStream's instead of only bytes. You wrap an OutputStream in a
 * DataOutputStream and then you can write primitives to it.
 * 
 * That is why it is called a DataOutputStream - because you can write int,
 * long, float and double values to the OutputStream, and not just raw bytes.
 */

public class InputOutput_G {
	public static void main(String[] args) {

		FileInputStream fileInputStream = null;
		DataInputStream dataInputStream = null;
		FileOutputStream fileOutputStream = null;
		DataOutputStream dataOutputStream = null;

		try {
			fileOutputStream = new FileOutputStream("dataInputStream.txt");
		} catch (FileNotFoundException e) {
		}

		dataOutputStream = new DataOutputStream(fileOutputStream);

		try {
			dataOutputStream.writeChar(100);
			dataOutputStream.writeInt(1);
			dataOutputStream.writeDouble(12.5);
			dataOutputStream.writeBoolean(true);
			dataOutputStream.writeUTF("Ronak");
			dataOutputStream.writeChars("Nayak");
			
			dataOutputStream.flush();
			dataOutputStream.close();
		} catch (IOException e) {
		}

		try {
			fileInputStream = new FileInputStream("dataInputStream.txt");
		} catch (FileNotFoundException e) {
		}

		dataInputStream = new DataInputStream(fileInputStream);

		try {
			while (dataInputStream.available() > 0) {
				char ch = dataInputStream.readChar();
				System.out.println(ch);
				
				int i = dataInputStream.readInt();
				System.out.println(i);

				double d = dataInputStream.readDouble();
				System.out.println(d);
				
				boolean b = dataInputStream.readBoolean();
				System.out.println(b);
				
				String str =  dataInputStream.readUTF();
				System.out.println(str);
				
				str =  dataInputStream.readUTF();
				System.out.println(str);
			}
		dataInputStream.close();
		} catch (IOException e) {
		}
		
	}
}
