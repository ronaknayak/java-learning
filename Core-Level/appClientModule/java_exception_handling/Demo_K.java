package java_exception_handling;

import java.util.Scanner;

/**
 * Assertions:
 * 
 * References: e-Book
 * http://javarevisited.blogspot.in/2012/01/what-is-assertion-in-java-java.html
 */

public class Demo_K {

	public static void main(String[] args) {

		int month = 12;
		assert month > 0 && month <= 12;
		// or
		// assert(month > 0 && month <= 12);
		System.out.println("current month:" + month);

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your age:");

		int age = scanner.nextInt();
		assert age >= 18 : validateMessages("age");
		// or
		// assert(age >= 18) : validateMessages("age");
		System.out.println("Age:" + age);

		scanner.close();
	}

	static String validateMessages(String input) {

		String message = null;
		switch (input) {
		case "age":
			message = "User age is not valid";
			break;
		default:
			message = "Invalid input";
		}
		return message;
	}
}
