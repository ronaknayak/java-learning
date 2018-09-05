package java_io;

import java.io.Console;

/**
 * Console class:
 * 
 * The Java Console class is be used to get input from console. It provides
 * methods to read text and password. If you read password using Console class,
 * it will not be displayed to the user.
 * 
 * The java.io.Console class is attached with system console internally.
 * 
 * Console has no public constructors. In fact, the only way to get a Console
 * instance is by calling the System method,
 * 
 * Console cons = System.console();
 * 
 * Correct way to retrieve the Console object is System.console(); There is only
 * one Console object so new Console(); doesn't make sense. And therefore,
 * Console's constructor is not public.
 */

public class InputOutput_H {
	public static void main(String[] args) {

		Console console = System.console();

		/**
		 * public String readLine()
		 * 
		 * used to read a single line of text from the console.
		 */
		String username = null;
		if (console != null) {
			System.out.println("Enter username:");
			username = console.readLine();
		} else {
			System.out.println("Run at command-line");
			return;
		}

		System.out.println("Enter password:");
		/**
		 * public char[] readPassword()
		 * 
		 * used to read password that is not being displayed on the console.
		 */
		char[] ch = console.readPassword();

		System.out.println("Username=" + username + "&Password="
				+ String.valueOf(ch));

		String format = "%s %s%n";

		/**
		 * public String readLine(String fmt,Object... args)
		 * 
		 * provides a formatted prompt then reads the single line of text from
		 * the console.
		 * 
		 * Raise an IllegalFormatException f a format string contains an illegal
		 * syntax, a format specifier that is incompatible with the given
		 * arguments
		 */
		String user = console.readLine(format, "Enter ", "Username:");

		char[] pass = console.readPassword(format, "Enter ", "Password:");

		System.out.println(user + ":" + String.valueOf(pass));

		/**
		 * > java.io.Reader reader()
		 * 
		 * Retrieves the unique Reader object associated with this console.
		 * 
		 * > java.io.PrintWriter writer()
		 * 
		 * Retrieves the unique PrintWriter object associated with this console.
		 * 
		 * > Console format(String fmt, Object... args)
		 * 
		 * Writes a formatted string to this console's output stream using the
		 * specified format string and arguments.
		 */
	}
}
