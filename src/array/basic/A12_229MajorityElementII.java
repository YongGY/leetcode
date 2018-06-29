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
 * @author William
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
    
    public static List<Integer> majorityElement1(int[] nums) {
       	List<Integer> list = new ArrayList<>();
    	if(nums == null || nums.length == 0) {
    		return list;
    	}
    	int num1 = 0, num2 = 0, count1 = 0, count2 = 0;
    	for(int i = 0; i < nums.length; i++){
    		if(num1 == nums[i]){
    			count1++;
    		}else if(num2 == nums[i]){
    			count2++;
    		}else if(count1 == 0){
    			num1 = nums[i];
    			count1 = 1;
    		}else if(count2 == 0){
    			num2 = nums[i];
    			count2 = 1;
    		}else{
    			count1--;
    			count2--;
    		}
    	}
    	list.add(num1);
    	list.add(num2);
    	return list;
    }
    
    public static void main(String[] args) {
		System.out.println(majorityElement(new int[] {1,1,1,3,3,2,2,2}));
		System.out.println(majorityElement1(new int[] {1,1,1,3,3,2,2,2}));
	}
}
