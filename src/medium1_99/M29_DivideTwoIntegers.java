package medium1_99;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * If it is overflow, return MAX_INT.
 * 
 * @author William
 *
 *         题目分析：
 * 
 *         1. 被除数/除数=商 （忽略余数）=> 被除数=除数*商。
 * 
 *         2. 商（任意整数）可以表示为：a_0*2^0 + a_1*2^1 + ...a_i*2^i + ... + a_n*2^n.
 * 
 *         3. 在Java中左移操作 << 相当于对一个数乘以 2，右移操作相当于除以 2.
 * 
 *         4.我们让除数左移直到大于被除数前的的一个数，
 *         
 *         例如计算28/3，我们进行三次左移操作，使3*2*2*2 = 3*8=24<28(注意四次左移操作得到3*2^4 = 48>28).记录下2*2*2 = 2^3 = 8.
 * 
 *         5.我们让28减去24得到4，然后像第四步一样计算4/3,则3*2^0=3<4.记录下2^0=1.
 * 
 *         6.由于4-3=1小于除数3，停止计算，并将每轮得到的值相加，在本例中8+1=9，记得到商（即28/3=9）。
 * 
 *         至此，程序的主题思想已经介绍完了，接下来要注意数据左移和求整数绝对值的边界问题。
 * 
 *         7. 将输入的Int(32位)型数字转换为long(64位)型。
 * 
 *         8. 考虑MIN_VALUE/-1的特殊情况。
 *
 */

public class M29_DivideTwoIntegers {

	public static int divide(int dividend, int divisor){  
	       int result=0;  
	       if(divisor == 0) //除数为0，返回最大值  
	           return Integer.MAX_VALUE;  
	       if(dividend == Integer.MIN_VALUE && divisor == -1){  
	           return ~dividend;  
	       }  
	       long dividend1 = Math.abs((long)dividend);  
	       long divisor1 = Math.abs((long)divisor);  
	  
	       while(dividend1 >= divisor1)//当被除数大于除数时，进行位移操作  
	       {  
	           int shiftnum = 0;  
	           while(dividend1 >= divisor1<<shiftnum){  
	               shiftnum++;//记录左移次数（比实际次数多1）  
	           }  
	           result += 1<<(shiftnum-1);  
	           dividend1 -= divisor1<<(shiftnum-1);//更新被除数的值  
	       }  
	       if((dividend>0 && divisor>0)||(dividend<0 && divisor<0))//计算正负数  
	           return result;  
	       else  
	           return -result;  
	   }  
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
	}

}
