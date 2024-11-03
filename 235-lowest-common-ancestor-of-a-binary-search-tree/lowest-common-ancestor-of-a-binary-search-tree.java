/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    boolean found = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> listP = new ArrayList<>();
        find(root, p, listP);

        // for(TreeNode node : listP) {
        //     System.out.print(node.val + " ");
        // }
        // System.out.println();

        found = false;
        List<TreeNode> listQ = new ArrayList<>();
        find(root, q, listQ);
        
        // for(TreeNode node : listQ) {
        //     System.out.print(node.val + " ");
        // }
        // System.out.println();


        TreeNode ans = null;
        int i = 0;

        while((listP.size() > (i) && listQ.size() > (i)) && listP.get(i) == listQ.get(i)) {
            ans = listP.get(i);
            i++;
        }
        return ans;
    }

    void find(TreeNode root, TreeNode node, List<TreeNode> list) {
        if (root == null) return;
        list.add(root);
        if (root.val == node.val) {
            found = true;
            return;
        }
        find(root.left, node, list);
        if (found == false)
            find(root.right, node, list);
        if (found == false) {
            list.remove(list.size() - 1);
        }
    }
}