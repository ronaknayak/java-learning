package java_logical;

/**
 * Sorting-Searching Techniques
 * 
 * @author ronak.nayak
 */
public class LogicalD {

	public static void sortBySelectionSort(int[] nums) {

		int temp = 0;
		int len = 0;
		int loopingCount = 0;

		if (nums != null) {
			len = nums.length;
		} else {
			System.out.println("Array length is null");
			return;
		}

		System.out.println("Before Sorting:");
		iterateAndPrintArray(nums);

		for (int iCount = 0; iCount < len - 1; iCount++) {
			loopingCount++;
			for (int jCount = iCount + 1; jCount < len; jCount++) {
				loopingCount++;
				if (nums[iCount] > nums[jCount]) {
					temp = nums[iCount];
					nums[iCount] = nums[jCount];
					nums[jCount] = temp;
				}
			}
		}

		System.out.println("Total iteration=" + loopingCount);

		System.out.println("After Sorting:");
		iterateAndPrintArray(nums);
	}

	public static void sortByBubbleSort(int[] nums) {

		int temp = 0;
		int len = 0;
		int loopingCount = 0;
		boolean isIterationRequired;

		if (nums != null) {
			len = nums.length;
		} else {
			System.out.println("Array length is null");
			return;
		}

		System.out.println("Before Sorting:");
		iterateAndPrintArray(nums);

		for (int iCount = 1; iCount < len; iCount++) {
			loopingCount++;
			isIterationRequired = false;

			for (int jCount = 0; jCount < len - iCount; jCount++) {
				loopingCount++;
				if (nums[jCount] > nums[jCount + 1]) {
					temp = nums[jCount];
					nums[jCount] = nums[jCount + 1];
					nums[jCount + 1] = temp;
					isIterationRequired = true;
				}
			}
			if (!isIterationRequired) {
				// No need to iterate further
				break;
			}
		}

		System.out.println("Total iteration=" + loopingCount);

		System.out.println("After Sorting:");
		iterateAndPrintArray(nums);
	}

	static void sortByQuickSort(int list[], int first, int last) {
		int smallIndex, bigIndex, pivot, temp;

		if (first < last) {
			pivot = first;
			smallIndex = first;
			bigIndex = last;

			while (smallIndex < bigIndex) {
				while (list[smallIndex] <= list[pivot]) {
					smallIndex++;
				}
				while (list[bigIndex] > list[pivot]) {
					bigIndex--;
				}

				if (smallIndex < bigIndex) {
					temp = list[smallIndex];
					list[smallIndex] = list[bigIndex];
					list[bigIndex] = temp;
				}
			}

			temp = list[pivot];
			list[pivot] = list[bigIndex];
			list[bigIndex] = temp;

			iterateAndPrintArray(list);
			sortByQuickSort(list, first, bigIndex - 1);
			sortByQuickSort(list, bigIndex + 1, last);
		}
	}

	public static void main(String[] args) {

		// sortBySelectionSort(new int[] { 7, 5, 62, 54, 18 });

		// sortByBubbleSort(new int[] { 7, 5, 62, 54, 18 });

		int[] mainArr = new int[] { 40, 20, 10, 80, 60, 50, 7, 30, 100 };

		sortByQuickSort(mainArr, 0, mainArr.length - 1);
		System.out.println("After Sorting");
		for (int iCount = 0; iCount < mainArr.length; iCount++) {
			System.out.print(mainArr[iCount] + " ");
		}
	}

	private static void iterateAndPrintArray(int[] array) {

		for (int num : array) {
			System.out.print(num + " ");
		}
		System.out.print("\n");
	}
}
