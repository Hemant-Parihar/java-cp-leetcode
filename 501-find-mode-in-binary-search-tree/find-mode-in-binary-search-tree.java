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
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        solve(root, map);
        int max = 0;
        int count = 0;
        for(Integer val : map.values()) {
            if (val > max) {
                max = val;
                count = 1;
            } else if (val == max) {
                count++;
            }
        }
        int[] ans = new int[count];
        int i = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                ans[i++] = entry.getKey();
            }
        }
        return ans;
    }

    void solve(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) return;
        int val = root.val;
        map.put(val, map.getOrDefault(val, 0) + 1);

        solve(root.left, map);
        solve(root.right, map);
    }
}