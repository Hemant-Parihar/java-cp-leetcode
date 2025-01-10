class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] prefix_c = new int[n + 1];
        
        for(int i = 0; i < shifts.length; i++) {
            if (shifts[i][2] == 0) {
                prefix_c[shifts[i][1] + 1] += -1;
                prefix_c[shifts[i][0]] += 1;
            } else {
                prefix_c[shifts[i][1] + 1] += 1;
                prefix_c[shifts[i][0]] += -1;
            }
        }

        // System.out.println(Arrays.toString(prefix_c));

        StringBuilder str = new StringBuilder();

        int sum = 0;

        for(int i = n; i > 0; i--) {
            prefix_c[i] %= 26;
            sum += prefix_c[i];
        }

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int c = sum;
            c %= 26;

            if ( (int) (ch - 'a') + c >= 26) {
                int diff = (ch - 'a') + c - 26;
                str.append( (char) ('a' +  diff) );
            } else if ( (int) (ch - 'a') + c < 0) {
                int diff = (int)(ch - 'a') + c;
                str.append( (char) ('z' + diff + 1) );
            } else {
                str.append( (char) (ch + c) );
            }

            sum -= prefix_c[i+1];
        }

        return str.toString();
    }
}