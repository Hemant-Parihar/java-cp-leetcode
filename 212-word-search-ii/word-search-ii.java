class Solution {

    class Node {
        char ch;
        Node[] next = new Node[26];
        Node(char val) {
            ch = val;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;

        Node root = new Node('.');

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                buildTrieDFS(i, j, root, board, 0);
            }
        }

        List<String> ans = new ArrayList<>();

        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            if (search(word, root)) {
                ans.add(word);
            }
        }

        return ans;
    }

    void printTrie(Node ptr) {
        
    }

    boolean search(String word, Node ptr) {
        
        int i = 0;
        while(i < word.length()) {
            char ch = word.charAt(i);
            if (ptr.next[ch - 'a'] == null) return false;
            ptr = ptr.next[ch - 'a'];
            i++;
        }
        return true;
    }

    void buildTrieDFS(int i, int j, Node ptr, char[][] board, int len) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || len > 10 || board[i][j] == '.') return;

        char ch = board[i][j];
        board[i][j] = '.';
        
        if (ptr.next[ch - 'a'] == null) {
            ptr.next[ch - 'a'] = new Node(ch);
        }
        ptr = ptr.next[ch - 'a'];

        buildTrieDFS(i + 1, j, ptr, board, len + 1);
        buildTrieDFS(i - 1, j, ptr, board, len + 1);
        buildTrieDFS(i, j - 1, ptr, board, len + 1);
        buildTrieDFS(i, j + 1, ptr, board, len + 1);

        board[i][j] = ch;
    }
}