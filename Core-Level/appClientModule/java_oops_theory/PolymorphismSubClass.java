package java_oops_theory;

public class PolymorphismSubClass extends Polymorphism_Dynamic {

	public void disp() {
		System.out.println("disp() method of Child class");
	}

	public void xyz() {
		System.out.println("xyz() method of Child class");
	}
	
	public static void main(String[] args) {
		
		//Parent class reference to child class object
		Polymorphism_Dynamic dynamic = new PolymorphismSubClass();
		dynamic.disp();
		dynamic.abc();
	}
}
