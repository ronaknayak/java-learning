package java_logical;

/**
 * Recursion Techniques
 * 
 * @author ronak.nayak
 */
public class LogicalE {

	public void sumOfNumber(int sum, int num) {

		if (num == 0) {
			System.out.println("Total=" + sum);
			return;
		}
		sum += num;
		System.out.println("Before:" + sum);
		sumOfNumber(sum, --num);
		System.out.println("After:" + sum);
	}

	public void getFactorialOfNum(int factorial, int num) {

		if (num == 1) {
			System.out.println("Factorial of Number:" + factorial);
			return;
		}
		factorial *= num;
		System.out.println("Before:" + factorial);
		getFactorialOfNum(factorial, --num);
		System.out.println("After:" + factorial);
	}
	
	public static void main(String[] args) {

		LogicalE logical = new LogicalE();

		int total = 0;
		// logical.sumOfNumber(total, 5);

		int fact = 1;
		logical.getFactorialOfNum(fact, 5);
	}
}
