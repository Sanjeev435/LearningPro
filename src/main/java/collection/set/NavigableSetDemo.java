package collection.set;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

import demo.testObjects.Employee;

public class NavigableSetDemo {
	
	private static Comparator<Employee> com = new Comparator<Employee>(){
		public int compare(Employee e1, Employee e2) {
			// TODO : Add logic for sorting on Employee Id
			 return (Integer.parseInt(e1.getEmpId()) - Integer.parseInt(e2.getEmpId()));
		}
	};
	
	public static void main(String[] args) {
		/**
		 * The initialization of Nag=vigableSet is done using argumented constructor which takes "Comparator" as as argument and 
		 * thereby attaching the sorting logic to the NavigableSet.
		 */
		// TODO : declare a NavigableSet object and initialize it. Test all the methods related to the NavigableSet.
		NavigableSet<Employee> ngSet = new TreeSet<Employee>(com);
		
		//add objects to ngSet
		ngSet.add(new Employee("98", "Ram"));
		ngSet.add(new Employee("59", "Mayank"));
		ngSet.add(new Employee("26", "Aryan"));
		ngSet.add(new Employee("74", "Zheng"));
		ngSet.add(new Employee("14", "Sanju"));
		ngSet.add(new Employee("47", "Karan"));
		ngSet.add(new Employee("89", "Shayam"));
		
		/**
		 * NavigableSet is not synchronized but it can be made synchronized using Collections.synchronizedSet(NavigableSet)
		 * method.
		 */
		Collections.synchronizedSet(ngSet);
		
		/**
		 * A NavigableSet can be arranged in reversed order using the below method. Important thing to be 
		 * noted that the below method change the elements order in the original set too.
		 */
		ngSet = ngSet.descendingSet();
		
		//Iterating on ngSet
		Iterator<Employee> itrator = ngSet.iterator();
		while(itrator.hasNext()){
			Employee emp = itrator.next();
			System.out.println("Emp Id is : "+emp.getEmpId()+"    "+"Emp Name is : "+emp.getEmpName());
		}
		
		/**
		 * A NavigableSet can be iterated in reverse order too using descendingIterator method. This iterator 
		 * reverse the order of iteration without affecting the original NavigableSet object.
		 */
		Iterator<Employee> desIterator = ngSet.descendingIterator();
		System.out.println("\n---------Iterating on NavigableSet in reverse order------------\n");
		while(desIterator.hasNext()){
			Employee emp = desIterator.next();
			System.out.println("Emp Id is : "+emp.getEmpId()+"    "+"Emp Name is : "+emp.getEmpName());
		}
		
		
		Employee emp1 = new Employee("74", "Zheng");
		
		/**
		 * TailSet is used to extract all tail elements in a Set after a particular element including that element
		 * too on reference of which the tailSet is cut-off, i.e. 74 will also be included in the tailSet.
		 */
		SortedSet<Employee> tailSet = ngSet.tailSet(emp1);
		
		Iterator<Employee> it = tailSet.iterator();
		System.out.println("\n"+"-------Iterate through the elements in TailSet after Element with Id \"74\"------------\n");
		while(it.hasNext()){
			Employee em1 = it.next();
			System.out.println("Emp Id is : "+em1.getEmpId() + "    "+"Emp Name is : "+em1.getEmpName());
		}
		
		/**
		 * This TailSet method also works in the same way as the above tailSet. Only difference is that if
		 * "inclusive"=false" then the tailSet will not include that element on reference of which the tailSet
		 * is cut-off, i.e. 74 will not be included in the tailSet.
		 */
		NavigableSet<Employee> tailSet1 = ngSet.tailSet(emp1,false);
		System.out.println("\n------Iterate through the elements in TailSet after Element with Id \"74\" with Inclusive as \"False\"---------\n");
		for(Employee emp: tailSet1){
			System.out.println("Emp Id is : "+emp.getEmpId()+"    "+"Emp Name is : "+emp.getEmpName());
		}
		
		/**
		 * HeadSet is used to extract all head elements, i.e. all elements above that element in a Set after a particular
		 * element excluding that element on reference of which the headSet is cut-off, i.e. 74 will NOT be included in the headSet.
		 */
		SortedSet<Employee> headSet = ngSet.headSet(emp1);
		System.out.println("\n-----Iterate through the elements in HeadSet before Element with Id \"74\"--------\n");
		for(Employee emp: headSet){
			System.out.println("Emp Id is : "+emp.getEmpId()+"    "+"Emp Name is : "+emp.getEmpName());
		}
		
		/**
		 * This HeadSet method also works in the same way as the above headSet. Only difference is that if
		 * "inclusive"=true" then the headSet will also include that element on reference of which the headSet
		 * is cut-off, i.e. 74 will be included in the headSet.
		 */
		SortedSet<Employee> headSet1 = ngSet.headSet(emp1,true);
		System.out.println("\n----Iterate through the elements in HeadSet before Element with Id \"74\" with Inclusive as \"True\"-----\n");
		for(Employee emp: headSet1){
			System.out.println("Emp Id is : "+emp.getEmpId()+"    "+"Emp Name is : "+emp.getEmpName());
		}
		
		/**
		 * SubSet is used to extract the subset in a particular NavigableSet between two set as "Range".
		 * The below range is from "14" to "74". One important thing to be noted is that the lower element
		 * is included in the subset whereas the higher one is not.
		 * Note: The set is in a reverse order. Do not confuse with the elements in set.
		 */
		Employee emp2 = new Employee("14", "Sanju");
		SortedSet<Employee> subSet = ngSet.subSet(emp1, emp2);
		System.out.println("\n------Iterate through the elements in SubSet with Range as element with Id \"74\" and \"14\"------\n");
		for(Employee emp:subSet){
			System.out.println("Emp Id is : "+emp.getEmpId()+"    "+"Emp Name is : "+emp.getEmpName());
		}
		
		/**
		 * This subSet method also work in the same way as the above method. The only difference is that this method
		 * gives you an option weather you want to included the "Range" elements too in your subSet or NOT, i.e. 
		 * you want to include "74" and "14" to be included in your set or NOT.
		 * Below inclusive="true", hence it will include both the elements in the set as well.
 		 */
		SortedSet<Employee> subSet1 = ngSet.subSet(emp1,true, emp2, true);
		System.out.println("\n------Iterate through the elements in SubSet with Range as element with Id \"74\" and \"14\"------\n");
		for(Employee emp:subSet1){
			System.out.println("Emp Id is : "+emp.getEmpId()+"    "+"Emp Name is : "+emp.getEmpName());
		}
		
		/**
		 * PollFirst and PollLast methods are used to know the first and last elements in a Set and at a same time 
		 * it removes those element from Set.
		 */
		emp1 = ngSet.pollFirst();
		emp2 = ngSet.pollLast();
		System.out.println("\n---------------The First and Last element in the Set-------------------\n");
		System.out.println("First Element in Set : "+emp1.getEmpId() +" "+emp1.getEmpName()+ "   "+
				"Last Element in Set : "+emp2.getEmpId()+" "+emp2.getEmpName());
		
		/**
		 * floor() gives one element which is positioned above "49". ceiling() does the opposite of floor(). It return the 
		 * element which is positioned just below "49".
		 */
		System.out.println("\n-------------------Element above \"49\" and below \"49\"------------------\n");
		System.out.println("Element above \"49\" is : "+ngSet.floor(new Employee("49", "Rahul")).getEmpId() +
				" "+ngSet.floor(new Employee("49", "Rahul")).getEmpName()+"     "+
					"Element below \"49\" is : "+ngSet.ceiling(new Employee("49", "Rahul")).getEmpId()
						+" "+ngSet.ceiling(new Employee("49", "Rahul")).getEmpName());
		
		/**
		 * Higher() and lower() methods do the same as ceiling. Higher() gives one position below to a particular element in
		 * a set whereas lower() gives a element one position above in a set.
		 * For e.g. 47 is placed lower in our set w.r.t 49 whereas 59 will be place above w.r.t 49.
		 * So, higher of 49 in our set would be 47 whereas lower would be 59.
		 * Note: Higher and lower method not compared with the values of that element but instead it is concern with the position
		 * of the element. the same goes for ceiling() and floor().
		 */
		emp1 = ngSet.higher(new Employee("49", "Rahul"));
		emp2 = ngSet.lower(new Employee("49", "Rahul"));
		System.out.println("\n-----------------Elements higher and lower than \"49\"---------------------\n");
		System.out.println("Element higher in Set : "+emp1.getEmpId() +" "+emp1.getEmpName()+ "   "+
				"Element lower in Set : "+emp2.getEmpId()+" "+emp2.getEmpName());
		
		//covert Set to Array
		convertToArray(ngSet);
		
		//clear the ngSet before ending the program
		ngSet.clear();
	}
	
	/**
	 * Convert Set to Array
	 * @param ngSet
	 */
	private static void convertToArray(NavigableSet<Employee> ngSet){
		Employee[] emp = new Employee[ngSet.size()];
		ngSet.toArray(emp) ;
		
		System.out.println("\n---------------------Set Converted to Array---------------------\n");
		for(Employee e : emp){
			System.out.println("Emp Id is : "+e.getEmpId()+"    "+"Emp Name is : "+e.getEmpName());
		}
	}
	

}
