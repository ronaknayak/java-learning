package java_logical;

/**
 * String Techniques
 * 
 * @author ronak.nayak
 */
public class LogicalF {

	public static void lengthOfString(String input) {

		int length = 0;
		int lowerChar = 0, uperChar = 0;

		char[] strArray = input.toCharArray();
		for (char c : strArray) {

			if (c >= 65 && c <= 90) {
				uperChar++;
			} else if (c >= 97 && c <= 122) {
				lowerChar++;
			}
			length++;
		}
		System.out.println("Length = " + length);
		System.out.println("Upercase Characters = " + uperChar
				+ " & Lowercase Characters = " + lowerChar);
	}

	public static void reverseString(String input) {

		char[] strArray = input.toCharArray();

		char temp;
		for (int i = 0, j = strArray.length - 1; i < strArray.length / 2; i++, j--) {
			temp = strArray[i];
			strArray[i] = strArray[j];
			strArray[j] = temp;
		}

		System.out.println(strArray);
	}

	public static void searchString(String input, String serch) {

		int totalOccurance = 0;

		char[] strArray = input.toCharArray();
		char[] searchArray = serch.toCharArray();

		for (int iCount = 0; iCount < strArray.length; iCount++) {

			int tempCount = iCount;
			int jCount;
			for (jCount = 0; jCount < searchArray.length; jCount++, tempCount++) {

				if (strArray[tempCount] != searchArray[jCount]) {
					break;
				}
			}

			if (jCount == searchArray.length) {
				System.out.println("Found at " + iCount + "th index");
				totalOccurance++;
			}
		}
		System.out.println("Total Occurance: " + totalOccurance);

	}

	public static void duplicatesInString(String main) {

		int duplicateCount = 0;

		String[] array = main.split(" ");

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < i; j++) {

				if (array[i].equals(array[j])) {
					duplicateCount++;
				}
			}
		}
		System.out.println("Duplicate Count= " + duplicateCount);
	}

	public static void main(String[] args) {

		lengthOfString("Ronak Nayak");

		reverseString("aidnI");

		searchString("Sunday, Monday, Thursday, Saturday,  Thursday, Friday",
				"Thursday");

		duplicatesInString("India is my country and India is great country");
	}
}
