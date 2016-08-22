/**
 * 
 * @author Demon 2016.8.22
 * 
 *         Merge two sorted linked lists and return it as a new list. The new
 *         list should be made by splicing together the nodes of the first two
 *         lists.
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode l1 = solution.new ListNode(1);
		ListNode l1Tmp = l1;
		for (int i = 3; i <= 9; i += 2, l1Tmp = l1Tmp.next) {
			l1Tmp.next = solution.new ListNode(i);
		}
		ListNode l2 = solution.new ListNode(2);
		ListNode l2Tmp = l2;
		for (int i = 4; i <= 4; i += 2, l2Tmp = l2Tmp.next) {
			l2Tmp.next = solution.new ListNode(i);
		}
		ListNode newListNode = solution.mergeTwoLists(l1, l2);
		for (; newListNode != null; newListNode = newListNode.next)
			System.out.print(newListNode.val + "->");
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode head = l1.val < l2.val ? l1 : l2;
		ListNode tmp = head;
		ListNode node1 = head.next;
		ListNode node2 = head == l1 ? l2 : l1;
		while (node1 != null && node2 != null) {
			if (node1.val < node2.val) {
				tmp.next = node1;
				node1 = node1.next;
			} else {
				tmp.next = node2;
				node2 = node2.next;
			}
			tmp = tmp.next;
		}
		if (node1 == null && node2 != null)
			tmp.next = node2;
		if (node2 == null && node1 != null)
			tmp.next = node1;
		return head;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
