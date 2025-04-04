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

    TreeNode ans = null;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int maxDepth = getDepth(root);
        solve(root, 0, maxDepth);
        return ans;
    }

    int getDepth(TreeNode node) {
        if (node == null) return 0;
        int left = getDepth(node.left);
        int right = getDepth(node.right);
        return 1 + Math.max(left, right);
    }

    int solve(TreeNode node, int d, int maxDepth) {
        if (node == null) return 0;
        d = d + 1;
        int left, right;
        left = right = 0;

        if (node.left != null) {
            left = solve(node.left, d, maxDepth);
        }

        if (node.right != null) {
            right = solve(node.right, d, maxDepth);
        }

        if (left == right && ( (d + left) == maxDepth)) {
            ans = node;
        }

        return 1 + Math.max(left, right);
    }
}