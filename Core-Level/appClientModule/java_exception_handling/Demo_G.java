package java_exception_handling;

/**
 * Customized or User defined exceptions:
 *
 * -> Sometimes to meet program requirements we can define our exceptions. such
 * types of exceptions are called customized or user defined exceptions.
 * 
 * e.g. TooYoungException, TooOldException, InSufficientFundException etc.
 * 
 * -> Throw keyword is best suitable for user defined or customized exceptions
 * but not for predefined exceptions.
 * 
 * 
 * 
 * WHEN TO USE CUSTOME EXCEPTIONS ?
 * 
 * > We should create custom exception if it provides extra useful information
 * for the client code. Thus, like any other classes we can add custom methods
 * in our created exception class. e.g. When AccountLimitExceededException
 * raised, we can have a method to show the current account limit.
 * 
 * > When we want to able to programmatically handle the exception and only
 * catch the exception they care about in CATCH clause. Thus, we can distinguish
 * between different exception cases. e.g. Difference between not having
 * permission to run a report and failed to run report.
 */

public class Demo_G {

	public static void main(String[] args) {

		int age = Integer.parseInt(args[0]);
		if (age < 18) {
			throw new Demo_G_TooYoungException(
					"Please wait some more time, definitely you will get best match.");
		} else if (age > 60) {
			throw new Demo_G_TooOldException(
					"Your age is already crossed and no chance of getting married.");
		} else {
			System.out.println("You will get match details soon.");
		}
	}
}
