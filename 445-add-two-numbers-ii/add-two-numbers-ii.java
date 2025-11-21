/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// Definition for singly-linked list node (LeetCode-style).
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
*/
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        java.util.Stack<Integer> s1 = new java.util.Stack<>();
        java.util.Stack<Integer> s2 = new java.util.Stack<>();
        
        // Push all digits to stacks
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        int carry = 0;
        ListNode head = null; // result head
        // Pop and add until both stacks empty and no carry
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int a = s1.isEmpty() ? 0 : s1.pop();
            int b = s2.isEmpty() ? 0 : s2.pop();
            int sum = a + b + carry;
            carry = sum / 10;
            int digit = sum % 10;
            
            // Insert new digit at front
            ListNode node = new ListNode(digit);
            node.next = head;
            head = node;
        }
        return head;
    }
}


        
    
        
           

        
        
    
