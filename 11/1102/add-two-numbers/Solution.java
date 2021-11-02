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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode newHead = new ListNode();
        ListNode newHeadPtr = newHead;
        
        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            
            int sum = val1 + val2 + carry;
            int newVal = sum % 10;
            
            carry = (int) Math.floor(sum / 10);
            
            if (l1 != null) {
                l1.val = newVal;
                newHeadPtr.next = l1;
            } else {
                l2.val = newVal;
                newHeadPtr.next = l2;
            }
            newHeadPtr = newHeadPtr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        if (carry > 0) {
            newHeadPtr.next = new ListNode(carry);
        }
        return newHead.next;
    }
}
