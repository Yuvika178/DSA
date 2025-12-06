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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;  // last node before the duplicates group
        ListNode curr = head;   // current node

        while (curr != null) {
            // check if current node is duplicate
            if (curr.next != null && curr.val == curr.next.val) {

                // move curr ahead until duplicates end
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }

                // skip all duplicates
                prev.next = curr.next;
            } else {
                // no duplicate → move prev
                prev = prev.next;
            }

            // move curr forward
            curr = curr.next;
        }

        return dummy.next;
    }
}
