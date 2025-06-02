class Solution {
    public String minWindow(String s, String t) {
        int m = t.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < m; i++) {
            char ch = t.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        int count = 0;
        int i = 0;
        int j;
        int len = Integer.MAX_VALUE;
        String ans = "";

        for(j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                if (map.get(ch) > 0) {
                    count++;
                }
                map.put(ch, map.get(ch) - 1);
                while (count == m) {
                    if (len > (j - i + 1)) {
                        len = j - i + 1;
                        ans = s.substring(i, j + 1);
                    }
                    char ch_p = s.charAt(i);
                    if (map.containsKey(ch_p)) {
                        map.put(ch_p, map.get(ch_p) + 1);
                        if (map.get(ch_p) > 0) {
                            count--;
                        }
                    }
                    i++;
                }
            }
        }


        return ans;
    }
}