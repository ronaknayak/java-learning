package java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * 
 * @author ronak.nayak
 * 
 * Operation on Collections with Lambda Expression:
 * 
 */
public class Section_E {
	public static void main(String[] args) {
		
		List<Person> persons = Arrays.asList(
				new Person("Anil", "Rajpurohit", 24),
				new Person("Nisarg", "Juthani", 28),
				new Person("Ronak", "Nayak", 26));
		
		System.out.println("With Java7 *******************");
		
		//Java7 for sorting 
		Collections.sort(persons, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getAge() - o2.getAge();
			}
		});
		
		//Java7 for printing
		printAll(persons);
		
		//Java7 for performing some filter operation
		printLastNameBeginsWith(persons, "R");
		
		List<Person> personList = Arrays.asList(
				new Person("Anil", "Rajpurohit", 24),
				new Person("Nisarg", "Juthani", 28),
				new Person("Ronak", "Nayak", 26));
		
		System.out.println("\nWith Java8 *******************");
		
		//Java8 for sorting
		Collections.sort(personList, (p1, p2) -> p1.getAge() - p2.getAge());
		
		/*
		 * Java8 for printing
		 * 
		 * This become more beneficial when we have to work in MULTI THREADING 
		 * as it has to execute in parallel.  
		 */
		// personList.forEach(System.out::println);
		personList.forEach(person -> System.out.println(person));
		
		//Java8 for performing some filter operation (Using predefined functional interface)
		printLastNameStartWith(personList, p -> p.getLastName().startsWith("J"));
	}
	
	public static void printAll(List<Person> persons) {
		for (Person person : persons) {
			System.out.println(person);
		}
	}
	
	public static void printLastNameBeginsWith(List<Person> persons, String lastNameStart) {
		for (Person person : persons) {
			if(person.getLastName().startsWith(lastNameStart)) {
				System.out.println("Result: "+person);
			}
		}
	}
	
	public static void printLastNameStartWith(List<Person> persons, Predicate<Person> predicate) {
		for (Person person : persons) {
			if(predicate.test(person)) {
				System.out.println("Result: "+person);
			}
		}
	}
}

class Person {
	private String firstName;
	private String lastName;
	private int age;
	
	public Person(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	};
	
	
}