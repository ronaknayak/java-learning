package java_logical;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author ronak.nayak
 *
 */
public class LogicalA {

	static void doInterChangeTwoNum(int num1, int num2) {

		System.out.println("Before: num1 = " + num1 + " & num2 = " + num2);

		num1 = num1 + num2;
		num2 = num1 - num2;
		num1 = num1 - num2;

		System.out.println("After: num1 = " + num1 + " & num2 = " + num2);
	}

	static void doReverseNum(int inputNum) {

		int remainder = 0;
		int outputNum = 0;
		int temp = inputNum;

		while (inputNum > 0) {
			remainder = inputNum % 10;
			outputNum = remainder + (outputNum * 10);
			inputNum = inputNum / 10;
		}

		if (outputNum == temp)
			System.out.println("It's palindrom number.");
		else
			System.out.println("It's not a palindrom number.");
	}

	static boolean isArmstrongNum(int num) {

		int remainder = 0;
		int outputNum = 0;
		int temp = num;

		while (num > 0) {
			remainder = num % 10;
			outputNum = outputNum + (remainder * remainder * remainder);
			num = num / 10;
		}

		if (outputNum == temp)
			return true;
		else
			return false;
	}

	static boolean isPrimeNumber(int num) {

		boolean isPrimeNumber = true;
		for (int iCount = 0; iCount < num; iCount++) {

			if (iCount == 0 || iCount == 1)
				continue;

			if (num % iCount == 0) {
				isPrimeNumber = false;
				break;
			}
		}
		return isPrimeNumber;
	}

	static List<Integer> getAllPrimeNums(int range) {

		int iCount, jCount;
		boolean isPrimeNumber;
		List<Integer> primeNums = new ArrayList<Integer>();

		for (iCount = 1; iCount <= range; iCount++) {
			isPrimeNumber = true;
			for (jCount = 0; jCount < iCount; jCount++) {

				if (jCount == 0 || jCount == 1)
					continue;

				if (iCount % jCount == 0) {
					isPrimeNumber = false;
					break;
				}
			}
			if (isPrimeNumber) {
				primeNums.add(iCount);
			}
		}

		return primeNums;
	}

	static int getFactorialofNum(int num) {
		int sum = 1;
		while (num > 1) {
			sum *= num;
			num--;
		}
		return sum;
	}

	static List<Integer> listFibonacciSeries(int num) {

		List<Integer> list = new ArrayList<Integer>();

		int first = 0;
		int second = 1;
		int third = 0;

		list.add(second);
		for (int iCount = 1; iCount < num; iCount++) {
			third = first + second;
			list.add(third);
			first = second;
			second = third;
		}
		return list;
	}

	public static void main(String[] args) {

		doInterChangeTwoNum(10, 20);

		doReverseNum(272);

		System.out.println(isArmstrongNum(153));

		System.out.println(isPrimeNumber(11));

		System.out.println(getAllPrimeNums(17));

		System.out.println(getFactorialofNum(5));

		System.out.println(listFibonacciSeries(10));
	}

}
