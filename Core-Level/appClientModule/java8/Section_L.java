package java8;

/**
 * 
 * @author ronak.nayak
 * 
 * 
 * Method and Constructor references by using ::(double colon) operator:
 * ****************************************************************************
 * 
 * Method References:
 * 
 * Functional Interface method can be mapped to our specified method by using 
 * :: (double colon) operator. This is called METHOD REFERENCE.
 * Our specified method can be either static method or instance method.
 * 
 * Functional Interface method and our specified method should have same argument 
 * types, except this the remaining things like return type, method name, modifiers 
 * etc are not required to match.
 * 
 * If our specified method is static method use ClassName::methodName
 * 
 * If the method is instance use methodObjRef::methodName
 * 
 * 
 * Advantage:
 * 
 * The main advantage of method reference is we can use already existing code to 
 * implement functional interfaces (CODE REUSABILITY).
 * 
 * 
 * Conclusion:
 * 
 * Functional Interface can refer lambda expression and Functional Interface can 
 * also refer method reference. Hence lambda expression can be replaced with method 
 * reference. Hence method reference is alternative syntax to lambda expression.
 * 
 * 
 * 
 * Constructor References:
 * 
 * We can use :: ( double colon )operator to refer constructors as well.
 * 
 * Syntax: className :: new
 * 
 * 
 * @Note: 
 * In method and constructor references compulsory the argument types must be matched.
 */
public class Section_L {
	
	public void save(double amount) {
		System.out.println("save() method invoked: "+amount);
	}
	
	public static void main(String[] args) {
		
		Program program = amount -> System.out.println("saveTransaction() impl invoked: "+amount);
		program.saveTransaction(1000);

		/**
		 * In the above example functional interface method saveTransaction() referring
		 * to class instance method save().
		 */
		Section_L section = new Section_L();
		Program prog = section::save;
		prog.saveTransaction(2000);
		
		/**
		 * Constructor References:
		 */
		InterSample interSample = Sample::new;
		interSample.get();		
	}
}

interface Program { 
	public void saveTransaction(double invoiceAmount); 
}

class Sample {
	public Sample() {
		System.out.println("Sample consructor executed");
	}
}

interface InterSample {
	public Sample get();
}