package questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P001_AllPossibleCombinationsOfPhoneKeyboard {

	/**
	 * Suppose we have a mapping relationship between numbers and characters: (Phone keyboard)
	 * 
	 * 1 -> ABC 
	 * 2 -> DEF 
	 * 3 -> GHI 
	 * 4 … 
	 * 0 -> WXYZ
	 * 
	 * Given an int num: print all possible combinations of mapping example :
	 * ’12’ can map to [AD, AE, AF, BD, BE, BF, CD, CE, CF]
	 */

	/**
     * 写法一，递归计算所有组合
     * @param inputList 所有数组的列表
     * https://blog.csdn.net/tyhj_sf/article/details/53893125
     * */
	public List<String> combination(String str) {
		Map<Character, String> map = new HashMap<>();
		map.put('1',"ABC");
		map.put('2',"DEF");
		map.put('3',"GHI");
		map.put('4',"JKL");
		map.put('5',"MNO");
		map.put('6',"PQRS");
		map.put('7',"TUV");
		map.put('8',"WXYZ");
		
		List<String> inputList = new ArrayList<>();
		for (char c : str.toCharArray()) {
			inputList.add(map.get(c));
		}
		
		List<String> resList = new ArrayList<>();
		combinationInt(inputList, resList, 0, new char[inputList.size()]);
		return resList;
	}

	private void combinationInt(List<String> inputList, List<String> resList, int ind, char[] arr) {
		if (ind == inputList.size()) {
			resList.add(new String(arr));
			return;
		}
		for (char c : inputList.get(ind).toCharArray()) {
			arr[ind] = c;
			combinationInt(inputList, resList, ind + 1, arr);
		}
	}

	public static void main(String[] args) {
		P001_AllPossibleCombinationsOfPhoneKeyboard p = new P001_AllPossibleCombinationsOfPhoneKeyboard();
		List<String> result = p.combination("12");
		System.out.println("组合结果：");
		for (String string : result) {
			System.out.println(string);
		}
	}
}
