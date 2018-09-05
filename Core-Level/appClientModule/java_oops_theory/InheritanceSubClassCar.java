package java_oops_theory;

public class InheritanceSubClassCar extends InheritanceVehicle {

	int CC;
	int gears;

	@Override
	public void attributes() {
		// The subclass refers to the members of the superclass
		System.out.println("Color of Car : " + color);
		System.out.println("Speed of Car : " + speed);
		System.out.println("Size of Car : " + size);
		System.out.println("CC of Car : " + CC);
		System.out.println("No of gears of Car : " + gears);
	}
	
	void showVehicle() {
		System.out.println("Welcome at our CAR show-room.");
	}
	
	public static void main(String[] args) {

		InheritanceSubClassCar car = new InheritanceSubClassCar();
		car.showVehicle();
		car.color = "Blue";
		car.speed = 200;
		car.size = 22;
		car.CC = 1000;
		car.gears = 5;
		car.attributes();
	}
}
