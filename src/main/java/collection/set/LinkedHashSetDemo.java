package collection.set;

import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class LinkedHashSetDemo {
	
	@SuppressWarnings({ "rawtypes" })
	public static void main(String[] args) {
		// TODO : Implement LinkedHashSet and test its methods
		
		/**
		 * Creation of a instance of LinkedHashSet with capacity 10 and of Object type. So any type of object can be added to the
		 * the set since Object is Super class of all type of object
		 */
		LinkedHashSet<Object> linkedHashSet = new LinkedHashSet<Object>(10);
		
		/**
		 * Creation of a instance of LinkedHashSet of List type. So only list type objects can be added to linkedHashSet1 or
		 * the objects must be converted to List type before add.
		 * Objects can be converted to List type using Arrays.asList(Object) method.
		 */
		LinkedHashSet<List> linkedHashSet1 = new LinkedHashSet<List>();
		
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("StringBuilder are ");
		sBuilder.append("UnSynchronized. Hence not Thread safe.");
		
		List<String> aList = Arrays.asList("Adding","a","ArrayList","of","String Type");
		
		//Add objects in linkedHashSet and linkedHashSet1
		linkedHashSet.add(sBuilder);
		linkedHashSet.add(1);
		linkedHashSet.add(aList);
		linkedHashSet.add(null);//Will return false. Only one null value is permitted. Set will ignore the 2nd "null" value and will not added up in set.
		linkedHashSet.add(null);
		
		/** 
		 * Use add method to add the objects. Before add, the objects need to be changed to array while adding since the declared
		 * LinkedHashSet1 objects is of <List> type. 
		 */
		linkedHashSet1.add(Arrays.asList(sBuilder));
		linkedHashSet1.add(Arrays.asList(linkedHashSet));
		linkedHashSet1.add(null);
		
		/**
		 * LinkedHashSet are not synchronized, i.e. they are not thread-safe.But the objects of LinkedHashSet can be 
		 * synchronized using Collections.synchronizedCollection(Collection) or Collections.synchronizedSet(Set) method.
		 */
		Collections.synchronizedCollection(linkedHashSet);
		Collections.synchronizedSet(linkedHashSet1);
		
		// Check if list is empty or size is 0
		if(checkEmptyForSet(linkedHashSet) && checkEmptyForSet(linkedHashSet1)){
			
			/**
			 * LinkedHashSet can be iterated using Iterator, Enumeration or for Each by the following ways.
			 */
			Iterator<Object> objIterator = linkedHashSet.iterator();
			Iterator<List> arrayIterator = linkedHashSet1.iterator();
			Enumeration en = Collections.enumeration(linkedHashSet);
			
			/**
			 * Will throw ConcurrentModificationException since the hashSet is being modify after creation of Iterator. 
			 * Thats why Iterator is called fail-fast. If you uncomment the below code, ConcurrentModificationException
			 * will be thrown.
			 */
			/*
			 * linkedHashSet.add("Must throw ConcurrentModificationException ");
			 * System.out.println(linkedHashSet);
			 */
			
			//Iteration using Iterator
			while(objIterator.hasNext()){
				System.out.println("Traverse through Objects in LinkedHashSet using Iterator : " +objIterator.next());
			}
			
			//Iteration using Iterator
			while(arrayIterator.hasNext()){
				System.out.println("Traverse through Objects in LinkedHashSet1 using Iterator : " +arrayIterator.next());
			}
			
			//Iteration using Enumeration
			while(en.hasMoreElements()){
				System.out.println("Traverse through Objects in LinkedHashSet using Enumeration : " +en.nextElement());
			}
			
			//Iteration using for each
			for(Object obj: linkedHashSet1){
				System.out.println("Traverse through Objects in LinkedHashSet1 using ForEach : " + obj);
			}
		}
		
		//check the availability of an object in LinkedHashSet
		System.out.println("Is the object present is LinkedHashSet : " + checkObjectInLHashSet(linkedHashSet, 1)); // return true
		System.out.println("Is the object present is LinkedHashSet1 : " + checkObjectInLHashSet(linkedHashSet1, 1)); //return false
		
		if(checkObjectInLHashSet(linkedHashSet, 1)){
			linkedHashSet.remove(1);
			System.out.println("Elements after removal in linkedHashSet" + linkedHashSet);
		}
		
		if(checkObjectInLHashSet(linkedHashSet1, Arrays.asList(sBuilder))){
			linkedHashSet1.remove(Arrays.asList(sBuilder));
			System.out.println("Elements after removal in linkedHashSet1" + linkedHashSet1);
		}
		
		//convert set to Array
		convertSetToArray(linkedHashSet);
		convertSetToArray(linkedHashSet1);
		
		/**
		 * Best Practice is to free the memory after we are done with the set.
		 */
		linkedHashSet.clear();
		linkedHashSet1.clear();
		}

	private static <E> boolean checkEmptyForSet(LinkedHashSet<E> linkedHashSet) {
		return (!linkedHashSet.isEmpty() && !(linkedHashSet.size()==0));
	}

	/**
	 * convert LinkedHashSet to Array using linkedHashSet.toArray() method
	 * 
	 * @param linkedHashSet
	 */
	private static <E> void convertSetToArray(LinkedHashSet<E> linkedHashSet){
		
		Object [] objArray =  linkedHashSet.toArray();
		for(Object obj : objArray){
			System.out.println("Objects In Array : " +obj);
		}
	 }
	
	/**
	 * Searching an object inside LinkedHashSet using linkedHashSet.contains(Object) method
	 * @param linkedHashSet
	 * @param obj
	 * @return
	 */
	private static <E> boolean checkObjectInLHashSet(LinkedHashSet<E> linkedHashSet, Object obj){
		if(linkedHashSet.contains(obj))
			return true;
		else return false;
		
		}
		
	}

