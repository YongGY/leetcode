package test;

import java.util.ArrayList;
import java.util.List;

import a0_common.TreeNode;

public class Z007_MaximumWidthOfBinaryTree {

	public int widthOfBinaryTree(TreeNode root) {
		return dfs(root, 0, 1, new ArrayList<Integer>(), new ArrayList<Integer>());
	}

	public int dfs(TreeNode root, int level, int order, List<Integer> start, List<Integer> end) {
		if (root == null) {
			return 0;
		}
		if (start.size() == level) {
			start.add(order);
			end.add(order);
		} else {
			end.set(level, order);
		}
		int cur = end.get(level) - start.get(level) + 1;
		int left = dfs(root.left, level + 1, 2 * order, start, end);
		int right = dfs(root.right, level + 1, 2 * order + 1, start, end);
		return Math.max(cur, Math.max(left, right));
	}

	
	
	public int widthOfBinaryTree2(TreeNode root) {
		// Write your code here
		if (root == null) {
			return 0;
		}
		int res = 0;
		List<TreeNode> last = new ArrayList<>();
		List<TreeNode> now = new ArrayList<>();
		last.add(root);
		while (last.size() > 0) {
			now.clear();
			res = Math.max(res, last.size());
			for (int i = 0; i < last.size(); i++) {
				TreeNode treeNode = last.get(i);
				if (treeNode == null) {
					now.add(null);
					now.add(null);
				} else {
					now.add(treeNode.left);
					now.add(treeNode.right);
				}
			}
			while (now.size() > 0 && now.get(0) == null) {
				now.remove(0);
			}
			while (now.size() > 0 && now.get(now.size() - 1) == null) {
				now.remove(now.size() - 1);
			}
			List<TreeNode> now1 = now;
			now = last;
			last = now1;
		}
		return res;
	}

}
