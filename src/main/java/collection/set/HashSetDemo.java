package collection.set;

import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class HashSetDemo {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		// TODO: create a HashSet to store objects

		/**
		 * Creation of a instance of HashSet with capacity 10 and of Object type. So any type of object can be added to the
		 * the set since Object is Super class of all type of object
		 */
		HashSet<Object> hashSet = new HashSet<Object>(10);

		// creates object with Collection object
		HashSet hashSet1 = new HashSet(Arrays.asList("ArrayList 1",
				"ArrayList 2"));

		StringBuffer sbuffer = new StringBuffer();

		sbuffer.append("DemoBuffer Object");
		
		List<String> aList = Arrays.asList("Adding","a","ArrayList","of","String Type");

		/**
		 * HashSet are not synchronized, i.e. they are not thread-safe.But the objects of HashSet can be 
		 * synchronized using Collections.synchronizedCollection(Collection) or Collections.synchronizedSet(Set) method.
		 */
		Collections.synchronizedSet(hashSet);
		Collections.synchronizedCollection(hashSet1);
		
		// store Object into HashSet
		hashSet.add("Demo HashSet Object");
		hashSet.add(1);
		hashSet.add(1); // will return false, since 1 is already there in set and this object will not be added in HashSet
		hashSet.add(sbuffer);
		hashSet.add(aList);
		
		hashSet1.add(hashSet);

		System.out.println("Objects in hashSet" + hashSet);
		System.out.println("Objects in hashSet1" + hashSet1);

		// Check if list is empty or size is 0
		if ((!hashSet1.isEmpty() && !(hashSet1.size() == 0))
				&& (!hashSet.isEmpty() && !(hashSet.size() == 0))) {

			/**
			 * HashSet can be iterated using Iterator, Enumeration or for Each by the following ways.
			 */
			Iterator<Object> iterator = hashSet.iterator();
			Iterator iterator1 = hashSet1.iterator();
			Enumeration e1 = Collections.enumeration(hashSet1);

			/**
			 * Will throw ConcurrentModificationException since the hashSet is being modify after creation of Iterator. 
			 * Thats why Iterator is called fail-fast. If you uncomment the below code, ConcurrentModificationException
			 * will be thrown.
			 */
			/*
			 * hashSet.add("Must throw ConcurrentModificationException ");
			 * System.out.println(hashSet);
			 */

			// using iterator to iterate through the set
			while (iterator.hasNext()) {
				System.out
						.println("Iterating through Objects in HashSet using Iterator : "
								+ iterator.next());

			}
			while (iterator1.hasNext()) {
				System.out
						.println("Iterating through Objects in HashSet1 using Iterator : "
								+ iterator1.next());
			}

			/**
			 * Using forEach to iterate through hashSet Type Object is used to  iterate since HashSet<Object> type is 
			 * used while creation Type.
			 * String can be used if HashSet<String> type is used while its
			 * creation.
			 */
			for (Object obj : hashSet1) {
				System.out.println("Iterating using for each loop"
						+ obj.toString());
			}
			
			//Using enumeration
			while(e1.hasMoreElements()){
				System.out.println("Iterating through Objects in HashSet1 using Enumerator :" + e1.nextElement());
				
			}
		}

		//check the availability of an object in hashSet
		System.out.println("Is the object present is hashSet : "+ checkObjInHashSet(hashSet, "1")); // result is false since "1" is not present.
		System.out.println("Is the object present is hashSet1 : "+ checkObjInHashSet(hashSet, sbuffer)); //result is true.
		
		//convert set to Array
		convertToArray(hashSet);
		convertToArray(hashSet1);
		
		/**
		 * Best Practice is to free the memory after we are done with the set.
		 */
		hashSet.clear();
		hashSet1.clear();
	}

	/**
	 * convert HashSet to Array using hashSet.toArray() method
	 * @param hashSet
	 */
	private static void convertToArray(HashSet<Object> hashSet) {
		Object[] toArray = hashSet.toArray();
		
		//iterating through Array
		for(Object arrayObj : toArray){
			System.out.println("Objects In Array : " +arrayObj.toString());
		}
	}
	
	/**
	 * Searching an object inside HashSet using hashSet.contains(Object) method
	 * @param linkedHashSet
	 * @param obj
	 * @return
	 */
	private static <E> boolean checkObjInHashSet(HashSet<E> hashSet, Object object){
		if(hashSet.contains(object))
		return true;
		else return false;
	}
}
