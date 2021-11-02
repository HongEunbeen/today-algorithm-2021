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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode sortedHead = null;
        ListNode sortedTail = null;
        if(l1.val <= l2.val)
        {
            sortedHead = l1;
            sortedTail = l1;
            l1 = l1.next;
        }
        else if(l2.val < l1.val)
        {
            sortedHead = l2;
            sortedTail = l2;
            l2 = l2.next;
        }
        while(l1 != null && l2 != null)
        {
                if(l1.val <= l2.val)
                {
                    sortedTail.next = l1;
                    l1 = l1.next;
                    sortedTail = sortedTail.next;
                }
                else if(l2.val < l1.val)
                {
                    sortedTail.next = l2;
                    l2 = l2.next;
                    sortedTail = sortedTail.next;
                }
        }
        while(l1 != null)
        {
            sortedTail.next = l1;
            l1 = l1.next;
            sortedTail = sortedTail.next;
        }
        while(l2 != null)
        {
            sortedTail.next = l2;
            l2 = l2.next;
            sortedTail = sortedTail.next;
        }
        return sortedHead;
    }
}
