package string.palindrome;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * Example:
 * 
 * Input: "aab"
 * Output:
 *     [
 *       ["aa","b"],
 *       ["a","a","b"]
 *     ]
 * 
 * @author William
 *
 */
public class A131_PalindromePartitioning {

	
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s == null || s.length() == 0){
            return res;
        }
        dfs(s, 0, new ArrayList<>(), res);
        return res;
    }
    
    void dfs(String s, int i, List<String> temp, List<List<String>> res){
        if(i == s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int j = i; j < s.length(); j++){
            if(isPalindrome(s, i, j)){
                temp.add(s.substring(i, j + 1));
                dfs(s, j + 1, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }
    
    boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
 	public static void main(String[] args) {
 		
	}
}
