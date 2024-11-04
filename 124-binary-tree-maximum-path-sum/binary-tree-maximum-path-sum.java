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

    int diameter = -10000;
    public int maxPathSum(TreeNode root) {
        solve(root);
        return diameter;
    }

    int solve(TreeNode root) {
        if (root == null) return 0;
        int left = solve(root.left);
        int right = solve(root.right);

        diameter = Math.max(left + right + root.val, diameter);
        diameter = Math.max(left + root.val, diameter);
        diameter = Math.max(right + root.val, diameter);
        diameter = Math.max(root.val, diameter);

        int val = root.val;
        return Math.max(val, root.val + Math.max(left, right));
    }
}