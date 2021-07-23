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

to solve this question we will get the middle and set it as our root
recursively call fx on right and set boundaries of mid + 1 as start
recursively call fxn on left and set boundaries of mid - 1 as end
and then the fxn should stop whenever start is greater than end
*/
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        
        return computeBst(nums, 0, nums.length - 1);
    }
    
    public TreeNode computeBst(int[] nums, int start, int end){
       if(start > end) return null;
         int middle = start + (end - start)/2;
        int valToInsert = nums[middle];
        TreeNode root = new TreeNode(valToInsert);
        root.left = computeBst(nums, start, middle - 1);
        root.right = computeBst(nums, middle + 1, end);
        return root;
       
    }
}