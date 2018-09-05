package java_logical;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Evaluation {

	public void unionAndIntersection() {

		Set<Integer> A = new HashSet<Integer>();
		A.addAll(Arrays.asList(2, 4, 6, 8, 10));

		Set<Integer> B = new HashSet<Integer>();
		B.addAll(Arrays.asList(1, 2, 3, 4, 5));

		System.out.println("A: " + A);
		System.out.println("B: " + B);

		/*
		 * Union: Set of members that belong to set A "or" set B.
		 */
		Set<Integer> union = new HashSet<Integer>();
		union.addAll(A);
		union.addAll(B);
		System.out.println(union);

		/*
		 * Intersection: Set of members that belong to set A "and" set B.
		 */
		Set<Integer> intersection = new HashSet<Integer>();
		intersection.addAll(A);
		intersection.retainAll(B);
		System.out.println(intersection);

		/*
		 * Difference: Set of members that belong set A "and not" set B.
		 */
		Set<Integer> difference = new HashSet<Integer>();
		difference.addAll(A);
		difference.removeAll(B);
		System.out.println(difference);

		Set<Integer> C = new HashSet<Integer>();
		C.addAll(Arrays.asList(2, 4, 6, 8, 10));

		Set<Integer> D = new HashSet<Integer>();
		D.addAll(Arrays.asList(8, 2, 10));

		/*
		 * Subset: Whether members of D subset of members of C.
		 */
		boolean isSubset = C.containsAll(D);
		System.out.println(isSubset);

	}

	// Restriction: To use only one loop.
	public void getCountOfUniqueWords() {

		String input = "India is my country and India is great country";
		String[] array = input.split(" ");

		Set<String> uniqueElements = new HashSet<>();
		Set<String> duplicates = new HashSet<>();

		for (int i = 0; i < array.length; i++) {
			if (!uniqueElements.add(array[i])) {
				duplicates.add(array[i]);
			}
		}
		uniqueElements.removeAll(duplicates);
		System.out.println("Total = " + uniqueElements.size());
	}

	public void printMatrixInSpiralPattern() {

		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");

		int i, j = 0, num;
		int len = arr.length;
		for (i = len - 1; i > 0; i--, j++) {

			for (num = j; num < i; num++) {
				System.out.print(arr[j][num] + " ");
			}

			for (num = j; num < i; num++) {
				System.out.print(arr[num][i] + " ");
			}

			for (num = i; num > j; num--) {
				System.out.print(arr[i][num] + " ");
			}

			for (num = i; num > j; num--) {
				System.out.print(arr[num][j] + " ");
			}
		}

		int x = (len - 1) / 2;
		if (len % 2 == 1) {
			System.out.print(arr[x][x]);
		}
	}

	public static void main(String[] args) {

		Evaluation evaluation = new Evaluation();

		evaluation.unionAndIntersection();

		// evaluation.getCountOfUniqueWords();

		// evaluation.printMatrixInSpiralPattern();
	}
}
