package java_oops;

/**
 * Factory Method Design Pattern:
 * 
 * Objective:
 * 
 * > It reduces compile time dependency on actual implementation classes.
 * 
 * Since the client does not contain references to the implementation class
 * names, it is not tied down to a particular implementation. This allows the
 * client to use another implementation even at run time.
 * 
 * It PREVENTS TIGHT COUPLING between the client and the class implementation.
 * Since the client does not contain any reference to the actual implementation
 * class name, it is loosely coupled to the implementation class.
 * 
 * > It prevents exposure of instantiation logic of a class to other classes.
 * 
 * Clients use the factory to get objects of the class. The instantiation
 * details such as what arguments to pass are isolated to the factory.
 * 
 * 
 * When to use:
 * 
 * When a class doesn't know what sub-classes will be required to create.
 * 
 * When a class wants that its sub-classes specify the objects to be created.
 * 
 * 
 * 
 * Note(ENTHUWARE):
 * 
 * > It instantiates a concrete class and returns a handle that is typed to an
 * interface (or a base class). Thus, it shields the caller from worrying about
 * which implementation class to instantiate and how to instantiate it.
 * 
 * Essentially, the factory pattern allows creation of objects without exposing
 * the instantiation logic to the caller. The return type of the factory method
 * is usually an interface but it may also be a base class.
 * 
 * > DriverManager.getConnection() is a good example of the Factory pattern.
 * This method internally uses the driver that supports the DB URL, uses that
 * driver to create a Connection and then returns that Connection. Note that
 * Connection is just an interface. The actual class of the object that
 * implements Connection is provided by the driver provider. However, the
 * calling code has no idea about the actual implementation class.
 * 
 * > Since the return type of the factory method is an interface, the clients
 * can only utilize the methods exposed by that interface. This prevents them
 * from relying on the methods of specific to the implementation class. So, this
 * patterns rely on the principle "PROGRAM TO AN INTERFACE".
 */

public class Demo_M {
	public static void main(String[] args) {

		PlanVO planVO = new PlanVO("domesticplan", 1000);

		PlanFactory factory = new PlanFactory();
		Plan plan = factory.getPlan(planVO);

		System.out.print("Bill amount for " + planVO.getPlanType() + " of  "
				+ planVO.getUnits() + " units is: ");
		plan.getRate();
		plan.calculateBill(planVO.getUnits());
	}
}

abstract class Plan {
	protected double rate;

	abstract void getRate();

	public void calculateBill(int units) {
		System.out.println(units * rate);
	}
}

class DomesticPlan extends Plan {
	@Override
	public void getRate() {
		rate = 3.50;
	}
}

class CommercialPlan extends Plan {
	@Override
	public void getRate() {
		rate = 7.50;
	}
}

class InstitutionalPlan extends Plan {
	@Override
	public void getRate() {
		rate = 5.50;
	}
}

class PlanFactory {

	// use getPlan method to get object of type Plan
	public Plan getPlan(PlanVO planVO) {
		if (planVO == null) {
			return null;
		}

		String planType = planVO.getPlanType();
		if (planType.equalsIgnoreCase("DOMESTICPLAN")) {
			return new DomesticPlan();
		} else if (planType.equalsIgnoreCase("COMMERCIALPLAN")) {
			return new CommercialPlan();
		} else if (planType.equalsIgnoreCase("INSTITUTIONALPLAN")) {
			return new InstitutionalPlan();
		}
		return null;
	}
}

class PlanVO {
	private String planType;
	private int units;

	PlanVO(String planType, int units) {
		this.planType = planType;
		this.units = units;
	}

	public String getPlanType() {
		return planType;
	}

	public int getUnits() {
		return units;
	}
}