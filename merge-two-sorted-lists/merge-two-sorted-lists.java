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
to solve this question we will crete a dummy node and move our pointers
to add our values into the dummy node
and in the end return our dummy.next
while moving via the list we check which is bigger and assign in our dummy
then after the while it can happen that 1 list is bigger than the other 
so we need to check that as well

*/
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while(l1 != null && l2 != null){
            if(l2.val >= l1.val){
                current.next = l1;
                l1 = l1.next;
            } else{
                 current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        
        
        if(l1 != null){
            current.next = l1;
        } else{
            current.next = l2;
        }
        return dummy.next;
    }
}