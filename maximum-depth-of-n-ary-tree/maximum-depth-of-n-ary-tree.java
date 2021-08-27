/*
// Definition for a Node.
3
*/

class Solution {
    public int maxDepth(Node root) {
        
        if(root == null) return 0;
        int depth =0;
        for(Node child : root.children){
            depth = Math.max(depth, maxDepth(child));
        }
        return depth + 1;
        
    }
}