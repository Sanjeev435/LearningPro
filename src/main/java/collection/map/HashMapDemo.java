package collection.map;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import demo.testObjects.Person;

public class HashMapDemo {
	
	
	public static void main(String[] args){
		Map<String, Person> hashMap = new HashMap<String, Person>();
		
		hashMap.put("7",new Person("98", "Ram"));
		hashMap.put("4",new Person("89", "Shayam"));
		hashMap.put("3",new Person("26", "Aryan"));
		hashMap.put("9",new Person("74", "Zheng"));
		hashMap.put("2",new Person("14", "Sanju"));
		hashMap.put("6",new Person("47", "Karan"));
		hashMap.put("6",new Person("49", "Karanuuu"));
		
		/**
		 * 
		 */
	/*	hashMap.put(null, new Person("45", "Jack"));
		hashMap.put(null, new Person("62", "Rohit"));*/
		/**
		 * 
		 */
		Collections.synchronizedMap(hashMap);
		
		/**
		 * 
		 */
		for(Entry<String, Person> keyValuePair : hashMap.entrySet()){
			System.out.println("Key : "+keyValuePair.getKey() +"  Person Id : "+keyValuePair.getValue().getId()
										+"  Person Name : "+keyValuePair.getValue().getName());
		}
		
		/**
		 * 
		 */
		Iterator<String> iterator = hashMap.keySet().iterator();
		System.out.println("\n--------------Iterate over HashTable elements using Iterator-----------------\n");
		while(iterator.hasNext()){
			String key = iterator.next();
			System.out.println("Key : "+key+"  Person Id : "+hashMap.get(key).getId()
					+"  Person Name : "+hashMap.get(key).getName());
		}
		
		System.out.println(hashMap.get("2").getName());
		
		System.out.println("\n--------------Iterate over HashTable elements using forEach-----------------\n");
		hashMap.forEach((K,V)->System.out.println(K+" "+V.getId()+"  "+V.getName()));
		
		LinkedList<Person> list = new LinkedList<Person>(Arrays.asList(hashMap.get("6")));
		list.forEach((person) -> System.out.println(person.getName()));
	}

}
