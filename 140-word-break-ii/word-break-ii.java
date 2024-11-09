class Solution {

    List<String> ans = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        set.addAll(wordDict);
        solve(s, set, new StringBuilder());
        return ans;
    }

    void solve(String s, HashSet<String> set, StringBuilder str) {
        // System.out.println(s + " " + str.toString());
        if (s.length() == 0) {
            ans.add(str.toString());
            return;
        }

        for(int i = 1; i <= s.length(); i++) {
            String subS = s.substring(0, i);
            if (set.contains(subS)) {
                int size = str.length();
                if (size > 0)
                    str.append(' ');
                str.append(subS);

                solve(s.substring(i), set, str);

                while(str.length() > size) {
                    str.deleteCharAt( str.length() - 1 );
                }
            }
        }
    }
}