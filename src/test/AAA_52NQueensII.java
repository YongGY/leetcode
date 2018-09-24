package test;


public class AAA_52NQueensII {
	public int totalNQueens(int n) {
		int[] pos = new int[n];
		return putQueen(pos, 0, 0);
	}

	public int putQueen(int[] pos, int num, int total) {
		if (num == pos.length) {
			return total + 1;
		}
		int[] exi = new int[pos.length];
		for (int i = 0; i < num; i++) {
			exi[pos[i]] = 1;
			if (pos[i] - (num - i) >= 0)
				exi[pos[i] - (num - i)] = 1;
			if (pos[i] + num - i < pos.length)
				exi[pos[i] + num - i] = 1;
		}

		for (int i = 0; i < pos.length; i++) {
			if (exi[i] == 0) {
				pos[num] = i;
				total = putQueen(pos, num + 1, total);
			}
		}
		return total;
	}
}
