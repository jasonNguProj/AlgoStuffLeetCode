/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/*
to solve this problem , we will set two pointers one that moves at rate one and another that moves
at rate 2, if ever both pointers meet there will be a cycle

*/
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        ListNode slow = head;
         ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) return true;
        }
        
        return false;
    }
}