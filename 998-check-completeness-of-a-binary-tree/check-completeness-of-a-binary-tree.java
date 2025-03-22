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
class Solution {
    public boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        boolean found_null = false;
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.right != null && node.left == null) {
                return false;
            }
            if (found_null == false && (node.left == null || node.right == null)) {
                found_null = true;
            } else if (found_null == true && (node.left != null || node.right != null)) {
                return false;
            }
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        return true;
    }
}