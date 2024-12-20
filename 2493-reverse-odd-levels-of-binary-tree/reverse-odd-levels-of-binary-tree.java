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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> values = new ArrayList<>();
            Queue<TreeNode> tempQueue = new LinkedList<>();

            for(int i = 0; i < size; i++) {
                if ( (level % 2) == 0) {
                    TreeNode node = queue.poll();
                    if (node.left == null) continue;
                    values.add(node.left.val);
                    values.add(node.right.val);
                    tempQueue.add(node.left);
                    tempQueue.add(node.right);
                } else {
                    TreeNode node = queue.poll();
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
            }

            if (values.size() > 0) {
                Collections.reverse(values);
                for(int i = 0; i < values.size(); i++) {
                    TreeNode node = tempQueue.poll();
                    node.val = values.get(i);
                    queue.add(node);
                }
            }

            level++;
        }

        return root;
    }
}