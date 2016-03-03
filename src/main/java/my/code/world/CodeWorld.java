package my.code.world;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

public class CodeWorld {
	
	private static Comparator<Integer> comparator = new Comparator<Integer>() {
		@Override
		public int compare(Integer obj1, Integer obj2) {
			// Note : Write Sorting logic
			return obj2 - obj1;
		}
	};

	public static void main(String[] args) {
		int[] myArray = { 50, 84, 23, 78, 94, 33, 47, 39, 95, 70, 99, 43, 10, 49, 67, 52, 58, 37 };
			
			findLargstNdSmlstNoInArry(myArray);
			findTopTwoMaxArryElemnt(myArray);
			findMissingNoInArray();
			findMissingNosInArray();
			findDuplicateNumInArray();
			find();
	}

	/**
	 * Find largest and smallest number in array
	 */
	private static void findLargstNdSmlstNoInArry(int[] myArray) {
		int smallestNo = myArray[1];
		int largestNo = 0;
		
		for (int i = 0; myArray.length > i; i++) {
			if (largestNo < myArray[i])
					largestNo = myArray[i];
			if (smallestNo > myArray[i])
					smallestNo = myArray[i];
		}
		
		System.out.println("Largest Number in Array is : " + largestNo);
		System.out.println("Smallest Number in Array is : " + smallestNo);
	}

	/**
	 * How to find top two maximum number in array
	 */
	private static void findTopTwoMaxArryElemnt(int[] myArray) {
		// Using Guava Google Jar
		List<Integer> myList1 = Lists.newArrayList(Ints.asList(myArray));
		
		//Sort the elements in List using Collections Class and comparator
		//Note: From JDK 8.0, List also contains sort() method.
		Collections.sort(myList1,comparator);
		
		System.out.println("\n-----------------------------------------------------------------\n");
		System.out.println("First Maximum Number in Array : " + myList1.get(0));
		System.out.println("First Maximum Number in Array : " + myList1.get(1));
		
		// Using Java predefined way
		List<Integer> myList = new ArrayList<Integer>();
		for (int i = 0; myArray.length > i; i++) {
			myList.add(myArray[i]);
		}
		Collections.sort(myList,comparator);
		
		System.out.println("\n-----------------------------------------------------------------\n");
		System.out.println("First Maximum Number in Array : " + myList.get(0));
		System.out.println("First Maximum Number in Array : " + myList.get(1));
		System.out.println("\n-----------------------------------------------------------------\n");
	}

	/**
	 * In an array 1-10 numbers are stored, one number is missing how do you find it
	 */
	private static void findMissingNoInArray(){
		int[] missingNumArray = {5,9,6,3,7,8,2,1,0};
		SortedSet<Integer> ts = new TreeSet<Integer>(Lists.newArrayList(Ints.asList(missingNumArray)));
		boolean flag = false;
		int i=0;
		
		for(Integer in:ts){
			if(!(in.equals(i))){
				System.out.println("Missing number is : "+String.valueOf(i));
				flag = true;
				break;
			}
			++i;
		}
		
		if(!flag)
			System.out.println("No missing number found");
		System.out.println("\n-----------------------------------------------------------------\n");

	}
	
	/**
	 * In an array 1-10 numbers are stored, one number is missing how do you find it
	 */
	private static void findMissingNosInArray(){
		int[] missingNumArray = {3,8,5,1,0,9};
		LinkedList<Integer> missingNum = new LinkedList<Integer>(Lists.newArrayList(Ints.asList(missingNumArray)));
		boolean flag = false;
		int i=0;
		int j = 0;
		
		Collections.sort(missingNum);
		if(missingNum.get(missingNum.size()-1)!=9){
			missingNum.add(9);
		}
		while(i<10){
			
			while((missingNum.get(j))!=i){
				System.out.println("Missing number is : "+i);
				flag = true;
				++i;
			}
			i++;
			j++;
		};
		
		if(!flag)
			System.out.println("No missing number found");
		System.out.println("\n-----------------------------------------------------------------\n");
	}
	
	/**
	 * In an array 1-10 exactly one number is duplicate how do you find it
	 */
	private static void findDuplicateNumInArray(){
		int[] duplicateNumArray = {6,3,8,5,7,1,4,9,8,10};
	}
	
	private static void find(){
		printMissingNumber(new int[]{1, 2, 3, 4, 6}, 6);
		 
        // two missing number
        printMissingNumber(new int[]{1, 2, 3, 4, 6, 7, 9, 8, 10}, 10);
 
        // three missing number
        printMissingNumber(new int[]{1, 2, 3, 4, 6, 9, 8}, 10);
 
        // four missing number
        printMissingNumber(new int[]{1, 2, 3, 4, 9, 8}, 10);
 
        // Only one missing number in array
        int[] iArray = new int[]{1, 2, 3, 5};
        int missing = getMissingNumber(iArray, 5);
        System.out.printf("Missing number in array %s is %d %n", 

                           Arrays.toString(iArray), missing);
	}
	
	private static void printMissingNumber(int[] numbers, int count) {
        int missingCount = count - numbers.length;
        BitSet bitSet = new BitSet(count);
 
        for (int number : numbers) {
            bitSet.set(number - 1);
        }
 
        System.out.printf("Missing numbers in integer array %s, with total number %d is %n",
        Arrays.toString(numbers), count);
        int lastMissingIndex = 0;

        for (int i = 0; i < missingCount; i++) {
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            System.out.println(++lastMissingIndex);
        }
 
    }
	
	private static int getMissingNumber(int[] numbers, int totalCount) {
        int expectedSum = totalCount * ((totalCount + 1) / 2);
        int actualSum = 0;
        for (int i : numbers) {
            actualSum += i;
        }
 
        return expectedSum - actualSum;
    }
 
}
