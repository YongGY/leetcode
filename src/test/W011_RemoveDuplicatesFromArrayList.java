package test;

import java.util.ArrayList;
import java.util.HashSet;

public class W011_RemoveDuplicatesFromArrayList {

	static ArrayList<String> removeDuplicates(ArrayList<String> list) {
		ArrayList<String> res = new ArrayList<>();

		if (list == null || list.size() == 0) {
			return res;
		}

        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < list.size(); i++){
        	String str = list.get(i);
        	if(set.add(str)){
        		set.add(str);
        		res.add(str);
        	}
        }
		return res;
	}
	
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("dog");
        list.add("cat");
        list.add("dog");
        list.add("dog");
        list.add("cat");
        list.add("bird");
        
        System.out.println(removeDuplicates(list));
    }

}
