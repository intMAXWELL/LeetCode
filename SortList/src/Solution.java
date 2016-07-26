/**
 * 
 * @author Demon
 *
 *         Sort a linked list in O(n log n) time using constant space
 *         complexity.
 */
public class Solution {

	public static void main(String[] args) {
		
	}
	
	/*
	 * About time: A(n) = 2 * A(n/2) + O(n)
	 * Merge sort takes O(n)
	 */
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		// Step 1: Cut the list into half.
		ListNode pre = null, slow = head, fast = head;
		while (fast != null && fast.next != null) {
			pre = slow;
			fast = fast.next.next;
			slow = slow.next;
		}

		pre.next = null; // Into half

		// Step 2: Sort each half.
		ListNode list1 = sortList(head);
		ListNode list2 = sortList(slow);

		// Step 3: Merge.
		return merge(list1, list2);
	}

	public ListNode merge(ListNode l1, ListNode l2) {
		// Use resNode to record the head.
		ListNode tmpHead = new ListNode(-1), resNode = tmpHead;

		while (l1 != null && l2 != null) { // Merge sort
			if (l1.val < l2.val) {
				tmpHead.next = l1;
				l1 = l1.next;
			} else {
				tmpHead.next = l2;
				l2 = l2.next;
			}
			tmpHead = tmpHead.next;
		}

		if (l1 != null) { // l1 has tail, merge it to the tail!
			tmpHead.next = l1;
		}

		if (l2 != null) { // l2 has tail, merge it to the tail!
			tmpHead.next = l2;
		}

		return resNode.next;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int v) {
			this.val = v;
		}
	}

}
