class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        int j = -1;
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ') {
                
                int x = j + 1;
                int y = i - 1;
                while(y >= x) {
                    str.append(s.charAt(y));
                    y--;
                }
                str.append(' ');
                
                j = i;
            }
            if (i == n - 1) {
                int x = j + 1;
                int y = i;
                while(y >= x) {
                    str.append(s.charAt(y));
                    y--;
                }
            }
        }
        return str.toString();
    }
}