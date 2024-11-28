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

    HashMap<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) return 0;

        if (map.containsKey(root)) return map.get(root);

        int val1 = root.val;
        int val2 = 0;

        if (root.left != null) {
            val2 += rob(root.left);

            val1 += rob(root.left.left) + rob(root.left.right);
        }

        if (root.right != null) {
            val2 += rob(root.right);

            val1 += rob(root.right.left) + rob(root.right.right);
        }

        map.put(root, Math.max(val1, val2));
        return Math.max(val1, val2);
    }
}