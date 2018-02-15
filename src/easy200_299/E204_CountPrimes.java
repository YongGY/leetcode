package easy200_299;

import java.util.Arrays;

/**
 * Description:
 * 
 * Count the number of prime numbers less than a non-negative number, n.
 */

public class E204_CountPrimes {

	public static int countPrimes(int n) {
		boolean[] prime = new boolean[n];
		Arrays.fill(prime, true);
		for (int i = 2; i < n; i++) {
			if (prime[i]) {
				// 将i的2倍、3倍、4倍...都标记为非素数
				for (int j = i * 2; j < n; j = j + i) {
					prime[j] = false;
				}
			}
		}
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (prime[i])
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(countPrimes(10));
	}
}
