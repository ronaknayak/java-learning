package java_reg_exp;

import java.util.Scanner;

/**
 * java.util.Scanner class (For String Source):
 * 
 * The Scanner class is a class in java.util, which allows the user to read
 * values of various types. It allow us to read in numeric values from either
 * the keyboard or file without having to convert them from strings and
 * determine if there are more values to be read.
 * 
 * You can read whatever the user types using readLine() and readPassword()
 * method. You can also acquire a Reader object using reader() method on Console
 * object. All these provide character data. Similarly, you can acquire
 * PrintWriter object using writer() method on Console, which allows you to
 * write character data to the console.
 * 
 * The Java Scanner class breaks the input into tokens using a delimiter that is
 * WHITESPACE BY DEFAULT.
 * 
 * Java Scanner class is widely used to parse text for string and primitive
 * types using regular expression. Scanner is designed for cases where you need
 * to parse a string, pulling out data of different types.
 * 
 * 
 * Scanner scanner = new Scanner(String source);
 * 
 * Constructs a new Scanner that produces values scanned from the specified
 * string.
 * 
 * Scanner scanner = new Scanner(new File(fileName));
 * 
 * 
 * Note(ENTHUWARE):
 * 
 * > A delimiter is not specified at the time of construction.
 * 
 * > Also remember that it has all sorts of hasNextXXX and matching nextXXX
 * methods but there is no hasNextCharacter() or nextCharacter method.
 */

public class RegularExp_E {
	public static void main(String[] args) {

		String input = "10 tea 20 true coffee 30 tea buiscuits";

		Scanner scanner = new Scanner(input);
		/*
		 * Sets this scanner's delimiting pattern to a pattern constructed from
		 * the specified String.
		 * 
		 * We can also Sets this scanner's delimiting pattern to the specified
		 * pattern using Pattern object.
		 */
		scanner.useDelimiter("\\s");

		/*
		 * This method is simply just to get the delimiter being used by the
		 * Scanner class.
		 */
		System.out.println("Delimiter:" + scanner.delimiter());

		/*
		 * Scans the next token of the input as an int.
		 */
		System.out.println(scanner.nextInt());

		/*
		 * Finds and returns the next complete token from this scanner.
		 */
		System.out.println(scanner.next());

		/*
		 * Attempts to find the next occurrence of a pattern constructed from
		 * the specified string, ignoring delimiters. Returns string.
		 * 
		 * We can pass Pattern class object as well.
		 */
		System.out.println("findInLine(): " + scanner.findInLine("[\\d][\\d]"));

		/*
		 * This method returns a boolean data type which serves as a flag if
		 * there are still tokens to iterate over.
		 */
		while (scanner.hasNext()) {
			System.out.println("nextBoolean(): " + scanner.nextBoolean());
			break;
		}

		/*
		 * This method returns a boolean data type which corresponds to the
		 * existence of new line on the String tokens which the Scanner object
		 * holds.
		 */
		while (scanner.hasNextLine()) {
			/*
			 * It moves the scanner position to the next line and returns the
			 * value as a string.
			 */
			System.out.println(scanner.nextLine());
		}

		String iCount = "10 12";
		scanner = new Scanner(iCount);
		while (scanner.hasNextInt()) {
			System.out.println("hasNextInt(): " + scanner.nextInt());
		}

		String count = "Me 10 12";
		Scanner scan = new Scanner(count);
		while (scan.hasNext()) {
			/*
			 * The skip method returns this Scanner object with it’s token
			 * skipped that satisfies the pattern specified in the method
			 * argument.
			 */
			scan.skip("[a-zA-Z]*");
			System.out.println("After Skiping: " + scan.next("[0-9]*"));
		}
	}
}
