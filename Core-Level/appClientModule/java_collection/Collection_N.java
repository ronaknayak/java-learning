package java_collection;

import java.util.Comparator;
import java.util.TreeSet;

/*
 * Important Programs:
 */

public class Collection_N {
	public static void main(String[] args) {

		TreeSet<String> team = new TreeSet<String>(new StringComparator());
		team.add("Virat Kohli");
		team.add("Ajinkya Rahane");
		team.add("Rohit Sharma");
		team.add("MS Dhoni");
		team.add("Ravindra Jadeja");
		team.add("Ravichandra Ashwin");
		System.out.println("Reverse string objects: " + team);

		TreeSet<Object> teamDetails = new TreeSet<Object>(
				new StringBufferComparator());
		teamDetails.add(new StringBuffer("Virat Kohli"));
		teamDetails.add(new StringBuffer("Ajinkya Rahane"));
		teamDetails.add(new StringBuffer("Rohit Sharma"));
		teamDetails.add(new StringBuffer("MS Dhoni"));
		teamDetails.add(new StringBuffer("Ravindra Jadeja"));
		teamDetails.add(new StringBuffer("Ravichandra Ashwin"));
		System.out.println("Sort stringbuffer objects: " + teamDetails);

		TreeSet<Object> teamData = new TreeSet<Object>(
				new UniversalComparator());
		teamData.add(new StringBuffer("Virat Kohli"));
		teamData.add("Ajinkya Rahane");
		teamData.add(new StringBuffer("Rohit Sharma"));
		teamData.add("MS Dhoni");
		teamData.add(new StringBuffer("Ravindra Jadeja"));
		teamData.add(new StringBuffer("Ravichandra Ashwin"));
		teamData.add("Isant Sharma");
		System.out.println("Different Objects: " + teamData);
	}
}

class StringComparator implements Comparator<String> {

	/** To Reverse the order of string objects */

	@Override
	public int compare(String obj1, String obj2) {

		// return -obj1.compareTo(obj2);
		return obj2.compareTo(obj1);
	}
}

class StringBufferComparator implements Comparator<Object> {

	/**
	 * To insert StringBuffer objects in TreeSet.
	 * 
	 * For StringBuffer compulsory we have to go for Comparator. Otherwise, It
	 * will at RunTime. Because StringBuffer does not implement Comparable
	 * interface.
	 * 
	 * Note:
	 * 
	 * If We are depending own default natural sorting order, compulsory object
	 * should be homogeneous & Comparable. Otherwise, we'll get RE saying CCE.
	 * 
	 * If We are defining our own sorting by Comparator then objects need not be
	 * Comparable & Homogeneous. i.e. We can add Heterogeneous & Non-comparable
	 * objects also.
	 */

	@Override
	public int compare(Object obj1, Object obj2) {

		String s1 = obj1.toString();
		String s2 = obj2.toString();

		return s1.compareTo(s2);
	}
}

class UniversalComparator implements Comparator<Object> {

	/**
	 * To insert String & StringBuffer objects into TreeSet, where sorting order
	 * is increasing length order. If two objects having same Length then
	 * consider their Alphabetical order.
	 * 
	 * This is best use case of Comparator interface.
	 */

	@Override
	public int compare(Object obj1, Object obj2) {

		String s1 = obj1.toString();
		String s2 = obj2.toString();

		int l1 = s1.length();
		int l2 = s2.length();

		if (l1 < l2) {
			return -1;
		} else if (l1 > l2) {
			return 1;
		} else {
			return s1.compareTo(s2);
		}
	}

}