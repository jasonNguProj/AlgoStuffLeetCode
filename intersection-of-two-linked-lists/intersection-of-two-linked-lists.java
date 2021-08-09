/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/*

to solve this qxn we will use the 2 ptr approach
if the lengths are same we move them 1 value to the next
but when the lengths are diff , and then ptr a has reached null we reassign pointer a to head b 
and vica versa

*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode p1 = headA;
        ListNode p2 = headB;
        while(p1 != p2){
            p1 = p1 == null ? headB : p1.next;
             p2 = p2 == null ? headA : p2.next;
        }
        return p2;
        
    }
}