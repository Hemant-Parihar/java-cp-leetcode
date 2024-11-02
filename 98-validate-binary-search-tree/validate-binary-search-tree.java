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

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left != null) {
            int left = maxValue(root.left);
            if (left >= root.val) return false;
        }
        if (root.right != null) {
            int right = minValue(root.right);
            if (right <= root.val) return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    int maxValue(TreeNode node) {
        int val = node.val;
        if (node.left != null) {
            val = Math.max(val, maxValue(node.left));
        }
        if (node.right != null) {
            val = Math.max(val, maxValue(node.right));
        }
        return val;
    }

        int minValue(TreeNode node) {
        int val = node.val;
        if (node.left != null) {
            val = Math.min(val, minValue(node.left));
        }
        if (node.right != null) {
            val = Math.min(val, minValue(node.right));
        }
        return val;
    }

}