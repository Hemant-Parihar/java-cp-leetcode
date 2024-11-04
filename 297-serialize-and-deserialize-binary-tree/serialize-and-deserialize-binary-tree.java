/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node == null) {
                    sb.append("n,");
                } else {
                    sb.append(Integer.toString(node.val) );
                    sb.append(",");
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] items = data.split(",");
        int n = items.length;
        if (items[0].equals("n")) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode( Integer.parseInt(items[0]) );
        queue.add(root);
        int i = 1;
        while(!queue.isEmpty() && i < n) {
            TreeNode node = queue.remove();
            if (!items[i].equals("n")) {
                TreeNode newNode = new TreeNode( Integer.parseInt(items[i] ));
                node.left = newNode;
                queue.add(newNode);
            }
            i++;
            if (!items[i].equals("n")) {
                TreeNode newNode = new TreeNode( Integer.parseInt(items[i] ));
                node.right = newNode;
                queue.add(newNode);
            }
            i++;
        }
        
        return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));