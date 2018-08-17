package string.improve;

/**
 * 
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * 
 * The return value is the actual number of characters read. 
 * 
 * For example, it returns 3 if there is only 3 characters left in the file.
 * 
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 * 
 * Note:
 * The read function may be called multiple times.
 * 
 * Show Tags
 * Have you met this question in a real interview?
 * 
 * @author William
 * 
 * 
 * 这道题跟I不一样在于，read函数可能多次调用，比如read(buf,23)之后又read(buf, 25), 第一次调用时的buffer还没用完，还剩一个char在buffer里，第二次拿出来接着用，这样才能保证接着上次读的地方继续往下读。
 * 
 * 1. 所以应该设置这4个char的buffer为instance variable（实例变量），这样每次调用read函数后buffer还剩的元素可以被保存下来，供给下一次读取
 * 
 * 2. 那么下一次调用read函数时候，怎么知道上一次buffer里面还剩不剩未读元素呢？
 * 我们有oneRead(一次读到buffer里的char数)，actRead(实际被读取的char数)，oneRead-actRead就是还剩在buffer里的char数。
 * 通常oneRead == actRead, 只有当n-haveRead < oneRead时，才不等，这就是上一次调用read结束的时候。
 * 所以只要调用read函数发现oneRead != 0 时，就说明上一次调用read还剩了元素在buffer里，先读完这个，再调用read4读新的。
 * oneRead也需要是instance varaible
 * 
 * 3. 还需要设置一个offset: Use to keep track of the offset index where the data begins in the nextread call. 
 * The buffer could be read partially (due to constraints of reading upto n bytes) and therefore leaving some data behind.
 * 
 *                       |<--buffer-->|   
 *     // |_________________________|
 *     // |<---offset---> |<----oneRead--->
 * 
 * 上图所示为一次read最后的情况，offset部分其实就是actRead的部分，oneRead = oneRead - actRead, 就剩下了右边一部分在buffer里没有读，下一次read函数调用，发现oneRead>0, 说明上一次read还剩了一部分没有读。
 * oneRead表示的其实就是上一次读剩下的char数，offset表示这一次读应该开始的位置
 * 
 * 其实上图的oneRead不一定会充满整个右边部分的，有可能上一次读oneRead根本没有读满整个buffer。 
 * 所以oneRead+offset并不一定等于整个buffer。
 * 这也就是为什么我们一定要用两个变量oneRead\offset的原因，因为oneRead并不一定=4-offset
 * 
 *
 * Solution：需先读Cache
 * 思路：
 * The only thing is when you call read4() which reads 4 bytes into your buffer you might read more than you need, so you want to store those bytes in the structure, and next time you call read will start from those stored bytes, then read more from the file.
 * 
 * 变化是这样：比如先call了n=3，然后call n=5，那么第一次就读入了4个char，第二次call应该把上一次的最后一个char拿来。也就是说要有个cache取缓存已读取的字符，然后从这个cache里面取。
 * 
 * Time Complexity: O(N) Space Complexity: O(1)
 
 *
 */
public class A04_158ReadNCharactersGivenRead4II_CallMultipleTimes {
	

    public int read(char[] buf, int n) {
		return n;
    }
    
	int read4(char[] buf) {
		return 0;
	}
    
 	public static void main(String[] args) {
 		
	}
}
