package java_flow_control;

/**
 * if-else (selection statement):
 * */

public class Demo_A {
	public static void main(String[] args) {

		/**
		 * The argument to the if statement should be boolean type. By mistake
		 * if we are trying to provide any other type then we will get compile
		 * time error.
		 * */
		int a = 0;

		// CE: incompatible type
		// if(a){
		// System.out.println("hello");
		// }

		// CE: incompatible type
		// Because we are not using comparison operator but it's assignment
		// operator.
		// if(a = 10) {
		// System.out.println("hello");
		// }

		if (a == 0) {
			System.out.println("Checking boolean argument in If statement.");
		}

		boolean b = true;
		// It's valid because it's boolean type assignment.
		if (b = false) {
			System.out.println("1st case-----if");
		} else {
			System.out.println("1st case-----else");
		}

		if (b == false) {
			System.out.println("2nd case-----if");
		} else {
			System.out.println("2nd case-----else");
		}

		/**
		 * Curly braces are optional. But without curly braces we can take only
		 * statement and which should not be declarative statement.
		 * 
		 * Semicolon is a valid java statement which is also known as empty
		 * statement.
		 * */
		;

		if (true)
			if (true)
				System.out.println("It's valid");

		// compile time error
		// if(true)
		// int x=5;
		
		if (true) {
			int y = 20;
			System.out.println("With curly braces declarative statement:" + y);
		}

		/** Every else is mapped to the nearest if statement. */
		boolean check = true;

		if (check)
			if (check = false)
				System.out.println("Well done");
			else
				System.out.println("Welcome");
	}
}
