import java.util.Stack;

/**
 * 
 * @author Demon 2016.8.6
 * 
 *         Given a binary search tree, write a function kthSmallest to find the
 *         kth smallest element in it.
 * 
 *         Note: You may assume k is always valid, 1 ¡Ü k ¡Ü BST's total elements.
 * 
 *         Follow up: What if the BST is modified (insert/delete operations)
 *         often and you need to find the kth smallest frequently? How would you
 *         optimize the kthSmallest routine?
 *
 */
public class Solution {

	public static void main(String[] args) {

	}

	public int kthSmallest(TreeNode root, int k) {
		return kthSmallestBS(root, k);
	}

	// Binary Search: DFS 1ms
	public int kthSmallestBS(TreeNode root, int k) {
		int count = countNodes(root.left);
		if (k <= count)
			return kthSmallest(root.left, k);
		else if (k > count + 1)
			return kthSmallest(root.right, k - 1 - count);
		return root.val;
	}

	public int countNodes(TreeNode node) {
		if (node == null)
			return 0;
		return 1 + countNodes(node.left) + countNodes(node.right);
	}

	// In-Order traversal 2ms
	public int kthSmallestInOrder(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<Solution.TreeNode>();
		while (root != null) { // Traverse to the min node
			stack.push(root);
			root = root.left;
		}
		TreeNode node, right;
		while (k != 0) {
			node = stack.pop();
			k--;
			if (k == 0)
				return node.val;
			right = node.right;
			while (right != null) {
				stack.push(right);
				right = right.left;
			}
		}
		return -1; // Will never hit if k is valid.
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
