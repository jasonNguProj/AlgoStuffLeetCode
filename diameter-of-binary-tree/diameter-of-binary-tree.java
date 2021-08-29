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
to solve this problem we need the height which will give us
the max btw left and right, and then from there we use the information
from the height to update the daiameter
so when you are at say 4   
                       | 2
                       
 int the above notice that the left is null and the right is 1
 so in the recursion stack we return the max(l, r) which is essentialy 
 the right then add 1 as the level
 and then here the diameter is 2
 so basically at each level while going up 
 it need information from the computed height , then we take 
 the max of the 2 leaf and add 1(the 1 is for the parent)
*/
class Solution {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        computeHeight(root);
        return diameter;
    }
    
    private int computeHeight(TreeNode root){
        if(root == null) return 0;
        
        int left = computeHeight(root.left);
        int right = computeHeight(root.right);
        
        diameter = Math.max(diameter, left + right);
        
        return Math.max(left, right) + 1;
    }
}