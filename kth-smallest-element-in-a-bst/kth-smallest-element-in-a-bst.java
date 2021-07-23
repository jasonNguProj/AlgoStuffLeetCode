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
to solve this problem we frist traverse in such a way that the tree nodes are inorder
then we traverse tree in dfs inorder traversal
then  now the k smallest elemnt will just be the k-1 term of the arr
*/
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        
        List<Integer> smallest = traverse(root, new ArrayList<Integer>());
        return smallest.get(k - 1);
    }
    
    public List<Integer> traverse(TreeNode root, List<Integer> arr){
        if (root == null) return arr;
        
        if(root.left != null) traverse(root.left, arr);
        arr.add(root.val);
        if(root.right != null) traverse(root.right, arr);
        return arr;
    }
}