class Solution {

    class Node {
        char val;
        Node[] next;
        int count;
        Node(char val) {
            this.val = val;
            this.next = new Node[26];
            this.count = 1;
        }
    }

    void add_to_trie(String s, int i, Node node) {
        if (i == s.length()) return;

        if (node.next[s.charAt(i) - 'a'] == null) {
            node.next[s.charAt(i) - 'a'] = new Node(s.charAt(i));
        } else {
            node.next[s.charAt(i) - 'a'].count++;
        }

        add_to_trie(s, i + 1, node.next[s.charAt(i) - 'a']);
    }

    public int[] sumPrefixScores(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int[] ans = new int[words.length];

        Node trie = new Node('.');

        for(int i = 0; i < words.length; i++) {
            String s = words[i];
            add_to_trie(s, 0, trie);
        }


        for(int i = 0; i < words.length; i++) {
            String s = words[i];
            Node ptr = trie;
            int count = 0;
            int j;
            for(j = 0; j < s.length(); j++) {
                if (ptr.next[s.charAt(j) - 'a'] == null) {
                    ans[i] = 0;
                    break;
                } else {
                    count += ptr.next[s.charAt(j) - 'a'].count;
                    ptr = ptr.next[s.charAt(j) - 'a'];
                }
            }
            if (j == words[i].length()) {
                ans[i] = count;
            }
        }

        return ans;
    }
}