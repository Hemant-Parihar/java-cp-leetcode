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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return build(preorder, inorder, 0, n-1, 0, n-1);
    }

    TreeNode build(int[] preorder, int[] inorder, int pre_i, int pre_j, int ord_i, int ord_j) {
        if (pre_j < pre_i || ord_j < ord_i) return null;

        // System.out.println("pre_i: " + pre_i + " pre_j : " + pre_j);
        // System.out.println("ord_i: " + ord_i + " ord_j : " + ord_j);

        TreeNode root = new TreeNode(preorder[pre_i], null, null);
        if (pre_i == pre_j) {
            // this means only 1 element.
            return root;
        }

        int mid = -1;
        for(int i = ord_i; i <= ord_j; i++) {
            if (inorder[i] == root.val) {
                mid = i;
                break;
            }
        }

        int count = mid - ord_i;

        root.left = build(preorder, inorder, pre_i + 1, pre_i + count, ord_i, mid - 1);
        root.right = build(preorder, inorder, pre_i + count + 1, pre_j, mid + 1, ord_j);

        return root;
    }
}