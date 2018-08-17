package a3_math.basic;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * 
 * For example:
 * 
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * 
 * Follow up:
 * 
 * Could you do it without any loop/recursion in O(1) runtime?
 * 
 * @author William
 *
 *
 * 看一下笔者举的下述例子：
 *
 * 原数		0	1	2	3	4	5	6	7	8		9
 * 对应的数	0	1	2	3	4	5	6	7	8		9
 *
 * 原数		10	11	12	13	14	15	16	17	18		19
 * 对应的数	1	2	3	4	5	6	7	8	9		10/1
 *
 * 原数		20	21	22	23	24	25	26	27	28		29
 * 对应的数	2	3	4	5	6	7	8	9	10/1	11/2
 *
 * 上述从1到9为一个循环，那么是不是后续的数字也会遵循这样的规律，从而最终得到在[1,9]之间的结果呢？ 答案是肯定的。
 *
 * 因为我们假设一个比较大的两位数，比如ab，其实ab的值是a*10+b，那么对应的数应该是a+b。因为a和b都是正数，那么肯定对应之后的数要小于原来的数。
 * 除非a=0，那这时候由上述表格中第一行看得很清楚。
 *
 * 这样子每一个对应的数都小于原来的数，减小了9*a，那么不断地往前腾挪，最终必然到达[1,9]之间。
 *
 * 那么我们由上述表格可以很直观地得到一个结论：
 *
 * 假设要处理的数为n，则最终对应的数=(num-1)%9+1
 *
 * 原本我们可以直接num%9，但是对于num=9或者num=18这些9的整倍数，结论不符合，略微修改一下。
 *
 *
 */
public class A258_AddDigits {

	public int addDigits(int num) {
		while (num >= 10) {
			num = num / 10 + num % 10;
		}
		return num;
	}

	public int addDigits2(int num) {
		return 1 + (num - 1) % 9;
	}

	public static void main(String[] args) {

	}
}