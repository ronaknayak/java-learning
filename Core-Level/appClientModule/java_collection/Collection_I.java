package java_collection;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * 3) Set(I):
 * 
 * It's the child interface of Collection.
 * 
 * If we want to represent a group of individual objects as a single entity
 * where duplicates are not allowed & insertion order is not required then we
 * should go for Set.
 * 
 * Set interface does not contain any new method & We have to use only
 * Collection interface method.
 * 
 * HashSet and LinkedHashSet are implementation classes for Set interface.
 * 
 * 
 * 
 * HashSet(c):
 * --------------------------------------------------------------------
 * 
 * The underlying data structure is HashTable.
 * 
 * Duplicate objects are not allowed & Insertion order is not preserved.
 * 
 * It is based on Hash code of an object & this is the reason it can't preserve
 * the original order of insertion.
 * 
 * NULL insertion is possible.(Only once because duplicates are not allowed as
 * it has to store each element based on hash code.)
 * 
 * Heterogeneous objects are allowed.
 * 
 * Implements SerializablE & CloneablE interface.
 * 
 * HashSet is best choice if our frequent operation is Search operation.
 * 
 * Note:
 * 
 * In HashSet duplicate objects are not allowed. If we are trying to insert
 * duplicates then we won't get CE or RE & add() simply returns false.
 * 
 * 
 * Constructors:
 * 
 * HashSet h = new HashSet();
 * 
 * Creates an empty ArrayList object with default initial capacity 16 & default
 * fill ratio 0.75(75%). Here, after adding 12 objects a new HashSet object will
 * be created.
 * 
 * Fill Ratio (Load Factor): After completing the specified ratio then only a
 * new HashSet object will be created. This ratio is called Fill Ratio.
 * 
 * 
 * HashSet h = new HashSet(int initialCapacity);
 * 
 * Created an empty HashSet object with the specified Initial capacity default
 * fill ratio 0.75. This constructor used when we know the Initial size in
 * advance.
 * 
 * HashSet h = new HashSet(int initialCapacity, float fillRatio);
 * 
 * HashSet h = new HashSet(Collection c);
 * 
 * Creates an equivalent HashSet object for the given Collection. So, This
 * constructor is for internal conversion between Collection objects.
 * 
 * 
 * 
 * LinkedHashSet(c):
 * ------------------------------------------------------------------------
 * LinkedHashSet is the child class of HashSet.
 * 
 * The underlying data structure is a combination of Hashtable and LinkedList.
 * 
 * Duplicate objects are not allowed and Insertion order is preserved as well.
 */

public class Collection_I {
	public static void main(String[] args) {

		Channel channel = new Channel("SONY", 101);
		Channel channel2 = new Channel("SONY", 102);
		Channel channel3 = new Channel("SONY", 101);
		Channel channel3_1 = new Channel("PHILIPS", 101);
		Channel channel4 = channel2;
		
		HashSet<Channel> channels = new HashSet<Channel>();
		//System.out.println(channels.add(null));
		System.out.println(channels.add(channel));
		System.out.println(channels.add(channel2));
		System.out.println(channels.add(channel3));
		System.out.println(channels.add(channel3_1));
		System.out.println(channels.add(channel4));
		
		System.out.println("**** Added Objects *****");
		System.out.println("Can't give guarantee for order: ");
		for (Channel ch : channels) {
			System.out.println(ch.channelTitle + ":" +ch.channelNumber);
		}

		LinkedHashSet<Channel> channelSet = new LinkedHashSet<Channel>();
		channelSet.add(channel);
		channelSet.add(channel2);
		channelSet.add(channel3);
		channelSet.add(channel3_1);
		System.out.println("Can give guarantee for order: ");
		for (Channel ch : channelSet) {
			System.out.println(ch.channelTitle + ":" +ch.channelNumber);
		}
	}
}

class Channel {

	String channelTitle;
	int channelNumber;

	public Channel(String channelTitle, int channelNumber) {
		this.channelTitle = channelTitle;
		this.channelNumber = channelNumber;
	}

	@Override
	public int hashCode() {
		System.out.println("In hashCode() method");
		return channelNumber;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("In equals() method");
		if (obj == this) {
			System.out.println("obj == this");
			return true;
		}
		Channel channel = (Channel) obj;
		if (channelTitle.equals(channel.channelTitle)
				&& channelNumber == channel.channelNumber) {
			System.out.println("contents are equal");
			return true;
		} else {
			System.out.println("not equal");
			return false;
		}
	}
}