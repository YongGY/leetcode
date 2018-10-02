import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class Main {

	public static TreeMap<Integer, Integer> tMap = new TreeMap<>();;

	public void topView(TreeNode root, int level) {
		if (root == null){
			return;
		}
		Queue<QueueObj> queue = new LinkedList<>();
 		queue.add(new QueueObj(level, root));
		while (!queue.isEmpty()) {
			QueueObj q = queue.remove();
 			TreeNode t = q.node;
			int l = q.level;

			if (!tMap.containsKey(l)) {
  				tMap.put(l, t.val);
			}

 			if (t.left != null) {
				queue.add(new QueueObj(l - 1, t.left));
			}
			if (t.right != null) {
				queue.add(new QueueObj(l + 1, t.right));
			}
		}

		System.out.println(tMap.values());
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
 
		Main m = new Main();
		m.topView(root, 0);
	}
}

// TreeNode structure of tree
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int val) {
		this.val = val;
	}
}

// this class' represents the items stored in queue (used for level order
// traversal). Objects will store the TreeNodes and its level
class QueueObj {
	int level;
	TreeNode node;

	public QueueObj(int level, TreeNode node) {
		this.level = level;
		this.node = node;
	}
}