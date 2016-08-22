import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 
 * @author Demon 2016.8.22
 * 
 *         Given a binary tree, return the bottom-up level order traversal of
 *         its nodes' values. (ie, from left to right, level by level from leaf
 *         to root).
 * 
 *         For example: Given binary tree [3,9,20,null,null,15,7]
 * 
 *         return its bottom-up level order traversal as: [ [15,7], [9,20], [3]
 *         ]
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode node = solution.new TreeNode(3);
		node.left = solution.new TreeNode(9);
		node.right = solution.new TreeNode(20);
		node.right.left = solution.new TreeNode(15);
		node.right.right = solution.new TreeNode(7);
		System.out.println(solution.levelOrderBottom(node));
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null)
			return res;
		Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.pop();
				list.add(node.val);
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
			res.add(0, list);
		}
		return res;
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
