/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        // Dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Move prev to the node just before the `left`th node
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // curr is the `left`-th node, the start of the segment to be reversed
        ListNode curr = prev.next;

        // Reverse the sublist from left to right
        for (int i = 0; i < right - left; i++) {
            ListNode nextNode = curr.next;
            // Remove nextNode from its place
            curr.next = nextNode.next;
            // Insert nextNode just after prev
            nextNode.next = prev.next;
            prev.next = nextNode;
        }

        // Return the (possibly new) head
        return dummy.next;
    }
}
