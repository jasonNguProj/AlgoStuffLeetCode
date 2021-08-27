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
point to note when u are trying to find diameter or height or length always take 
into acc that at every node you are computing left and right and 
trying to get the max and so the formula will always be 1 + (math.max(left, right))
rather than thinking of adding 1 at each step you simply do 1 + Math.max(left, right)

so the algorithm to solve this question is to initial a global variable to control the recurssion
the 2 fxn one to cals height and the other to return if its a valid balanced tree or not
so time is O(log n) on average beacuse we might not access the whole tree when we discover it is unbalanced 
O(N) in the worst case if we traverse the whole tree
and O(N) space in the worst case for a skewed tree and o(log n) in the av case for a balanced tree
*/
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(Math.abs(computeHeight(root.left) - computeHeight(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int computeHeight(TreeNode root){
        if(root == null) return 0;
        
        int left =  computeHeight(root.left);
        int right = computeHeight(root.right);
        
        return 1 + Math.max(left, right);
    }
}