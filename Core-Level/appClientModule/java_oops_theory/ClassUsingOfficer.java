package java_oops_theory;

public class ClassUsingOfficer {
	
	public static void main(String[] args) {
		
		EncapsulatedClassOfficer encapsulatedClassOfficer = new EncapsulatedClassOfficer();
		encapsulatedClassOfficer.setSalary(-6);
		System.out.println("First officer salary "+encapsulatedClassOfficer.getSalary());
		
		EncapsulatedClassOfficer officer2 = new EncapsulatedClassOfficer();
		officer2.setSalary(60000);
		System.out.println("Second officer salary "+officer2.getSalary());
	}
}
