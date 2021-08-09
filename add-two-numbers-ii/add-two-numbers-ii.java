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

/*
to solve this question we need to reverse unlike the first version where it is already reversed
this one we need to reverse and do a few checks
*/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode c1 = reverse(l1);
        ListNode c2 = reverse(l2);
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        
        while(c1 != null || c2 != null || carry != 0){
            
            carry = carry + (c1 != null ? c1.val : 0) + (c2 != null ? c2.val : 0);
                
                current.next = new ListNode(carry%10);
                 current = current.next;
                    carry = carry / 10;
            
                if(c1 != null) c1 = c1.next;
             if(c2 != null) c2 =c2.next;
        }
        return reverse(dummy.next);
        
    }
    
    public ListNode reverse(ListNode head){
        ListNode next = null;
        ListNode prev = null;
        while(head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}