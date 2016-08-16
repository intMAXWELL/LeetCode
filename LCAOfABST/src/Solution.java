import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 
 * @author Demon 2016.8.16
 * 
 *         Given a binary search tree (BST), find the lowest common ancestor
 *         (LCA) of two given nodes in the BST.
 * 
 *         According to the definition of LCA on Wikipedia: ¡°The lowest common
 *         ancestor is defined between two nodes v and w as the lowest node in T
 *         that has both v and w as descendants (where we allow a node to be a
 *         descendant of itself).¡±
 * 
 *         
 * 
 *         For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6.
 *         Another example is LCA of nodes 2 and 4 is 2, since a node can be a
 *         descendant of itself according to the LCA definition.
 *
 */
public class Solution {

	public static void main(String[] args) {

	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while ((root.val - p.val) * (root.val - q.val) > 0)
			root = p.val < root.val ? root.left : root.right;
		return root;
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
