package collection.map;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;

import demo.testObjects.Employee;

public class HashTableDemo {

	public static void main(String[] args) {
		// TODO : Create a HashTable object and check its different functionalities using its method.

		Hashtable<String, Employee> hashTable = new Hashtable<String, Employee>();
		
		hashTable.put("2",new Employee("98", "Ram"));
		hashTable.put("5",new Employee("59", "Mayank"));
		hashTable.put("3",new Employee("26", "Aryan"));
		hashTable.put("7",new Employee("74", "Zheng"));
		hashTable.put("9",new Employee("14", "Sanju"));
		hashTable.put("1",new Employee("47", "Karan"));
		hashTable.put("4",new Employee("89", "Shayam"));
		/**
		 * No NULL key or value is allowed in HahsTable. It will through NullPointerException since it internally checks
		 * Null value in key as well as in value.
		 * 
		 * hashTable.put(null, null);
		 * hashTable.put(null, new Employee("47", "Rajesh"));
		 */
		
		/**
		 * Using Enumeration to iterate over HashTable elements. 
		 */
		Enumeration<String> keyValPair = hashTable.keys();
		System.out.println("\n--------------Iterate over HashTable elements using Enumeration-----------------\n");
		while(keyValPair.hasMoreElements()){
			String key = keyValPair.nextElement();
			System.out.println(key +"   "+hashTable.get(key).getEmpId()+"    "+hashTable.get(key).getEmpName());
		}
		
		/**
		 * Since Enumeration are not "Fail-Safe", hence elements can be added to HashTable object even after the creation of enumeration.
		 * 
		 * Iterating over hashTable object using EnterySet.
		 */
		hashTable.put("6", new Employee("47", "Rajesh"));
		System.out.println("\n--------------Iterate over HashTable elements using EntrySet-----------------\n");
		for(Entry<String, Employee> emp:hashTable.entrySet()){  
			   System.out.println(emp.getKey()+"   "+emp.getValue().getEmpId()+"    "+emp.getValue().getEmpName());  
			  }
		
		/**
		 * We can remove any key/value using the key or either value.
		 * 
		 * Iterating over hashTable object using Iterator.
		 */
		hashTable.remove("6");
		System.out.println("\n--------------Iterate over HashTable elements after remove-----------------\n");

		Iterator<String> it = (hashTable.keySet()).iterator();
		while(it.hasNext()){
			String key = it.next();
			System.out.println(hashTable.get(key).getEmpId()+ "     " + hashTable.get(key).getEmpName());
			
		}
		
		/**
		 * check whether a key is present or not in HashTable.
		 */
		System.out.println("\n--------Does HashTable contain key as \"5\"-------\n"+hashTable.containsKey("5"));
		
		/**
		 * Show the contents of HashTable in String format. Since the value of hashTable is of Employee type, we get the
		 * value as references rather then actual value.
		 */
		System.out.println("\n--------Show the details of keys and value in HashTable-------\n"+"\n"+hashTable.toString());
		
		/**
		 * Clear the table and remove all objects
		 */
		hashTable.clear();
		
	}

}
