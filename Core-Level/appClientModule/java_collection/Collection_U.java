package java_collection;

import java.util.Hashtable;

/**
 * Hashtable(c):
 * 
 * The underlying data structure for Hashtable is HashTable.
 * 
 * Insertion order is not preserved & it's based on hash code of keys.
 * 
 * Duplicate keys are not allowed & values can be duplicated.
 * 
 * Heterogeneous objects are allowed for both keys and values.
 * 
 * null is not allowed for both keys and values. Otherwise, we'll get RE saying
 * NullPointerException.
 * 
 * It implements SerializablE and CloneablE interfaces but not RandomAccess.
 * 
 * MAIN-POINT: Every method present in Hashtable is synchronized & hence,
 * Hashtable object is Thread safe. So, in Non-MULTI Threaded environment it
 * gives low performance.
 * 
 * WHEN TO USE: Hashtable is the best choice if our frequent operation is search
 * operation in MULTI-Threading environment.
 * 
 * 
 * Constructors:
 * 
 * Hashtable m = new Hashtable();
 * 
 * Creates an empty Hashtable object with default initial capacity level is 11 &
 * default fill ratio 0.75(75%).
 * 
 * Hashtable m = new Hashtable(int initialCapacity);
 * 
 * Hashtable m = new Hashtable(int initialCapacity, float fillRatio);
 * 
 * Hashtable m = new Hashtable(Map m);
 * 
 * 
 * Note(ENTHUWARE):
 * 
 * You should know that all Hashtable methods are synchronized and this
 * compromises its performance for simultaneous reads. For that kind of case A
 * HashMap is a perfect choice because its methods are not synchronized and so
 * it allows efficient multiple reads.
 */

public class Collection_U {
	public static void main(String[] args) {

		Hashtable<TempVO, String> h = new Hashtable<TempVO, String>();
		h.put(new TempVO(5), "A");
		h.put(new TempVO(2), "B");
		h.put(new TempVO(6), "C");
		h.put(new TempVO(15), "D");
		h.put(new TempVO(23), "E");
		h.put(new TempVO(16), "F");
		/*
		 * How entries will be saved:
		 * 
		 * Based on hash code objects will be stores. e.g. to save TempVO(15),
		 * 15%11 = 4. Hence, In 4th bucket this object will be saved. We have
		 * taken 11 because it's initial capacity level.
		 * 
		 * output: From bucket, Top to Bottom & Right to Left objects will be
		 * considered.
		 * 
		 * If we change hashCode() method implementation the output will be
		 * varied accordingly.
		 */
		System.out.println("Hashtable of dafault initial capacity: " + h);

		Hashtable<TempVO, String> ht = new Hashtable<TempVO, String>(25);
		ht.put(new TempVO(5), "A");
		ht.put(new TempVO(2), "B");
		ht.put(new TempVO(6), "C");
		ht.put(new TempVO(15), "D");
		ht.put(new TempVO(23), "E");
		ht.put(new TempVO(16), "F");
		/*
		 * How entries will be saved:
		 * 
		 * Based on hash code objects will be stores. But, Here we have
		 * specified initial capacity so while saving objects calculation will
		 * be done accordingly.
		 * 
		 * E.g. to save TempVO(15), 15%25 = 15. Because, there will be total 25
		 * buckets i.e.0 to 24. Hence, In 15th bucket this object will be saved.
		 * We have taken 11 because it's initial capacity level.
		 */
		System.out.println("Hashtable of specified initial capacity: " + ht);
	}
}

class TempVO {

	int number;

	public TempVO(int number) {
		this.number = number;
	}

	@Override
	public int hashCode() {
		System.out.println("In hashCode() method.");
		return number;
		// return number % 9;
	}

	@Override
	public String toString() {
		return number + "";
	}
}
