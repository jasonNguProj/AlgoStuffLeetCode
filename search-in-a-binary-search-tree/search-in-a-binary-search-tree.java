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
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        
        TreeNode currentNode = root;
        
        while(currentNode != null && currentNode.val != val){
            if(currentNode.val < val){
                currentNode = currentNode.right;
            } else if (currentNode.val > val){
                currentNode = currentNode.left;
        }    
    }
         return currentNode;
    }
}