package java8;

/**
* 
* @author ronak.nayak
* 
* 
* Static methods inside interface:
* ****************************************************************************
* 
* From 1.8 version onwards in addition to default methods we can write static 
* methods also inside interface to define general utility methods.
* 
* Interface static methods by-default not available to the implementation classes 
* hence by using implementation class reference we can’t call interface static 
* methods. We should call interface static methods by using interface name.
* 
* 
* From 1.8 version onwards we can write main() method inside interface and 
* 	hence we can run interface directly from the command prompt.
*/ 
public class Section_H implements InterfStatic {

	public static void main(String[] args) {

		InterfStatic.sum(10, 20);
	}
}

interface InterfStatic {
	public static void sum(int a, int b) {
		System.out.println("The Sum:" + (a + b));
	}
}