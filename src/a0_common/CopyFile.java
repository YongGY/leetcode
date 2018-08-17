package a0_common;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 编写程序，将指定目录下所有.java文件拷贝到另一个目的中，并将扩展名改为.txt
 */
public class CopyFile {
    public static void copyFunc(String folder,String tarName){
        try {
            // 读取文件绝对路径
            File file = new File("C:\\eclipse-workspace\\leetcode\\src\\common\\ClassExample.java");
            File tarFile = new File("C:\\eclipse-workspace\\leetcode\\src\\"+folder+"\\"+tarName+".java");
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
    			"A278_FirstBadVersion"
    			,"A035_SearchInsertPosition"
    			,"A033_SearchInRotatedSortedArray"
    			,"A081_SearchInRotatedSortedArrayII"
    			,"A153_FindMinimumInRotatedSortedArray"
    			,"A154_FindMinimumInRotatedSortedArrayII"
    			,"A162_FindPeakElement"
    			,"A374_GuessNumberHigherOrLower"
    			,"A034_SearchForARange"
    			,"A349_IntersectionOfTwoArrays"
    			,"A350_IntersectionOfTwoArraysII"
    			,"A315_CountOf SmallerNumbersAfterSelf"
    			,"A300_LongestIncreasingSubsequence"
    			,"A354_RussianDollEnvelopes"
    	};
    	for (String str : strings) {
    		copyFunc("binary_search",str);
		}
 
    }
    
 
    
}