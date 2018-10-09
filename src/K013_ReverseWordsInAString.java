import java.util.Arrays;

public class K013_ReverseWordsInAString {

	public String reverseWords(String s) {
		String[] words = s.trim().split(" +");
		int len = words.length;
		StringBuilder result = new StringBuilder();
		for (int i = len - 1; i >= 0; i--) {
			result.append(words[i]);
			if (i != 0)
				result.append(" ");
		}
		return result.toString();
	}

	//方法二
	public void reverseWords(char[] s) {
		reverse(s, 0, s.length - 1);
		int start = 0;
		for (int i = 0; i < s.length; i++) {
			if (s[i] == ' ') {
				reverse(s, start, i - 1);
				start = i + 1;
			}
		}
		reverse(s, start, s.length - 1);
	}

	public void reverse(char[] s, int start, int end) {

		while (start < end) {
			char tmp = s[start];
			s[start] = s[end];
			s[end] = tmp;
			start++;
			end--;
		}
		System.out.println(Arrays.toString(s));

	}
	
	public static void main(String[] args) {
		K013_ReverseWordsInAString k = new K013_ReverseWordsInAString();
		String s = "the sky is blue";
		k.reverseWords(s.toCharArray());
	}
}
