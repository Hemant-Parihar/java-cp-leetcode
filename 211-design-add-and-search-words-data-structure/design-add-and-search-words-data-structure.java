class WordDictionary {

    class Node {
        char ch;
        Node[] arr = new Node[26];
        boolean end = false;
        Node(char ch) {
            this.ch = ch;
        }
    }

    Node trie;

    public WordDictionary() {
        trie = new Node('.');
    }
    
    public void addWord(String word) {
        Node ptr = trie;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ptr.arr[ch - 'a'] == null) {
                ptr.arr[ch - 'a'] = new Node(ch);
            }
            ptr = ptr.arr[ch - 'a'];
        }
        // mark end
        ptr.end = true;
        // print(trie);
    }

    void print(Node ptr) {
        if (ptr == null) return;
        System.out.println(ptr.ch);
        for(int i = 0; i < 26; i++) {
            print(ptr.arr[i]);
        }
    }
    
    public boolean search(String word) {
        return searchAll(word, trie);
    }

    public boolean searchAll(String word, Node ptr) {
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                boolean val = false;
                for(int j = 0; j < 26; j++) {
                    if (ptr.arr[j] != null) {
                        val = searchAll(word.substring(i + 1), ptr.arr[j] );
                        if (val == true) return true;
                    }
                }
                return false;
            } else if (ptr.arr[ch - 'a'] == null) {
                return false;
            } else {
                ptr = ptr.arr[ch - 'a'];
            }

        }

        if (ptr.end == true) return true;
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */