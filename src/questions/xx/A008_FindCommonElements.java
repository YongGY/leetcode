package questions.xx;

public class A008_FindCommonElements {

	public static void findCommonElements(int[] a, int[] b) {
		System.out.println("Common Elements Between Given Two Array.");
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (a[i] == b[j]) {
					System.out.println(a[i]);
				}
			}

		}
	}

	public static void main(String args[]) {
		int[] a = { 2, 3, 5, 7, 8, 9, 10 };
		int[] b = { 1, 4, 2, 6, 7, 11, 9 };
		findCommonElements(a, b);
	}

}