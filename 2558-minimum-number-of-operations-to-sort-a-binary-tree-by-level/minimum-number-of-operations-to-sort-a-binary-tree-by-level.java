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
    public int minimumOperations(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int ans = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            int[] arr = new int[size];
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                arr[i] = node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            ans += countSwap(arr);
        }

        return ans;
    }

    public int countSwap(int[] arr) {
        int n = arr.length;
        int[] target = arr.clone();
        Arrays.sort(target);

        HashMap<Integer, Integer> posMap = new HashMap<>();

        for(int i = 0; i < n; i++) {
            posMap.put(arr[i], i);
        }

        int count = 0;
        for(int i = 0; i < n; i++) {
            if (arr[i] != target[i]) {
                count++;

                // swap the pos.
                int tarPos = posMap.get(target[i]);
                posMap.put(arr[i], tarPos);
                arr[tarPos] = arr[i];
            }
        }
        return count;
    }
}