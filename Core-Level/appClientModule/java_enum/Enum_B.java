package java_enum;

/**
 * enum VS switch :
 * 
 * Until 1.4 version the only allowed data types for switch arguments are byte,
 * short, int and char.
 * 
 * But, from 1.5 version onwards in addition to the above Byte, Short, Integer
 * and Character Wrapper classes + enum type also allowed.
 * 
 * From 1.7 version onwards String type also allowed.
 * 
 * 
 * enum VS inheritance:
 * 
 * Every enum in java is direct child class of java.lang.Enum (which is direct
 * child class of Object class & implements SERIALIZABLE and COMPARABLE
 * interface).
 * 
 * As every enum is internally extending java.lang.Enum there is no chance of
 * extending any other enum (because java won't provide support for multiple
 * inheritance).
 * 
 * As every enum is always final implicitly we can't create child enum for our
 * enum.
 * 
 * because of above reason we can conclude that INHERITANCE CONCEPT IS NOT
 * APPLICABLE FOR ENUM.
 * 
 * But enum can implement any number of interfaces at a time.
 */

public class Enum_B {

	public static void main(String[] args) {

		/**
		 * If we are passing enum type as argument to the switch statement every
		 * case label should be a valid enum constant or else we'll get CE.
		 * 
		 * When we use enum constant as case label then it should not fully
		 * qualified name. e.g. BranchAhm.NP
		 */
		BranchAhm branch = BranchAhm.AP;

		switch (branch) {
		case NP:
			System.out.println("National plaza");
			break;

		case AP:
			System.out.println("Aryan park");
			break;

		case MP:
			System.out.println("Maradia plaza");
			break;

		default:
			System.out.println("Karmbhumi");
			break;
		}

		/**
		 * values(): return an array of enum constants.
		 * 
		 * name(): returns the name of this enum constant, exactly as declared
		 * in its enum declaration.
		 * 
		 * ordinal(): To find place of constant & starting with 0.
		 */
		BranchAhm[] branchs = BranchAhm.values();
		for (BranchAhm branchName : branchs) {
			System.out.println("values():" + branchName.name() + " "
					+ branchName.ordinal());
		}
	}
}

enum BranchAhm {
	MP, AP, KB, AG, NP
}
