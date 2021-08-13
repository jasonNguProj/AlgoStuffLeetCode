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
to solve this problem we will use a minHeap
that will help up to merge all list together and sort them 
so we traverse via our listnode and then update position 
then we traverse via our heap while its size is greter than xero we add into our dummy 
then return our dummy.next 

O(N log k) time | O(k) space because of 

*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(ListNode head : lists){
            while(head != null){
                   minHeap.offer(head.val);
                head = head.next;
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while(minHeap.size() > 0){
            current.next = new ListNode(minHeap.poll());
            current = current.next;
        }
        return dummy.next;
    }
}