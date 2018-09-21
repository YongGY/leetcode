package questions;

public class N004_CheckServerRunning {

	/**
	 * 
	 * Given a list of running time range for a server with start time and end time, 
	 * no overlap, [[0,30], [35,40], .... , [100,104], [105, 110]], 
	 * input a time point, return check whether the server was running at that point
	 * 
	 * @author yongguo
	 *
	 */

	private static boolean checkServerRunning(int[][] nums, int time) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i][0] <= time && nums[i][1] >= time) {
				return true;
			}
		}
		return false;
	}

	private static boolean checkServerRunning2(int[][] nums, int time) {
		int left = nums[0][0];
		int right = nums[nums.length - 1][0];
		while(left < right){
			int mid = (left + right) / 2;
			if(mid == time){
				return true;
			}else if(time > mid){
				
			}
		}
		
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i][0] <= time && nums[i][1] >= time) {
				return true;
			}
		}
		return false;
	}

	
	public static void main(String[] args) {
		int[][] timeslot = { { 0, 30 }, { 35, 40 }, { 45, 60 }, { 100, 104 }, { 105, 110 } };
		System.out.println(checkServerRunning(timeslot, 31));
	}
}
