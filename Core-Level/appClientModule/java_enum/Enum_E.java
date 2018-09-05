package java_enum;

import static test.Tech.SPRING;

import test.Tech;

/**
 * Case 1:
 * 
 * Every enum constant represents an object of the type enum. Hence, whatever
 * the methods we can call on normal java objects, we can call same methods on
 * enum constants also.
 * 
 * 
 * Case 2:
 * 
 * If we want to use class name directly from outside package then required
 * import is normal import.
 * 
 * If we want to access static member directly without class name, then required
 * import is static import.(Else if we access static member using class name
 * then static import is not required for it.)
 * 
 * 
 * Case 3:
 * 
 * We can override declared method in enum for specific implementation of
 * constant.
 */

public class Enum_E {

	enum Bear {
		RC(150), KO(100), KF(120), FO;
		int price;

		Bear(int price) {
			this.price = price;
		}

		Bear() {
			this.price = 60;
		}

		public int getPrice() {
			return price;
		}
	}

	public static void main(String[] args) {

		// Case 1:
		System.out.println("equals():" + Bear.FO.equals(Bear.valueOf("FO")));
		System.out.println("== operator:" + (Bear.RC == Bear.FO));
		System.out.println("hashCode():"
				+ (Bear.RC.hashCode() == Bear.KF.hashCode()));
		System.out.println("ordinal():"
				+ (Bear.RC.ordinal() > Bear.KF.ordinal()));

		// Case 2:
		System.out.println("Normal import:" + Tech.CORE_JAVA);
		System.out.println("Static import:" + SPRING);

		// Case 3:
		Colors[] colors = Colors.values();
		for (Colors color : colors) {
			color.info(color);
		}
	}
}

enum Colors {

	RED, BLUE, BLACK {
		/**
		 * Here, BLACK is actually an instance of an anonymous subclass of
		 * Colors. This subclass is overriding info() method.
		 */
		public void info(Colors colors) {
			System.out.println("override method for specific constant..."
					+ colors);
		}
	},
	GREEN;

	public void info(Colors colors) {
		System.out.println("method for all constants.");
	}
}
