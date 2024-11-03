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
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        return solve(root, k);
    }

    int solve(TreeNode node, int k) {
        if (node == null) return -1;
        int val = solve(node.left, k);
        if (val != -1) return val;
        count++;
        // System.out.println(count + " " + node.val);
        if (count == k) return node.val;
        return solve(node.right, k);
    }
}