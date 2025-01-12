class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 == 1) return false;

        int open = 0;
        int close = 0;
        int dot = 0;

        for(int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0') {
                dot++;
            } else if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }

            if (close > (open + dot)) return false;
        }

        open = 0;
        close = 0;
        dot = 0;

        for(int i = n - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0') {
                dot++;
            } else if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }

            if (open > (close + dot)) return false;
        }

        // System.out.println(open + " " + close + " " + dot);


        // int x = Math.abs(open - close);
        // if (dot < x) return false;
        return true;
    }
}