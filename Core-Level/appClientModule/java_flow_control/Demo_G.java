package java_flow_control;

/** break (transfer statement):
 * 
 * -> We can use break keyword in following cases:
 * 
 * 1) Inside switch to stop fall through.
 * 
 * 2) Inside loop to stop loop execution based on some condition.
 * 
 * -> If we use break any where else then we'll get compile time error.
 * 
 * 
 * continue (transfer statement):
 * 
 * -> We can use continue statement to skip current iteration and continue for next iteration.
 * 
 * -> If we are using continue outside of loops then we'll get compile time error.
 * */

public class Demo_G {
	public static void main(String[] args) {
		
		int[] a = {10, 20, 30,40, 50};
		for (int i = 0; i < a.length; i++) {
			if(a[i] == 40) {
				break;
			}
			System.out.print(a[i]+" ");
		}
		System.out.println();
		
		for (int i = 0; i < a.length; i++) {
			if(a[i] == 20 || a[i] == 40) {
				continue;
			}
			System.out.print(a[i]+" ");
		} 
	}
}
