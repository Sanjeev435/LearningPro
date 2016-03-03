package collection.set;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Comparator;

import demo.testObjects.Employee;
import demo.testObjects.Person;

public class SortedSetDemo {

	/**
	 * Creating a Comparator for Employee Class. 
	 * Comparison based on ID i.e. low to High
	 */
	public static Comparator<Employee> com = new Comparator<Employee>(){
		public int compare(Employee e1, Employee e2) {
			// TODO : Add logic for sorting on Employee Id
			 return (Integer.parseInt(e1.getEmpId()) - Integer.parseInt(e2.getEmpId()));
		}
	};

	public static void main(String[] args) {
		// TODO : create SortedSet objects and test the functionalities

		/**
		 * Create three SortedSet Object
		 * 1. sortedSet object with generic type "Object" which will sort object on basis of "Natural" sorting.
		 * 2. sortedPersonSet with generic type "Person" which will sort object on basis of Comparable logic in "Person" class.
		 * 2. sortedEmpSet with generic type "Employee" which will sort object on basis of Comparator logic as defined above.
		 * 
		 * Person object are sorted on basis of Comparable logic defined in Person Class. No logic for sorting is implemented
		 * in Employee Class. So, We have created a Comparator explicitly in this class and use it while initializing the 
		 * sortedEmpSet object. So, instead of using a default constructor, we have used argumented one and passed the Comparator 
		 * object as argument.
		 * 
		 */
		SortedSet<Object> sortedSet = new TreeSet<Object>();
		SortedSet<Person> sortedPersonSet = new TreeSet<Person>();
		SortedSet<Employee> sortedEmpSet = new TreeSet<Employee>(com);
		
		/**
		 * SortedSet are not synchronized. But They can be made synchronized using Collections class
		 * Synchronizing all SortedSet objects. We can also make an object synchronized at the time of initialization.
		 * For e.g. SortedSet<Object> sortedSet = Collections.synchronizedSortedSet(new TreeSet<Object>());
		 */
		Collections.synchronizedSortedSet(sortedSet);
		Collections.synchronizedSortedSet(sortedEmpSet);
		Collections.synchronizedSortedSet(sortedPersonSet);
		
		sortedSet.add("Purple");
		sortedSet.add("Apple");
		sortedSet.add("Dear");
		sortedSet.add("1");
		sortedSet.add("Example");
		sortedSet.add("SortedSet");
		
		/**
		 * Implement Iterator of type <Object> for iterating through sortedSet object
		 */
		Iterator<Object> iterator = sortedSet.iterator();
		System.out.println("---------------Iterate On Object Using Natural Sorting---------------");
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		/**
		 * Adding elements in sortedPersonSet object
		 */
		sortedPersonSet.add(new Person("98", "Ram"));
		sortedPersonSet.add(new Person("89", "Shayam"));
		sortedPersonSet.add(new Person("26", "Aryan"));
		sortedPersonSet.add(new Person("74", "Zheng"));
		sortedPersonSet.add(new Person("14", "Sanju"));
		sortedPersonSet.add(new Person("47", "Karan"));
		
		/**
		 * Implement Iterator of type <Person> for iterating through sortedPersonSet object
		 * The way should be noted how the Id and Name is printed of Person object.
		 * Sorting is done on the basis of logic given in Person Class
		 */
		Iterator<Person> iterator1 = sortedPersonSet.iterator();
		
		System.out.println("---------------Iterate On Person Object Using Iterator---------------");
		while(iterator1.hasNext()){
			Person p = iterator1.next();
			System.out.println(p.getId()+"   "+p.getName());
		}
		
		/**
		 * Implement Enumeration of type <Person> for iterating through sortedPersonSet object
		 * The way should be noted how the Id and Name is printed of Person object.
		 * Sorting is done on the basis of logic given in Person Class.
		 */
		Enumeration<Person> enPerson = Collections.enumeration(sortedPersonSet);
		
		System.out.println("---------------Iterate On Person Object Using Enumeration---------------");
		while(enPerson.hasMoreElements()){
			Person p = enPerson.nextElement();
			System.out.println(p.getId()+"   "+p.getName());
			
		}
		
		/**
		 * Adding elements in sortedEmpSet object
		 */
		sortedEmpSet.add(new Employee("98", "Ram"));
		sortedEmpSet.add(new Employee("89", "Shayam"));
		sortedEmpSet.add(new Employee("26", "Aryan"));
		sortedEmpSet.add(new Employee("74", "Zheng"));
		sortedEmpSet.add(new Employee("14", "Sanju"));
		sortedEmpSet.add(new Employee("47", "Karan"));
		
		/**
		 * Implement ForEach of type <Employee> for iterating through sortedEmpSet object
		 * The way should be noted how the Id and Name is printed of Employee object.
		 * Sorting is done on the basis of logic defined in Comparator in this class.
		 */
		System.out.println("---------------Iterate On Employee Object Using For Each---------------");
		for(Employee emp : sortedEmpSet){
			System.out.println(emp.getEmpId() + "  "+ emp.getEmpName());
		}
		
		sortedSet.clear();
		sortedEmpSet.clear();
		sortedPersonSet.clear();
	}
}
