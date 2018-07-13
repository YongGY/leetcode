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
 * The read function will only be called once for each test case.
 * 
 * @author William
 * 
 * read4(char[] buf)指的是读取4个数，存储在buf中，然后返回成功读取的数目，如果不够四个，那么就返回剩余数目的字符。
 * 
 * 实现的read(char[] buf, int n)功能类似，只不过将4改为了n，需要输入而已。（这里一个例子只会读取一次read）
 * 
 * 刚开始做的时候理解错了，以为是读取buf中的字符，导致提交失败。
 * 
 * 方法是：先读取n/4次read4，如果期间有出现了不等于4的情况，那么返回结果。
 * 然后读取最后一次，需要判断的是：
 * 1、如果刚好读完了，直接返回结果
 * 2、判断n-result和读取数目num的大小，选择小的，读取并返回数目。
 *
 *
 * 有几种情况需要考虑到：
 * 例如：

 * file = "abcdefgh", n = 8 或者 file="abcdef", n = 6
 * 这种情况最方便，文件长度和要求读入的字符数n相等。
 * 直接调用两次read4()就搞定了。
 *
 * 但有中特殊情况需要考虑的，就是当文件长度和需要读取的字符数目不一致的情况，例如：
 * file = "abcdefgh", n = 6
 * 这种情况下，第一次调用read4()读入abcd,长度是4, 再调用一次read4()则读入edgh, 长度还是4, 那么总长度就是8, 这样就超出了要求的 n = 6的条件了。
 * 因此需要加上一个限制条件。
 * 见代码中的 count = Math.min(count, n - total);这一句。
 *
 *
 */
public class A03_157ReadNCharactersGivenRead4 {
    /**  
     * @param buf Destination buffer  
     * @param n   Maximum number of characters to read  
     * @return    The number of characters read  
     */   
	public int read(char[] buf, int n) {
		char[] buf4 = new char[4];
		int count = 0;
		while (count < n) {
			int remaining = read4(buf4);
			if (remaining == 0)
				break;
			for (int i = 0; i < remaining && count < n; i++) {
				buf[count++] = buf4[i];
			}
		}
		return count;
	}
	
	int read4(char[] buf) {
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(5 / 2);
	}
}
