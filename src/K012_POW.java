
public class K012_POW {

	/**
	 * Time Complexity: O(n) Space Complexity: O(1) Algorithmic Paradigm: Divide and
	 * conquer.
	 */
	/* Function to calculate x raised to the power y */
	static int power(int x, int y) {
		if (y == 0)
			return 1;
		else if (y % 2 == 0)
			return power(x, y / 2) * power(x, y / 2);
		else
			return x * power(x, y / 2) * power(x, y / 2);
	}

	static float power(float x, int y) {
		float temp;
		if (y == 0)
			return 1;
		temp = power(x, y / 2);

		if (y % 2 == 0)
			return temp * temp;
		else {
			if (y > 0)
				return x * temp * temp;
			else
				return (temp * temp) / x;
		}
	}

	/* Program to test function power */
	public static void main(String[] args) {
		int x = 2;
		int y = 3;

		System.out.printf("%d", power(x, y));
		System.out.println();
		float xx = 2;
		int yy = -3;
		System.out.printf("%f", power(xx, yy));
	}
}
