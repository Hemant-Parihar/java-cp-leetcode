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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        while(root.left != null || root.right != null) {
            List<Integer> list = new ArrayList<>();
            addLeaves(root, list);
            ans.add(list);
        }

        ans.add(new ArrayList<Integer>(List.of(root.val)) );
        return ans;
    }

    void addLeaves(TreeNode node, List<Integer> list) {
        if (node == null) return;

        if (node.left != null) {
            if (node.left.left == null && node.left.right == null) {
                list.add(node.left.val);
                node.left = null;
            }
        }

        if (node.right != null) {
            if (node.right.left == null && node.right.right == null) {
                list.add(node.right.val);
                node.right = null;
            }
        }

        if (node.left != null)
            addLeaves(node.left, list);
        
        if (node.right != null)
            addLeaves(node.right, list);
    }
}