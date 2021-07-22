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
to solve this question iteartively
we will trav the bst following bst property
when val is greater root. value also whne root.right is null
then we insert the new node into right 
else the root will just be root. right
and we do thesame thing for the left subtree
*/
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode currentNode = root;
        while(currentNode != null){
            if(val > currentNode.val){
                if(currentNode.right == null){
                    currentNode.right = new TreeNode(val);
                    return root;
                } else {
                    currentNode = currentNode.right;
                }
            }
            else {
                if( val < currentNode.val){
                    if(currentNode.left == null){
                        currentNode.left = new TreeNode(val);
                        return root;
                    } else {
                        currentNode = currentNode.left;
                    }
                }
            }
        }
        return new TreeNode(val);
    }
}