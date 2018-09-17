package questions.xx;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class A011_RemoveDuplicatesFromArrayList {

	
	/**
	 * How to Remove Duplicates from Array List in Java
	 */
	 static ArrayList<String> removeDuplicates(ArrayList<String> list) {

	        // Store unique items in result.
	        ArrayList<String> result = new ArrayList<>();

	        // Record encountered Strings in HashSet.
	        HashSet<String> set = new HashSet<>();

	        // Loop over argument list.
	        for (String item : list) {

	            // If String is not in set, add it to the list and the set.
	            if (!set.contains(item)) {
	                result.add(item);
	                set.add(item);
	            }
	        }
	        return result;
	    }

	 
	static ArrayList<String> removeDuplicates2(ArrayList<String> list) {
		int size = list.size();
		for (int i = size - 2; i >= 0; i--) {
			if (list.get(i) == list.get(i + 1)) {
				list.remove(i);
			}
		}
		return list;
	}
	 	
	 
	    public static void main(String[] args) {

	        ArrayList<String> list = new ArrayList<>();
	        list.add("dog");
	        list.add("cat");
	        list.add("dog");
	        list.add("dog");
	        list.add("cat");
	        list.add("bird");
	        
	        ArrayList<String> list2 = new ArrayList<>();
	        list2.add("dog");
	        list2.add("dog");
	        list2.add("dog");
	        list2.add("cat");
	        list2.add("cat");
	        list2.add("bird");

	        // Remove duplicates from ArrayList of Strings.
	        ArrayList<String> unique = removeDuplicates(list);
	        for (String element : unique) {
	        	System.out.println(element);
	        }
	        System.out.println("==============list2");
	        ArrayList<String> unique2 = removeDuplicates2(list2);
	        for (String element : unique2) {
	        	System.out.println(element);
	        }
	    }

}