package array.basic;

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
 * 
 * 可以用directed-graph的思路来考虑。
 * 
 * 要求的celebrity要满足2个条件: 1所有人都认识他 2他不认识任何人
 * 
 * 另外一个很重要的条件是，只存在一个celebrity,其实一开始做不出来就是这个条件没有利用好。
 * 
 * 假如我们按照 A knows B, then A ===> B 来建立有向图。
 * 
 * 首先看条件2，celebrity doesnt know anyone，图里表示就是他没有到任何其余点的路径。
 * 我们从任何一个点开始，顺着路走，只走没走过的点，比如从0到1了，即便1有到0的路我们也不走，只看2 3 4....是否有路。
 * 
 * 最终会停止在一个没有out edge的点。然后重新遍历，看看是不是所有点都能到它，是不是它不能到之前的任何点就行了。。
 * 
 * 如果有celebrity是不会漏掉的，假如我们最终停在3上。
 * 按大小遍历，假如celebrity的数比3大，那我们会停在3之前，如果比3小，那么因为在3停了，说明3不认识celebrity。
 * 
 * @author William
 *
 */
public class A22_45JumpGameII {
	/* The knows API is defined in the parent class Relation. */
	boolean knows(int a, int b) {
		return false;
	}

	public int findCelebrity(int n) {
		int candidate = 0;
		// 每一次比较只有两种情况，
		// knows(a, b)是true的话，那么a肯定不是candidate; 
		// knows(a, b)是false的话，那么b肯定不是candidate. 
		// 所以一直比较到最后会留下一个candidate，然后我们再验证这个是不是正解。
		for (int i = 1; i < n; i++) {
			if (knows(candidate, i)) {
				candidate = i;
			}
		}
		for (int i = 0; i < n; i++) {
			if (candidate != i && (knows(candidate, i) || !knows(i, candidate))) {
				return -1;
			}
		}
		return candidate;
	}
}
