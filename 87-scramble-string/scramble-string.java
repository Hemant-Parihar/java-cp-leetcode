class Solution {
    class Node {
        String a;
        String b;
        Node(String a, String b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public boolean equals(Object obj) {
            // Check if obj is the same reference as this
            if (this == obj) {
                return true;
            }
            
            // Check if obj is an instance of Node
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            
            // Cast obj to Node and compare fields
            Node other = (Node) obj;
            return (a == null ? other.a == null : a.equals(other.a)) &&
                (b == null ? other.b == null : b.equals(other.b));
        }

        // Override hashCode method
        @Override
        public int hashCode() {
            int result = (a != null) ? a.hashCode() : 0;
            result = 31 * result + ((b != null) ? b.hashCode() : 0);
            return result;
        }
        
    }
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        
        HashMap<Node, Boolean> map = new HashMap<>();
        
        return solve(s1, s2, map);
    }

    boolean solve(String A, String B, HashMap<Node, Boolean> map) {
        if (A.length() != B.length()) return false;
        
        if (A.equals(B)) return true;
        
        if (A.length() == 1) {
            return false;
        }

        int n = A.length();

        int[] freqA = new int[26];
        int[] freqB = new int[26];

        for(int i = 0; i < n; i++) {
            freqA[A.charAt(i) - 'a']++;
            freqB[B.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if (freqA[i] != freqB[i]) return false;
        }
        
        Node node = new Node(A, B);

        if (map.containsKey(node)) {
            // System.out.println("========");
            // System.out.println(A + " " + B);
            return map.get(node);
        }
        
        int i = 0;
        
        for(int k = i; k < n - 1; k++) {
            // we are going to split the array at k == i;
            
            boolean b1 = solve(A.substring(i, k + 1), B.substring(i, k + 1), map) && solve(A.substring(k + 1, n), B.substring(k + 1, n), map);
            boolean b2 = solve(A.substring(i, k + 1) , B.substring(n - k - 1, n), map) && solve(A.substring(k + 1, n) , B.substring(i, n - k - 1), map);
            
            if (b1 || b2) {
                map.put(node, true);
                return true;
            }
        }
        
        map.put(node, false);
        return false;
    }
}