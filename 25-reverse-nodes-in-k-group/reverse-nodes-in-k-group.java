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
 * LeetCode-ready solution.
 * Assumes the usual ListNode class:
 *   public class ListNode {
 *       int val;
 *       ListNode next;
 *       ListNode() {}
 *       ListNode(int val) { this.val = val; }
 *       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 *   }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (true) {
            // find kth node from prev
            ListNode kth = prev;
            for (int i = 0; i < k; i++) {
                kth = kth.next;
                if (kth == null) return dummy.next; // not enough nodes
            }

            // mark start and next
            ListNode start = prev.next;
            ListNode next = kth.next;

            // reverse [start .. kth]
            ListNode p = next;
            ListNode cur = start;
            while (cur != next) {
                ListNode tmp = cur.next;
                cur.next = p;
                p = cur;
                cur = tmp;
            }

            // link prev to new head (kth)
            prev.next = p;
            // move prev to tail of this group (old start)
            prev = start;
        }
    }
}
