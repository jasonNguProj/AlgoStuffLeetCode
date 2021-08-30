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
/*to optimaly solve this problem we'll use bit manipulation to check if our path
is palindromic, so inorder for a bit string to be palindromic the bit string should be 
a power of 2, exampl, 100, so basically or qxn has reduced to checking if our bit a palindrome
then so we shift each value and take the xor , the and the value by its value - 1
if valu AND value - 1 == 000 then its a palindrome, then we want to call our recursive 
fxn on the left and right in preorder dfs recursive manner 
pseudo- palindromic means the path 211 can be re arranged to 121 to become a palindrome
*/
class Solution {
    int count = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(root, 0);
        return count;
    }
    
    public void dfs(TreeNode root, int path){
        
        if(root == null) return;
        int leftShift = (1 << root.val);
        
        path = path ^ leftShift;
        
        if(root.left == null && root.right == null){
            if((path & path - 1) == 0 ) {
                count++;
            }
        }
        
        dfs(root.left, path);
         dfs(root.right, path);
    }
}