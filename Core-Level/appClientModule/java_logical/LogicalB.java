package java_logical;

/**
 * 
 * @author ronak.nayak
 *
 */
public class LogicalB {

	static int sumOfArray(int[] arr) {

		int sum = 0;
		for (int iCount = 0; iCount < arr.length; iCount++) {
			sum += arr[iCount];
		}
		return sum;
	}

	static void doReverseArray(int[] arr) {

		int temp = 0;
		for (int iCount = 0, jCount = arr.length - 1; iCount < arr.length / 2; iCount++, jCount--) {
			temp = arr[iCount];
			arr[iCount] = arr[jCount];
			arr[jCount] = temp;
		}

		for (int iCount = 0; iCount < arr.length; iCount++) {
			if (iCount == arr.length - 1)
				System.out.print(arr[iCount] + "\n");
			else
				System.out.print(arr[iCount] + " ");
		}
	}

	static int getMaxInArray(int[] arr) {

		int max = arr[0];
		for (int iCounter = 0; iCounter < arr.length; iCounter++) {
			if (arr[iCounter] > max)
				max = arr[iCounter];
		}

		return max;
	}

	static int getSecondMaxInArray(int[] arr) {

		int max = 0;
		int secMax = 0;
		for (int iCounter = 0; iCounter < arr.length; iCounter++) {
			if (arr[iCounter] > max) {
				max = arr[iCounter];
			}

			if (arr[iCounter] < max && arr[iCounter] > secMax) {
				secMax = arr[iCounter];
			}
		}

		return secMax;
	}

	public static void deleteArrayElement(int[] array, int element) {

		for (int i = 0; i < array.length; i++) {

			if (array[i] == element) {
				int j;
				for (j = i; j < array.length - 1;) {
					array[j] = array[++j];
				}
				array[j] = 0;
				break;
			}
		}

		for (int ele : array) {
			System.out.print(ele + "\t");
		}
		System.out.print("\n");
	}

	public static void deleteDuplicateElements(int[] array) {

		boolean isDuplicate;
		int length = 0;
		int[] ultimateArr = new int[array.length];

		for (int i = 0; i < array.length; i++) {

			isDuplicate = false;
			for (int j = 0; j < i; j++) {
				if (array[i] == array[j]) {
					isDuplicate = true;
					break;
				}
			}
			if (!isDuplicate) {
				ultimateArr[length++] = array[i];
			}
		}

		for (int element : ultimateArr) {
			System.out.print(element + "\t");
		}
		System.out.println("\n");
	}

	public static void getRepeatedNumWithFrequency(int[] array) {

		int max = 0;

		int temp = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (array[j] > array[i]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}

		int count = 0;
		for (int iCount = 0; iCount < array.length;) {
			count = 1;
			for (int jCount = iCount + 1; jCount < array.length; jCount++) {
				if (array[iCount] == array[jCount]) {
					count++;
				}
			}

			if (count > 1 && array[iCount] > max) {
				max = array[iCount];
				System.out.println(array[iCount] + " is repeated " + count
						+ " times");
			}
			iCount += count;
		}

		System.out.println("Max repested is " + max);
	}

	public static void getRepeatedNumWithFrequencyNO_SORTING(int[] list) {

		int count;
		boolean isRepeated;

		for (int iCount = 0; iCount < list.length; iCount++) {
			count = 0;
			for (int jCount = iCount + 1; jCount < list.length; jCount++) {

				isRepeated = false;
				for (int kCount = 0; kCount < iCount; kCount++) {

					if (list[iCount] == list[kCount]) {
						isRepeated = true;
						break;
					}
				}

				if (isRepeated) {
					break;
				}

				if (list[iCount] == list[jCount]) {
					count++;
				}
			}
			if (count > 0) {
				System.out.println(list[iCount] + " is repeated " + (++count)
						+ " times.");
			}
		}
	}

	public static void doSuppressZeroToEnd(int[] list) {

		System.out.println("Before");
		for (int element : list) {
			System.out.print(element + " ");
		}
		System.out.println("\n");

		for (int i = 0; i < list.length; i++) {
			if (list[i] == 0) {
				for (int j = i; j < list.length - 1; j++) {
					list[j] = list[j + 1];
				}
				list[list.length - 1] = 0;
			}
		}

		System.out.println("After");
		for (int element : list) {
			System.out.print(element + " ");
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {

		System.out.println(sumOfArray(new int[] { 1, 10, 21, 30 }));

		doReverseArray(new int[] { 1, 2, 3, 4 });

		System.out.println(getMaxInArray(new int[] { 21, 5, 12, 54, 8 }));

		System.out.println("Second max num: "
				+ getSecondMaxInArray(new int[] { 7, 5, 12, 54, 8, 28 }));

		deleteArrayElement(new int[] { 7, 5, 62, 54, 18 }, 62);

		deleteDuplicateElements(new int[] { 2, 12, 2, 15, 6, 6, 50 });

		getRepeatedNumWithFrequency(new int[] { 12, 18, 12, 23, 15, 78, 23, 23,
				45 });

		getRepeatedNumWithFrequencyNO_SORTING(new int[] { 23, 18, 32, 23, 15,
				78, 32, 23, 45, 10 });

		doSuppressZeroToEnd(new int[] { 12, 5, 0, 32, 0, 23 });
	}
}
