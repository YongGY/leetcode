package easy100_199;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than [_ n/2 _]times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 */
public class E169_MajorityElement {

	public static int majorityElement(int[] nums) {
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int val = 0;
		for (int n : nums) {
			val = n;
			if(map.get(val) == null) {
				map.put(val, 1);
			}else {
				map.put(val, map.get(val)+1);
			}
			
			if(map.get(val) > nums.length / 2) {
				break;
			}
		}
		return val;
	}
	
 
	public static void main(String[] args) {
		System.out.println(majorityElement(new int[] {3,3,4}));
	}

}
