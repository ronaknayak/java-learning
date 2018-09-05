package java_logical;

public class Practice {

	public static void main(String[] args) {
		
		int[] arr = { 7, 5, 12, 54, 8, 34, -4, 98, 32,29};
		int max = arr[0];
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		System.out.println(max);
		int secMax = 0;
		for (int i = 0; i < arr.length; i++) {
			
			if(arr[i] > secMax && arr[i] < max) {
				secMax = arr[i];
			}
		}
		System.out.println(secMax);
		
	}
}
