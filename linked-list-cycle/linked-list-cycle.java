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
to check if a list haas a cycle is by using the fast and slow ptr
wher slow moves by 1 and fast moves by two if evr the slow and fast meets hence there is a cycle 

*/
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        ListNode fast = head;
         ListNode slow = head;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
    return false;
    }
}