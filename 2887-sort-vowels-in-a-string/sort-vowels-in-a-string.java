class Solution {
    public String sortVowels(String s) {
        int n = s.length();
        PriorityQueue<Character> heap = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            if (isVowel(s.charAt(i))) {
                heap.add(s.charAt(i));
            }
        }
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < n; i++) {
            if (isVowel(s.charAt(i))) {
                str.append(heap.poll());
            } else {
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }

    boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' 
            || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'
        ) {
            return true;
        }
        return false;
    }
}