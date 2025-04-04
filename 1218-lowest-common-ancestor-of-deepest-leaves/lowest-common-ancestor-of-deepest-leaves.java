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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        TreeNode[] parents = new TreeNode[1001];
        int max_depth = getDepth(root, parents);
        
        List<TreeNode> list = new ArrayList<>();

        getAllDeepestLeaves(root, list, 0, max_depth);

        // for(int i = 0; i < list.size(); i++) {
        //     System.out.println(list.get(i).val);
        // }

        while(list.size() > 1) {
            HashSet<Integer> newSet = new HashSet<>();
            List<TreeNode> newList = new ArrayList<>();
            for(TreeNode node: list) {
                if (node == root) return node;
                int val = node.val;
                if (!newSet.contains(parents[val].val)) {
                    newSet.add(parents[val].val);
                    newList.add(parents[val]);
                }
            }
            list = newList;

            // for(int i = 0; i < list.size(); i++) {
            //     System.out.println(list.get(i).val);
            // }
            // System.out.println("==================");
        }


        return list.get(0);
    }

    int getDepth(TreeNode node, TreeNode[] parents) {
        if (node == null) return 0;

        if (node.left != null) {
            parents[node.left.val] = node;
        }

        if (node.right != null) {
            parents[node.right.val] = node;
        }

        int left = getDepth(node.left, parents);
        int right = getDepth(node.right, parents);
        return 1 + Math.max(left, right);
    }

    void getAllDeepestLeaves(TreeNode node, List<TreeNode> list, int d, int max_depth) {
        if (node == null) return;
        d = d + 1;
        if (max_depth == d) {
            list.add(node);
            return;
        }
        getAllDeepestLeaves(node.left, list, d, max_depth);
        getAllDeepestLeaves(node.right, list, d, max_depth);
    }
}