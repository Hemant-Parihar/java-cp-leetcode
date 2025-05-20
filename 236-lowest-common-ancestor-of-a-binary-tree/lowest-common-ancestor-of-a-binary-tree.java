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

    void get_parent(TreeNode node, HashMap<Integer, TreeNode> map) {
        if (node == null || (node.left == null && node.right == null)) return;
        if (node.left != null) {
            map.put(node.left.val, node);
        }
        if (node.right != null) {
            map.put(node.right.val, node);
        }
        get_parent(node.left, map);
        get_parent(node.right, map);
    }

    List<TreeNode> get_path(TreeNode node, HashMap<Integer, TreeNode> map) {
        List<TreeNode> list = new ArrayList<>();
        while(node != null) {
            list.add(node);
            node = map.get(node.val);
        }
        return list;
    }

    void printList(List<TreeNode> list) {
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).val + " ");
        }
        System.out.println();
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<Integer, TreeNode> parentMap = new HashMap<>();
        parentMap.put(root.val, null);

        get_parent(root, parentMap);

        List<TreeNode> list1 = get_path(p, parentMap);
        List<TreeNode> list2 = get_path(q, parentMap);

        // printList(list1);
        // printList(list2);

        int m = list1.size() - 1;
        int n = list2.size() - 1;

        while(m >= 0 && n >= 0) {
            if (list1.get(m) != list2.get(n)) {
                return list1.get(m + 1);
            }
            m--;
            n--;
        }

        return list1.get(m + 1);
    }
}