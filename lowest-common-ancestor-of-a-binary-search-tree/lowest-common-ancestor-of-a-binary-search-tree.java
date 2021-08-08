/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
to solve this proble we can use bst property to help us
so if both p n q are greater than parent meaning our node is in the right
if poth p n q are less than parent meaning its in the left tree
else we found our node and return out value

*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
    int pVal = p.val, qVal = q.val;
        while(root != null){
           int rootVal = root.val;
            
            if(pVal > rootVal && qVal > rootVal){
                root= root.right;
            } else if (pVal < rootVal && qVal < rootVal){
                root = root.left;
            }else {
                return root;
            }
        }
        return null;
    }
}