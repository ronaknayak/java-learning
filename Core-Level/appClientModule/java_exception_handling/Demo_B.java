package java_exception_handling;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/** Exception hierarchy:
 * 
 * -> Throwable act as root for java exception hierarchy. Throwable class defines two child classes.
 * 
 * 1) Exception:
 * 
 * -> Most of the times exceptions are caused by our program and these are RECOVERABLE.
 * e.g. FileNotFoundException, SQLException etc.
 * 
 * 2) Error:
 * 
 * -> Most of the time errors are not caused by our program. These are due to lack of system resources.
 *  errors are NON-RECOVERABLE.
 *  
 *  e.g.OutOfmemoryError, StackOverflowError etc.
 *  
 *  
 *  Checked v/s Unchecked exceptions:
 *  
 *  ->  The exceptions which are checked by compiler for smooth execution of the program are called
 *  checked exceptions. Compiler telling us there may be chance of raising such a exception.
 *  e.g. HallTicketMissingException, DieselFinishedException, FileNotFoundException etc.
 *  
 *  -> In our program if there is a chance of raising checked exception then compulsory we should handle
 *  that checked exception either by try-catch or by throws keyword. otherwise we'll get compile time error.
 *   
 * -> The exceptions which are not checked by compiler whether programmer handling or not, such type of
 * exceptions are called unchecked exceptions. Because this kind of exceptions occurs rarely.
 * e.g. ArithmaticException, BombBlastException etc.
 * 
 * -> Whether it is checked or unchecked every exception occurs at RUNTIME only. There is no chance of occurring 
 * any exception at compile time.
 *
 * NOTE:
 *
 * RuntimeException and it's child classes, Error and it's child classes are unchecked exceptions and except this
 * remaining are checked exceptions.
 * 
 * 
 * Partially checked v/s fully checked:
 * 
 * -> A checked exception is said to be fully checked if and only if all it's child classes also checked.
 * e.g. IOException, InterruptedException
 * 
 * -> A checked exception is said to be partially checked if and only if some of it's child classes are unchecked.
 * e.g. Exception and Throwable
 * 
 * Note:
 * -> In Java, the only possible partially checked exceptions are Exception and Throwable. 
 * */

public class Demo_B {

	public static void main(String[] args) throws FileNotFoundException {
		
		//CE: unreported exception java.io.FileNotFoundException; must be caught or declared to be thrown 
		PrintWriter writer = new PrintWriter("abc.txt");
		writer.print("Ronak Nayak");
		writer.close();
		
		String name = null;
		if(name.isEmpty()) {
			System.out.println("name is empty ");
		}
	}
}
