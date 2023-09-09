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

public class SuperNode {
    TreeNode node;
    int leftHeight;
    int rightHeight;
    TreeNode parent;
    char pos;
    SuperNode(TreeNode node, int left, int right, TreeNode parent, char pos) {
        this.node = node;
        this.leftHeight = left;
        this.rightHeight = right;
        this.parent = parent;
        this.pos = pos;
    }
    @Override
    public String toString() {
        if (parent == null)
            return node.val + " " + leftHeight + " " + rightHeight + " " + parent + " " + pos;
        else 
            return node.val + " " + leftHeight + " " + rightHeight + " " + parent.val + " " + pos;
    }   
}

class Solution {
    public int[] treeQueries(TreeNode root, int[] queries) {
        int n = findN(root);
        SuperNode[] listOfSuperNode = new SuperNode[n + 1];
        SuperNode rootSuperNode = new SuperNode(root, 0, 0, null, 'X');
        listOfSuperNode[root.val] = rootSuperNode;
        createAllSuperNodes(root, listOfSuperNode);

        // System.out.println(Arrays.toString(listOfSuperNode));

        int maxHeight = Math.max(rootSuperNode.leftHeight, rootSuperNode.rightHeight);
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            ans[i] = findHeightAfterRemoval(queries[i], listOfSuperNode, maxHeight);
        }

        return ans;
    }

    int findHeightAfterRemoval(int val, SuperNode[] listOfSuperNode, int maxHeight) {
        SuperNode superNode = listOfSuperNode[val];
        TreeNode node = superNode.parent;
        SuperNode parent = listOfSuperNode[node.val];
        char pos = superNode.pos;
        int up = 0;
        int ans = 0;

        while(parent != null) {
            if (pos == 'L') {
                ans = Math.max(ans, parent.rightHeight);
            } else if (pos == 'R') {
                ans = Math.max(ans, parent.leftHeight);
            }
            TreeNode newNode = parent.parent;

            if (ans == Math.max(parent.leftHeight, parent.rightHeight)) {
                return maxHeight;
            }

            if (newNode == null) {
                break;
            }
            SuperNode newParent = listOfSuperNode[newNode.val];
            pos = parent.pos;

            parent = newParent;

            ans++;
        }
        return ans;
    }

    int createAllSuperNodes(TreeNode root, SuperNode[] listOfSuperNode) {
        if (root == null) return 0;
        int leftHeight, rightHeight;
        leftHeight = rightHeight = 0;
        if (root.left != null) {
            SuperNode leftSuperNode = new SuperNode(root.left, 0, 0, root, 'L');
            listOfSuperNode[root.left.val] = leftSuperNode;
            leftHeight = createAllSuperNodes(root.left, listOfSuperNode);
        }

        if (root.right != null) {
            SuperNode rightSuperNode = new SuperNode(root.right, 0, 0, root, 'R');
            listOfSuperNode[root.right.val] = rightSuperNode;
            rightHeight = createAllSuperNodes(root.right, listOfSuperNode);
        }

        listOfSuperNode[root.val].leftHeight = leftHeight;
        listOfSuperNode[root.val].rightHeight = rightHeight;

        return 1 + Math.max(leftHeight, rightHeight);
    }

    int findN(TreeNode root) {
        if (root == null) return 0;
        int ans = root.val;
        ans = Math.max(ans, findN(root.left));
        ans = Math.max(ans, findN(root.right));
        return ans;
    }
}