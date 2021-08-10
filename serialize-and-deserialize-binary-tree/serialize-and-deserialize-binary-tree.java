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
to solve this question we will do same thing just as for bst 
the only diff will be to add # to show the end of the tree

*/
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    
    private void serialize(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("#").append(',');
        } else{
              sb.append(root.val).append(",");
            serialize(root.left, sb);
         serialize(root.right, sb);
        }
      
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if (data.length() == 0) return null;
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(queue);
    }
    
    private TreeNode deserialize(Queue<String> queue){
        String s =queue.poll();
        if(s.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));