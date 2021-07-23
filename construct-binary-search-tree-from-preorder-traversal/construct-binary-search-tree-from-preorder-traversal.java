/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/*

to solve this question we will use recursion and compare 
each node btwn interger.min and integr.max
then we create a node and then increment to go to the next node
the call receursive on the left child
then call recursive on the right child

time will be O(N) because we traverse via every element in the array exactly once
space will be O(N) because of recursive stack, of how deep it goes 
*/
class Solution {
    int start = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return computeBST(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public TreeNode computeBST(int[] preorder, int min, int max){
        
        if(start == preorder.length) return null;
        
        int val = preorder[start];
        TreeNode root = null;
        if(val > min && val < max){
             root = new TreeNode(val);
            start++;
            root.left = computeBST(preorder, min, val);
            root.right = computeBST(preorder, val, max);
        }
        
        return root;
    }
}