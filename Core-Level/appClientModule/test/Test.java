package test;


public class Test {

	public Test() {
	System.out.println("Test.Test()");	// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		
		/*int[] a=new int[2];j
		a[0]=1;
		a[1]=2;
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}*/
		
		/*int[] a={1,2,3,4};
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}*/
		
		/*int[][] a=new int[3][];
		
		a[0]= new int[2];
		a[1]= new int[2];
		a[2]= new int[4];
		
		a[0][0]=1;
		a[0][1]=2;
		
		a[1][0]=3;
		
		a[2][0]=4;
		a[2][1]=5;
		a[2][2]=6;
		a[2][3]=7;
		
		for (int i = 0; i < a.length; i++) {
			
			for (int j = 0; j < a[i].length; j++) {
				System.out.println(a[i][j]);
			}
		}*/
		
		
		/*int[][][] a = new int[2][3][];
		
		a[0][0]= new int[2];
		a[0][1]= new int[3];
		a[0][2]= new int[4];
		a[1][0]= new int[2];
		a[1][1]= new int[0];
		a[1][2]= new int[0];
		
		a[0][0][0]=1001;
		a[0][0][1]=2001;
		
		a[0][1][0]=3001;
		a[0][1][1]=4001;
		
		a[0][2][0]=5001;
		a[0][2][1]=6001;
		
		a[1][0][0]=7001;
		
		for (int i = 0; i < a.length; i++) {
			
			for (int j = 0; j < a[i].length; j++) {
				
				for (int j2 = 0; j2 < a[i][j].length; j2++) {
					System.out.println(a[i][j][j2]);
				}
			}
		}*/
		
		int[][][] a = {{ {10,20,30},{40,50}}};
		
		for (int i = 0; i < a.length; i++) {
			
			for (int j = 0; j < a[i].length; j++) {
		
				for (int j2 = 0; j2 < a[i][j].length; j2++) {
					System.out.println(a[i][j][j2]);
				}
			}
		}
	}

}
