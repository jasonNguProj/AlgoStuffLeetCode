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
time complexity is O(N) | and space is O(log n ) in the average case and O(N) in the worst case
to solve this question we will recurse on the left and right subtree updating the left parent as root
and the further left gparent as the parent of our previous left
*/
class Solution {
    int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        
        computeSum(root, null, null);
        return sum;
    }
    
    public void computeSum(TreeNode root, TreeNode parent, TreeNode gParent){
        
        if(root == null) return;
        
        if(gParent != null && gParent.val % 2 == 0){
            sum += root.val;
        }
        
        computeSum(root.left, root, parent);
         computeSum(root.right, root, parent);
    }
}