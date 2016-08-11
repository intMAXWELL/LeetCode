/**
 * 
 * @author Demon 2016.8.11
 * 
 *         Given a linked list, determine if it has a cycle in it.
 * 
 *         Follow up: Can you solve it without using extra space?
 *
 */
public class Solution {

	public static void main(String[] args) {

	}
	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;
		ListNode fast = head, slow = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}
		return false;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
