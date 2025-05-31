/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    Node ret = null;
    public Node cloneGraph(Node node) {

        HashMap<Integer, Node> map = new HashMap<>();
        HashMap<Integer, Node> ans = new HashMap<>();
        dfs(node, map, ans);

        return ret;
    }

    void dfs(Node node, HashMap<Integer, Node> map, HashMap<Integer, Node> ans) {
        if (node == null || map.containsKey(node.val)) return;

        List<Node> list = node.neighbors;
        map.put(node.val, node);

        Node newNode = null;
        if (!ans.containsKey(node.val)) {
            newNode = new Node(node.val);
            if (node.val == 1) {
                ret = newNode;
            }
        } else {
            newNode = ans.get(node.val);
        }

        ans.put(node.val, newNode);
        

        for(int i = 0; i < list.size(); i++) {
            int val = list.get(i).val;
            if (!ans.containsKey(val)) {
                Node childNode = new Node(val);
                if (val == 1) {
                    ret = childNode;
                }
                newNode.neighbors.add(childNode);
                ans.put(val, childNode);
            } else {
                newNode.neighbors.add(ans.get(val));
            }
            dfs(list.get(i), map, ans);
        }
    }
}