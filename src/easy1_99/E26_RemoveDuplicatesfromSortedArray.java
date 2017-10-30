package easy1_99;

/**
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * 
 * For example, Given input array nums = [1,1,2],
 * 
 * Your function should return length = 2, with the first two elements of nums
 * being 1 and 2 respectively. It doesn't matter what you leave beyond the new
 * length.
 * 
 * @author yongguo
 *
 */
public class E26_RemoveDuplicatesfromSortedArray {

	
    public static int removeDuplicates(int[] nums) {
    	int j = 0;
    	for (int i = 1; i < nums.length; i++) {
    		if(nums[j] != nums[i]){
    			nums[++j] = nums[i];
    		}
		}
		return j+1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeDuplicates(new int[]{1,1,2,2,2}));
	}

}