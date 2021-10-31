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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n == 1 && head.next == null) { 
            return head.next;
        }
        
        int count = 0;
        
        ListNode first = head, second = head;
        if(n == 1 && head.next == null) { 
            return head.next;
        }
        
        while(first != null){
            first = first.next;
           
            if(count > n){
                second = second.next;
            }
            count++;            
        }
        if(count == n){
            return head.next;
        }
        if(second.next != null) {
            second.next = second.next.next;
        }
        
        return head;
    }
}
