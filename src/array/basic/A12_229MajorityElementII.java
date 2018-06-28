package array.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given an integer array of size n, find all elements that appear more than n/3 times.
 * 
 * Note: The algorithm should run in linear time and in O(1) space.
 * 
 * 
 * Example 1:
 * Input: [3,2,3]
 * Output: [3]
 * 
 * Example 2:
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 * 
 * @author Willam
 *
 */
public class A12_229MajorityElementII {
    public static List<Integer> majorityElement(int[] nums) {
    	List<Integer> list = new ArrayList<>();
    	if(nums == null || nums.length == 0) {
    		return list;
    	}
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums) {
        	if(map.containsKey(n)) {
        		map.put(n, map.get(n)+1);
        	}else {
        		map.put(n, 1);
        	}
        }
        
        for (Integer key : map.keySet()) {
			if(map.get(key) > nums.length / 3) {
				list.add(key);
			}
		}
		return list;
    }
    
    public static void main(String[] args) {
		System.out.println(majorityElement(new int[] {1,1,1,3,3,2,2,2}));
	}
}
