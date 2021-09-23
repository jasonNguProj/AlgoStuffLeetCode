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
to solve this question we will use dfs recursion and traverse via the left and right node
create a good node variable that we will increment whenever the present rootValue
is greater or equal to the previous rootvalue then , 
we take the max btw the prev and present max value to rep our new max value,
then recursively call the fxn on the left and right sub tree pasiing in therie values
so we will do it in 2 diff fxn , the dfs fxn and the main fxn and initialze the running val to Integer.MIN_VALUE
and also initialize the goodnode variable as a class memebr on the global level and in the end return the goodNodes

Time is O(N) because you trav the entire tree to find goo nodes
O(D) space cus of recursive stack  of d depth of hw far the recursive stack goes deep.
*/


class Solution {
    int goodNode =0;
    public int goodNodes(TreeNode root) {
       
        dfs(root, Integer.MIN_VALUE);
        return goodNode;
        
    }
    
    private void dfs(TreeNode root, int max){
        
        if(root == null) return;
        
        if(root.val >= max){
            goodNode++;
        }
          max = Math.max(root.val, max);
        dfs(root.left, max);
        dfs(root.right, max);
    }
    
    
}