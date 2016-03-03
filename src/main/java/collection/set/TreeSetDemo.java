package collection.set;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

import demo.testObjects.Person;

/**
 * IMPO: TreeSet contains all the properties of SortedSet and NavigableSet.
 * 
 * @author Sanjeev
 *
 */


public class TreeSetDemo {

	public static void main(String[] args) {
		// TODO: Auto-generated method stub
		
		/**
		 * TreeSet can be initialized with many different ways viz. empty constructor and argumented constructor.
		 * Argumented Constructor may take "Comparator", "NavigableMap", "SortedSet" and "Collection".
		 */
		TreeSet<Person> treeSet = new TreeSet<Person>();
		
		treeSet.add(new Person("98", "Ram"));
		treeSet.add(new Person("59", "Mayank"));
		treeSet.add(new Person("26", "Aryan"));
		treeSet.add(new Person("74", "Zheng"));
		treeSet.add(new Person("14", "Sanju"));
		treeSet.add(new Person("47", "Karan"));
		treeSet.add(new Person("89", "Shayam"));
		
		
		/**
		 * TreeSet are not synchronized but can be synchronized using Collections method.
		 */
		Collections.synchronizedSet(treeSet);
		
		System.out.println("\n-------------Print using For Each---------------------\n");
		for(Person person:treeSet){
			System.out.println("Person ID : "+person.getId()+"   "+"Person Name : "+person.getName());
		}
		
		System.out.println("\n-------------Print using Descending Iterator---------------------\n");
		Iterator<Person> iteratorP = treeSet.descendingIterator();
		while(iteratorP.hasNext()){
			Person p = iteratorP.next();
			System.out.println("Person ID : "+p.getId()+"   "+"Person Name : "+p.getName());
		}
		
		//clear memory
		treeSet.clear();
	}

}
