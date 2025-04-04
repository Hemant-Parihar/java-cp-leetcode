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
        int[] depth = new int[1001];
        int maxDepth = getDepth(root, depth);
        solve(root, 0, maxDepth, depth);
        return ans;
    }

    int getDepth(TreeNode node, int[] depth) {
        if (node == null) return 0;
        int left = getDepth(node.left, depth);
        int right = getDepth(node.right, depth);
        
        return depth[node.val] = 1 + Math.max(left, right);
    }

    int solve(TreeNode node, int d, int maxDepth, int[] depth) {
        if (node == null) return 0;
        d = d + 1;
        int left, right;
        left = right = 0;

        if (node.left != null) {
            left = solve(node.left, d, maxDepth, depth);
        }

        if (node.right != null) {
            right = solve(node.right, d, maxDepth, depth);
        }

        // System.out.println(node.val + " " + left + " " + right + " " + d + " " + maxDepth);

        if (left == right && ( (d + left) == maxDepth)) {
            ans = node;
        }

        return 1 + Math.max(left, right);
    }
}