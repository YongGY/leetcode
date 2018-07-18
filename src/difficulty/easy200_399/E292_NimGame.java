package difficulty.easy200_399;

/**
 * You are playing the following Nim Game with your friend: There is a heap of
 * stones on the table, each time one of you take turns to remove 1 to 3 stones.
 * The one who removes the last stone will be the winner. You will take the
 * first turn to remove the stones.
 * 
 * Both of you are very clever and have optimal strategies for the game. Write a
 * function to determine whether you can win the game given the number of stones
 * in the heap.
 * 
 * For example, if there are 4 stones in the heap, then you will never win the
 * game: no matter 1, 2, or 3 stones you remove, the last stone will always be
 * removed by your friend.
 * 
 * 
 * 这题往小说可以追溯到小学奥数或者脑筋急转弯的书中，往大说可以深究到博弈论。然而编程在这里并没有卵用，策略在于，因为每个人都取不到4个，假设自己后走，要保证每轮自己和对方取得数量的和是4，这样就能确保每轮完后都有4的倍数个石头被取走。这样，如果我们先走的话，先把n除4的余数个石头拿走，这样不管怎样，到最后都会留4个下来，对方取1个你就取3个，对方取2个你就取2个，就必赢了。
 * 
 */

public class E292_NimGame {

    public boolean canWinNim(int n) {
    	return n % 4 != 0;
    }
}
