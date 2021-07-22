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
to solve this question there are 3 things we have to keep in mind
firstly we traverse and delete the key on the left side recursively if the key is lessthan the root.val
similarly we have to traverse via the right if key is greater than tree . vla
then if we have no left and right subtre we just delete n say root is null we found our val
the now if our root has a left child but nor right then we delete the predesecor a
else if the root has a right child we delete the successdor
the fxn takes o(log n) time and O(H) Space
*/
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root == null) return null;
        if(key > root.val) root.right = deleteNode(root.right, key);
        else if(key < root.val) root.left = deleteNode(root.left, key);
        else{
            if(root.left == null && root.right == null) root = null;
            
            else if( root.right!= null){
                root.val = Successor(root);
                root.right = deleteNode(root.right, root.val);
            } else {
                root.val =preDeccessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        
        return root;
    }
    
    public int Successor(TreeNode root){
        root = root.right;
        while(root.left != null){
            root = root.left;
        }
        return root.val;
    }
    
    public int preDeccessor(TreeNode root){
        root = root.left;
        while(root.right != null){
            root = root.right;
        }
        return root.val;
    }
}