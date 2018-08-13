package common;

import java.io.File;
import java.io.IOException;

/**
 * 
 * @author William
 *
 */
public class FileRename {  
    public static void main(String[] args) throws IOException {  
        java.io.File file = new java.io.File("C:\\eclipse-workspace\\leetcode\\src\\math\\seldom");  
        String dirPath = file.getAbsolutePath();//目录路径  
        if (file.isDirectory()) {  
            File[] files = file.listFiles();//获取此目录下的文件列表  
  
            long starttime = System.currentTimeMillis();  
  
            for (File fileFrom : files) {  
                String fromFile = fileFrom.getName();//文件名  
                String toFileName;  
                int index;  
                index = fromFile.indexOf("_");  
                fromFile = fromFile.substring(index + 1);//截取_后面的String  
                fromFile = "A"+fromFile.substring(0,3) +"_" +fromFile.substring(3,fromFile.length());
                if (index != -1)//防止有的文件名没有_  
                {  
                    toFileName = dirPath + "//" + fromFile;  
                    File toFile = new File(toFileName);  
                    if (fileFrom.exists() && !toFile.exists()) {  
                        //开始更名  
                        fileFrom.renameTo(toFile);  
                    }  
                }  
  
            }  
  
            long endtime = System.currentTimeMillis();  
  
            System.out.println("Time:" + new Long(endtime - starttime));//耗时  
        }  
    }  
}  
