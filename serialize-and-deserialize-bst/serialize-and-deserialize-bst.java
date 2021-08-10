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
to solve this qxn we need to take the tree value and conv 
into a string, given that the array is not inorder
we can essentially use inorder traversal and add into string builder

then to conv we will use a queue ds to effectively build the tree
and each string conv into integer and compare with int.min and int.maxvalue
we conv each val in the queue to an int and then poll them
we stop when the queue is empty.


*/
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    
    private void serialize(TreeNode root, StringBuilder sb){
        
        if(root == null) return;
        sb.append(root.val).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
    }
    
    private TreeNode deserialize(Queue<String> queue, int low, int high){
        if(queue.isEmpty()) return null;
        
        String s = queue.peek();
        int val = Integer.parseInt(s);
        if(val < low || val > high) return null;
         queue.poll();
        TreeNode root = new TreeNode(val);
       root.left = deserialize(queue, low, val);
        root.right = deserialize(queue, val, high);
        return root;    
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;