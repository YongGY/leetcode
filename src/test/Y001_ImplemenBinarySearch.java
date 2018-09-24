package test;

public class Y001_ImplemenBinarySearch {

	/**
	 * 
	 * implement binary search
	 * 
	 * 总共有n个元素，

		渐渐跟下去就是n,n/2,n/4,....n/2^k，其中k就是循环的次数
		
		由于你n/2^k取整后>=1
		
		即令n/2^k=1
		
		可得k=log2n,（是以2为底，n的对数）
		
		所以时间复杂度可以表示O()=O(logn)
	 * 
	 */

	public int binarySearch(int[] inputArr, int key) {

		int start = 0;
		int end = inputArr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (key == inputArr[mid]) {
				return mid;
			}
			if (key < inputArr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		Y001_ImplemenBinarySearch mbs = new Y001_ImplemenBinarySearch();
		int[] arr = { 2, 4, 6, 8, 10, 12, 14, 16 };
		System.out.println("Key 14's position: " + mbs.binarySearch(arr, 14));
		int[] arr1 = { 6, 34, 78, 123, 432, 900 };
		System.out.println("Key 432's position: " + mbs.binarySearch(arr1, 432));
	}

}
