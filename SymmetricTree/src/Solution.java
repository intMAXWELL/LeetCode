import java.util.Stack;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

/**
 * 
 * @author Demon 2016.8.23
 * 
 *         Given a binary tree, check whether it is a mirror of itself (ie,
 *         symmetric around its center).
 * 
 *         For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * 
 *         But the following [1,2,2,null,3,null,3] is not:
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = solution.new TreeNode(1);
		root.left = solution.new TreeNode(2);
		root.right = solution.new TreeNode(2);
		//root.left.left = solution.new TreeNode(3);
		root.left.right = solution.new TreeNode(4);
		//root.right.left = solution.new TreeNode(4);
		root.right.right = solution.new TreeNode(3);
		System.out.println(solution.isSymmetric(root));
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return true;
		Stack<TreeNode> leftTree = new Stack<TreeNode>(), rightTree = new Stack<TreeNode>();
		if (root.left != null && root.right != null) {
			leftTree.push(root.left);
			rightTree.push(root.right);
		} else
			return false;
		while (!leftTree.isEmpty() && !rightTree.isEmpty()) {
			TreeNode left = leftTree.pop();
			TreeNode right = rightTree.pop();
			if (left.val == right.val) {
				if (left.right != null && right.left != null) {
					leftTree.push(left.right);
					rightTree.push(right.left);
				} else if ((left.right == null && right.left != null)
						|| (left.right != null && right.left == null)) {
					return false;
				}
				if (left.left != null && right.right != null) {
					leftTree.push(left.left);
					rightTree.push(right.right);
				} else if ((left.left == null && right.right != null)
						|| (left.left != null && right.right == null)) {
					return false;
				}
			} else
				return false;
		}
		return true;

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
