/**
 * 
 * @author Demon 2016.8.13
 * 
 *         Given two binary trees, write a function to check if they are equal
 *         or not.
 * 
 *         Two binary trees are considered equal if they are structurally
 *         identical and the nodes have the same value.
 *
 */
public class Solution {

	public static void main(String[] args) {

	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		else if ((p == null && q != null) || (p != null && q == null))
			return false;
		return p.val == q.val && isSameTree(p.left, q.left)
				&& isSameTree(p.right, q.right);
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
