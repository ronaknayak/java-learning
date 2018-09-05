package java_enum;

/**
 * enum VS constructor:
 * ---------------------------------------------------------------------------
 * In enum every constant is an object. So whenever constant is created,
 * constructor is called automatically (Irrespective of number of constants we
 * are invoking all constants are loaded simultaneously).
 * 
 * In enum we can contain constructor and it is executed separately for every
 * enum constant at the time of enum class loading.
 * 
 * We can't create enum object explicitly. Therefore, We can't invoke enum
 * constructor explicitly.
 * 
 * Within the enum we can take instance and static methods but we can't take
 * abstract methods (because (1) enum is implicitly final so abstract final
 * combination is illegal. (2) we can't create child class for enum so we can't
 * provide implementation for abstract method.)
 * 
 * Every enum constant represents an object. Hence, whatever the methods we can
 * apply on normal java object we can apply those on constants also.
 */

public class Enum_D {

	public static void main(String[] args) {
		BranchIn branchIn = BranchIn.MP;
		System.out.println(branchIn);

		Bear[] bear = Bear.values();
		for (Bear bear2 : bear) {
			System.out.println(bear2 + ":" + bear2.getPrice());
		}
	}
}

enum BranchIn {
	MP, AP, KB, AG, NP;
	private BranchIn() {
		System.out.println("Constructor in enum.");
	}
}

enum Bear {
	RC(150), KO(100), KF(), FO;
	int price;

	private Bear(int price) {
		System.out.println("Bear ordered");
		this.price = price;
	}

	private Bear() {
		System.out.println("Bear ordered");
		this.price = 60;
	}

	public int getPrice() {
		return price;
	}
}