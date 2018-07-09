package common;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 编写程序，将指定目录下所有.java文件拷贝到另一个目的中，并将扩展名改为.txt
 */
public class CopyFile {
    public static void copyFunc(String name,String tarName){
        try {
            // 读取文件绝对路径
            File file = new File("C:\\eclipse-workspace\\leetcode\\src\\string\\basic\\"+name);
            File tarFile = new File("C:\\eclipse-workspace\\leetcode\\src\\string\\basic\\"+tarName+".java");
//            tarFile.isDirectory(); 
            // 文件输入输出流
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(tarFile);
            if (file.exists()) {
                int b = 0; 
                // 判断是否到文件结尾
                while ((b = fis.read()) != -1) {    
                    fos.write(b); // 复制旧文件的内容到新文件
                    fos.flush();
                }
            } // 关闭源， 先开的后关，后开的先关
            fos.close();
            fis.close();
            System.out.println("文件复制完毕！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    public static void main(String[] args) {
    	
    	String [] strings = new String[] {
     			"A02_014LongestCommonPrefix"
    			,"A03_058LengthOfLastWord"
    			,"A04_387FirstUniqueCharacterInAString"
    			,"A05_383RansomNote"
    			,"A06_344ReverseString"
    			,"A07_151ReverseWordsInAString"
    			,"A08_186ReverseWordsInAStringII"
    			,"A09_345ReverseVowelsOfAString"
    			,"A10_205IsomorphicStrings"
    			,"A11_293FlipGame"
    			,"A12_294FlipGameII"
    			,"A13_290WordPattern"
    			,"A14_242ValidAnagram"
    			,"A15_049GroupAnagrams"
    			,"A16_249GroupShiftedStrings"
    			,"A17_087ScrambleString"
    			,"A18_179LargestNumber"
    			,"A19_006ZigZagConversion"
    			,"A20_161OneEditDistance"
    			,"A21_038CountAndSay"
    			,"A22_358RearrangeStringKDistanceApart"
    			,"A23_316RemoveDuplicateLetters"
    			,"A24_271EncodeAndDecodeStrings"
    			,"A25_168ExcelSheetColumnTitle"
    			,"A26_171ExcelSheetColumnNumber"
    			,"A27_013RomanToInteger"
    			,"A28_012IntegerToRoman"
    			,"A29_273IntegerToEnglishWords"
    			,"A30_246StrobogrammaticNumber"
    			,"A31_247StrobogrammaticNumberII"
    			,"A32_248StrobogrammaticNumberIII"
    	};
    	for (String str : strings) {
    		copyFunc("A01_028ImplementStrStr.java",str);
		}
 
    }
}