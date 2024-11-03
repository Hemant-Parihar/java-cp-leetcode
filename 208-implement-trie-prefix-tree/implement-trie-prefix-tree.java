class Trie {

    class Node {
        Node[] arr = new Node[26];
        boolean end = false;
    }

    Node trie;

    public Trie() {
        trie = new Node();
    }
    
    public void insert(String word) {
        Node ptr = trie;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ptr.arr[ch - 'a'] == null) {
                ptr.arr[ch - 'a'] = new Node();
            }
            ptr = ptr.arr[ch - 'a'];
        }
        // mark end
        ptr.end = true;
    }
    
    public boolean search(String word) {
        Node ptr = trie;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ptr.arr[ch - 'a'] == null) {
                return false;
            }
            ptr = ptr.arr[ch - 'a'];
        }
        if (ptr.end == true)
            return true;
        return false;
    }
    
    public boolean startsWith(String prefix) {
        Node ptr = trie;
        for(int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (ptr.arr[ch - 'a'] == null) {
                return false;
            }
            ptr = ptr.arr[ch - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */