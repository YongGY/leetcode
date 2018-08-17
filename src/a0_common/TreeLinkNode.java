package a0_common;

/**
 * 
 * @author William
 *
 */
public class TreeLinkNode {
	int val;
	public TreeLinkNode left, right, next;
	public TreeLinkNode(int x) { val = x; }


	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public TreeLinkNode getLeft() {
		return left;
	}

	public void setLeft(TreeLinkNode left) {
		this.left = left;
	}

	public TreeLinkNode getRight() {
		return right;
	}

	public void setRight(TreeLinkNode right) {
		this.right = right;
	}

	public TreeLinkNode getNext() {
		return next;
	}

	public void setNext(TreeLinkNode next) {
		this.next = next;
	}

	@Override
    public String toString() {
        return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
    }
}
