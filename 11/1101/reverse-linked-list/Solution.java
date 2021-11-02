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
    public ListNode reverseList(ListNode head) {
        String temp = "";
        if(head == null) return null;
        while(head != null){
            temp += head.val + ",";
            head = head.next;
        }
        temp = temp.substring(0, temp.length()-1);
        
        String[] str = temp.split(",");
        
        if(str == null) return null;
        ListNode newTemp = new ListNode(Integer.valueOf(str[str.length-1]));
        
        ListNode newHead = newTemp;
        ListNode newTail = newTemp;
        
        for(int i=str.length-2; i>=0; i--){ 
            newTail.next = new ListNode(Integer.valueOf(str[i]));
            newTail = newTail.next;
            System.out.println(newTail.val);
        }
        return newHead;
    }
}
