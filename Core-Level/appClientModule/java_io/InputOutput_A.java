package java_io;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * Java IO Hierarchy:
 * https://docs.oracle.com/javase/7/docs/api/java/io/package-tree.html
 * 
 * 
 * WHY we use Java IO ?
 * 
 * If we want to store large amount of data then we should go for Database. But,
 * If our data is not large then to store small amount of data never recommended
 * to create database.
 * 
 * For that case, we should go for File concept.
 * 
 * Java's IO package mostly concerns itself with the reading of raw data from a
 * source and writing of raw data to a destination.
 * 
 * 
 * 
 * 
 * File:
 * ----------------------------------------------------------------------------
 * The File class in the Java IO API gives you access to the underlying file
 * system. It has methods to create, delete and modify file attributes.
 * 
 * File f = new File("abc.txt");
 * 
 * This line won't create any physical file. First, It'll check is there any
 * physical file named with abc.txt is available or not. If it's available then
 * it simply pointing to that file.
 * 
 * If it's not available then we are just creating Java File object to represent
 * the name abc.txt.
 * 
 * NOTE: In UNIX everything is treated as a file. Java File IO concept is
 * implemented based on UNIX operating system. Hence, Java File object can be
 * used to represent both files and directories.
 * 
 * 
 * File class constructors:
 * 
 * File f = new File(String name);
 * 
 * Creates a Java file object to represent name of the file or directory in
 * current working directory.
 * 
 * File f = new File(String subDirectory, String name);
 * 
 * Creates a Java file object to represent name of the file or directory present
 * in specified sub-directory.
 * 
 * File f = new File(File subDirectory, String name);
 * 
 * 
 * Reference: http://javatutorialhq.com/java/io/file-class-tutorial/
 */

public class InputOutput_A {
	public static void main(String[] args) {

		File file = new File("abc.txt");
		System.out.println("If file is not already there: " + file.exists());
		try {
			file.createNewFile();
			System.out.println("Created actual file: " + file.exists());
		} catch (IOException e) {
		}

		// We can use Java File object to represent directory also.
		File f = new File("eic");
		System.out.println("If directory is not already there: " + f.exists());
		f.mkdir();
		System.out.println("Created actual directory: " + f.exists());

		File fi = new File(f, "railway.txt");
		try {
			// Create file named with railway.txt inside eic directory.
			fi.createNewFile();
		} catch (IOException e) {
		}

		File dataFile = new File("E:\\Test", "abc.txt");
		try {
			// Create file at some other location using 2nd constructor
			dataFile.createNewFile();
		} catch (IOException e) {
		}

		// Important methods of File class

		File dummyFile = new File("abc.txt");
		/**
		 * boolean exists()
		 * 
		 * returns true, if the physical file or directory present.
		 */
		System.out.println("exists(): " + dummyFile.exists());
		try {
			/**
			 * boolean createNewFile()
			 * 
			 * First this method will check whether the specified file is
			 * already available or not. If it's already available then this
			 * method return false without creating new file
			 * 
			 * If it is not already available then this method returns true
			 * after creating new file.
			 * 
			 * This method throws IOException.
			 */
			file.createNewFile();
		} catch (IOException e) {
		}

		File dummyDir = new File(f, "eic_mmc");
		/**
		 * boolean mkdir()
		 * 
		 * First this method will check whether the specified directory is
		 * already available or not. If it's already available then this method
		 * return false without creating new directory
		 * 
		 * If it is not already available then this method returns true after
		 * creating new directory.
		 * 
		 * 
		 * public boolean mkdirs()
		 * 
		 * Creates the directory named by this abstract pathname, including any
		 * necessary but nonexistent parent directories. Note that if this
		 * operation fails it may have succeeded in creating some of the
		 * necessary parent directories.
		 * 
		 * Returns: true if and only if the directory was created, along with
		 * all necessary parent directories; false otherwise
		 */
		System.out.println("mkdir(): " + dummyDir.mkdir());

		File fDir = new File("e/i/n/f/o/c/h/i/p/s");
		System.out.println("mkdirs(): " + fDir.mkdirs());
		System.out.println("getParentFile(): " + fDir.getParentFile());

		/**
		 * boolean isFile()
		 */
		System.out.println("isFile(): " + dummyFile.isFile());

		/**
		 * boolean isDirectory()
		 */
		System.out.println("isDirectory(): " + dummyFile.isDirectory());

		File[] listFiles = f.listFiles();
		for (File filePath : listFiles) {
			System.out.println("listFiles(): " + filePath.getName());
		}

		/**
		 * String[] list()
		 * 
		 * It returns the string array of all files & sub-directories present in
		 * the specified directory.
		 */
		String[] list = f.list();
		for (String name : list) {
			File file2 = new File(f, name);
			if (file2.isFile())
				System.out.println(name + " is a file");
			else
				System.out.println(name + " is a directory");
		}

		/**
		 * String[] list(FileNameFilter filter)
		 * 
		 * Returns an array of strings naming the files and directories in the
		 * directory denoted by this abstract pathname that satisfy the
		 * specified filter.
		 * 
		 * Same is available for listFiles() method.
		 */
		String[] files = f.list(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				boolean value = false;
				if (name.startsWith("railway")) {
					value = true;
				}
				return value;
			}
		});
		for (String name : files) {
			System.out.println("list the files: " + name);
		}
		/**
		 * long lastModified()
		 * 
		 * Returns the time that the file denoted by this abstract pathname was
		 * last modified.
		 */
		System.out.println("Last modified: " + file.lastModified());

		/**
		 * long length()
		 * 
		 * returns number of characters in a file.
		 */
		System.out.println("length(): " + file.length());

		// System.out.println("delete(): " + file.delete());
		/**
		 * file deleted when the virtual machine terminates.
		 */
		file.deleteOnExit();

		/**
		 * boolean renameTo()
		 * 
		 * To rename (or move) a file.
		 */
		System.out.println("renameTo(): "
				+ file.renameTo(new File("E:\\def.txt")));

	}
}
