package java_basics;

public class Examples {

	public static void getStudentsResult() {

		String[] students = { "Rohit", "Nilesh", "Krishna", "Jignesh", "Priyanka" };

		int[][] result = new int[5][3];

		result[0][0] = 76;
		result[0][1] = 80;
		result[0][2] = 75;

		result[1][0] = 75;
		result[1][1] = 87;
		result[1][2] = 79;

		result[2][0] = 65;
		result[2][1] = 58;
		result[2][2] = 70;

		result[3][0] = 75;
		result[3][1] = 78;
		result[3][2] = 80;

		result[4][0] = 95;
		result[4][1] = 89;
		result[4][2] = 92;

		for (int i = 0; i < result.length; i++) {
			System.out.print(students[i] + " : ");
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + "% ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		getStudentsResult();
	}
}
