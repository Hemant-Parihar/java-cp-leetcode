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
class BSTIterator {

    Stack<TreeNode> stack;
    TreeNode ptr;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        ptr = root;
    }
    
    public int next() {
        if (ptr.left != null) {
            stack.push(ptr);
            ptr = ptr.left;
            return next();
        }
        int val = ptr.val;
        if (ptr.right != null) {
            ptr = ptr.right;
        } else {
            if (!stack.isEmpty()) {
                ptr = stack.pop();
                ptr.left = null;
            } else {
                ptr = null;
            }
        }
        return val;
    }
    
    public boolean hasNext() {
        if (stack.isEmpty() && ptr == null) return false;
        return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */