class Solution {
    public String minWindow(String s, String t) {
        int[] t_f = new int[52];

        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                t_f[ch - 'A']++;
            } else {
                t_f[ch - 'a' + 26]++;
            }
        }

        // System.out.println(Arrays.toString(t_f));

        int i = 0;
        int j = 0;
        String ans = null;

        int[] s_f = new int[52];

        while(j < s.length()) {

            char ch = s.charAt(j);
            if (ch >= 'A' && ch <= 'Z') {
                s_f[ch - 'A']++;
            } else {
                s_f[ch - 'a' + 26]++;
            }

            j++;
            if (j - i >= t.length()) {
                while(compare(s_f, t_f)) {
                    if (ans == null || ans.length() > (j - i)) {
                        ans = s.substring(i, j);
                    }

                    char temp = s.charAt(i);
                    if (temp >= 'A' && temp <= 'Z') {
                        s_f[temp - 'A']--;
                    } else {
                        s_f[temp - 'a' + 26]--;
                    }

                    i++;
                }
            }
        }
        if (ans == null) return "";
        return ans;
    }

    boolean compare(int[] s_f, int[] t_f) {
        for(int i = 0; i < 52; i++) {
            if (t_f[i] > s_f[i]) return false;
        }
        return true;
    }
}