package java_logical;

/**
 * 
 * @author ronak.nayak
 *
 */
public class LogicalC {

	public static void getFactorOfNumber(int num) {

		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println("\n");
	}

	/**
	 * first = 30; second = 12;
	 * 
	 * GCD = 6
	 */
	public static void getGCDofTwoNum(int first, int second) {

		if (first < second) {
			first = first + second;
			second = first - second;
			first = first - second;
		}

		int temp = 0;
		while (true) {
			if (first % second == 0) {
				System.out.println("GCD = " + second);
				break;
			} else {
				temp = first;
				first = second;
				second = temp % second;
			}
		}
	}

	public static void getLCMofTwoNum() {

		int a = 12, b = 80;

		int temp = a;
		while (true) {
			if (a % b == 0) {
				System.out.println("LCM = " + a);
				break;
			} else {
				a += temp;
			}
		}
	}

	public static void main(String[] args) {

		getFactorOfNumber(20);

		getGCDofTwoNum(30, 12);
		
		getLCMofTwoNum();
	}
}
