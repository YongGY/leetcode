package a1_array.basic;

/**
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among
 * them, there may exist one celebrity.
 * 
 * The definition of a celebrity is that all the other n - 1 people know him/her
 * but he/she does not know any of them. Now you want to find out who the
 * celebrity is or verify that there is not one.
 * 
 * The only thing you are allowed to do is to ask questions like: "Hi, A. Do you
 * know B?" to get information of whether A knows B.
 * 
 * You need to find out the celebrity (or verify there is not one) by asking as
 * few questions as possible (in the asymptotic sense).
 * 
 * You are given a helper function bool knows(a, b) which tells you whether A
 * knows B.
 * 
 * Implement a function int findCelebrity(n), your function should minimize the
 * number of calls to knows.
 * 
 * Note: There will be exactly one celebrity if he/she is in the party.
 * 
 * Return the celebrity's label if there is a celebrity in the party. If there
 * is no celebrity, return -1.
 * 
 * https://www.youtube.com/watch?v=QDehNYXlCAg
 * 要求的只存在一个celebrity要满足2个条件: 
 * 1.所有人都认识他 
 * 2.他不认识任何人
 * 
 * @author William
 *
 */
public class A277_FindTheCelebrity {
	/* The knows API is defined in the parent class Relation. */
	boolean knows(int a, int b) {
		return false;
	}

	public int findCelebrity(int n) {
		int candidate = 0;
		// 每一次比较只有两种情况，
		// knows(a, b)是true的话，那么a肯定不是candidate;  (未满足：a并没有,他不认识任何人)
		// knows(a, b)是false的话，那么b肯定不是candidate. (未满足：b并没有,所有人都认识他)
		// 所以一直比较到最后会留下一个candidate，然后我们再验证这个是不是正解。
		
		//1.find a candidate by on pass: make sure other people are not a celebrity
		for (int i = 1; i < n; i++) {
			if (knows(candidate, i)) {
				candidate = i;
			}
		}
		//2.make sure if the candidate is a celebrity by one pass
		for (int i = 0; i < n; i++) {
			if(i == candidate){
				continue;
			}
			if (knows(candidate, i) || !knows(i, candidate)) {
				return -1;
			}
		}
		return candidate;
	}
}
