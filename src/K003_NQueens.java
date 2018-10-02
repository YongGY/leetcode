import java.util.ArrayList;
import java.util.List;

public class K003_NQueens {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<List<String>>();
		int[] queens = new int[n];
		pliceQueen(queens, 0, n, res);
		return res;
	}

	public boolean isVaild(int[] queens, int i) {
		for (int idx = 0; idx < i; idx++) {
			if (queens[idx] == queens[i] || Math.abs(queens[idx] - queens[i]) == i - idx) {
				return false;
			}
		}
		return true;
	}

	public void pliceQueen(int[] queens, int row, int n, List<List<String>> res) {
		if (row == queens.length) {
			ArrayList<String> list = new ArrayList<>();
			for (int num : queens) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < num; j++) {
					sb.append(".");
				}
				sb.append("Q");
				for (int j = num + 1; j < n; j++) {
					sb.append(".");
				}
				list.add(sb.toString());
			}
			res.add(list);
		} else {
			for (int num = 0; num < n; num++) {
				queens[row] = num;
				if (isVaild(queens, row)) {
					pliceQueen(queens, row + 1, n, res);

				}
			}
		}

	}
}