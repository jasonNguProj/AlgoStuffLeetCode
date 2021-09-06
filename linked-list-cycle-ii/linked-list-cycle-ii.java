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


we need to understand that this question is asking us to return the beginig
where the cycle starts, inorder to find where the cycle begins
we need to first find the cycle and then we rest the slow ptr to the head, 
and do another loop for slow and fast moving 1 step, whenever they meet that value will be the start


*/



public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next; 
            if(slow == fast) {
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
        
    }
    
    
}