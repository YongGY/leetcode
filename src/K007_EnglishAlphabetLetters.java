public class K007_EnglishAlphabetLetters {

	public static boolean checkStringForAllTheLetters(String str) {
		int index = 0;
		boolean[] boo = new boolean[26];

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if ('a' <= c && c <= 'z') {
				index = c - 'a';
			} else if ('A' <= c && c <= 'Z') {
				index = c - 'A';
			}
			boo[index] = true;
		}

		for (int i = 0; i < 26; i++) {
			if (!boo[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(checkStringForAllTheLetters("abcdefghijklmnopqrstuvwxy"));
	}

}
