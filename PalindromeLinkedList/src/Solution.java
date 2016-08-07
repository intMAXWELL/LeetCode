/**
 * 
 * @author Demon 2016.8.7
 * 
 *         Given a singly linked list, determine if it is a palindrome.
 * 
 *         Follow up: Could you do it in O(n) time and O(1) space?
 *
 */

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode node = solution.new ListNode(1);
		node.next = solution.new ListNode(2);
		System.out.println(solution.isPalindrome(node));
	}
	
	/*
	 * Reverse half linked list
	 * Time: O(n) , just traverse the linked list 1ms
	 * Space: O(1) , just use some tmp value to record some nodes
	 */
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;
		ListNode fast = head, slow = head, currentHead = head, preHead = head;
		// Reverse  the first half
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			currentHead = slow.next;
			slow.next = slow.next.next;
			currentHead.next = preHead;
			preHead = currentHead;
		}
		// The List has odd nodes
		if (fast.next == null) {
			preHead = preHead.next;
		}
		slow = slow.next; // Mid start
		// Compare the first half and the second half
		while (slow != null) {
			if (slow.val != preHead.val)
				return false;
			preHead = preHead.next;
			slow = slow.next;
		}
		return true;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
