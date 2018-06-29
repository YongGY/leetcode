package array.basic;

import java.util.Arrays;

/**
 * Given an array of citations (each citation is a non-negative integer) of a
 * researcher, write a function to compute the researcher's h-index.
 * 
 * According to the definition of h-index on Wikipedia: "A scientist has index h
 * if h of his/her N papers have at least h citations each, and the other N − h
 * papers have no more than h citations each."
 * 
 * Example:
 * Input: citations = [3,0,6,1,5]
 * Output: 3 
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had 
 *              received 3, 0, 6, 1, 5 citations respectively. 
 *              Since the researcher has 3 papers with at least 3 citations each and the remaining 
 *              two with no more than 3 citations each, her h-index is 3.
 * 
 * Note: If there are several possible values for h, the maximum one is taken as the h-index.
 * 
 * 题目描述的要求如下：
 * 
 * 给定一个整数序列 citations=[3,0,6,1,5]，代表研究人员共有5篇论文，每个元素代表该论文的引用数量。
 * 从序列元素可以看出，该研究人员有至少3篇论文引用数量为>=3的，其余2篇论文引用数量不足3个引用，所以返回他的 h−index=3； 
 * 也就是说，我们找返回一个整数h，使得数组中至少h个元素值大小>=h，其n−h个元素值<h。
 * 
 * 解决方法： 
 * 首先对序列排序，然后从大到小遍历数组，h值为从1到n，若元素满足num[i]>h，继续遍历，否则跳出循环，返回h即可。
 * 
 * 
 * @author William
 *
 */
public class A13_274H_Index {
	/**
	 * 先将数组排序，我们就可以知道对于某个引用数，有多少文献的引用数大于这个数。
	 * 对于引用数citations[i]，大于该引用数文献的数量是citations.length - i， 而当前的H-Index则是Math.min(citations[i],citations.length - i)， 
	 * 我们将这个当前的H指数和全局最大的H指数来比较，得到最大H指数。
	 */
      public int hIndex(int[] citations) {
           // 排序
           Arrays.sort(citations);
           int h = 0;
           for(int i = 0; i < citations.length; i++){
               // 得到当前的H指数
               int currH = Math.min(citations[i], citations.length - i);
               if(currH > h){
                   h = currH;
               }
           }
           return h;
       }
      

      public int hIndex1(int[] citations) {
          int n = citations.length;
          int[] count = new int[n + 1];
          for(int c : citations)
              if(c >= n) count[n]++;  //当引用数大于等于 n 时，我们均将其数量计入 count[n]中
              else count[c]++;
          for(int i = n; i > 0; i--) {  //从后面开始遍历
              if(count[i] >= i) return i;
              count[i-1] += count[i];  //引用数大于 i-1 的数量是i-1及之后的累加
          }
          return 0;
      }

}
