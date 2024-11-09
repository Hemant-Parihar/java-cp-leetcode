class Solution {

    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        HashMap<Integer, List<String>> map = new HashMap<>();

        map.put(2, new ArrayList<>(List.of("a", "b", "c")));
        map.put(3, new ArrayList<>(List.of("d", "e", "f")));
        map.put(4, new ArrayList<>(List.of("g", "h", "i")));
        map.put(5, new ArrayList<>(List.of("j", "k", "l")));
        map.put(6, new ArrayList<>(List.of("m", "n", "o")));
        map.put(7, new ArrayList<>(List.of("p", "q", "r", "s")));
        map.put(8, new ArrayList<>(List.of("t", "u", "v")));
        map.put(9, new ArrayList<>(List.of("w", "x", "y", "z")));


        solve(0, digits, map, new StringBuilder());

        return ans;
    }

    void solve(int i, String s, HashMap<Integer, List<String>> map, StringBuilder str) {
        if (i == s.length()) {
            if (str.length() > 0)
                ans.add(str.toString());
            return;
        }

        int digit = s.charAt(i) - '0';

        List<String> temp = map.get(digit);

        for(int k = 0; k < temp.size(); k++) {
            str.append(temp.get(k));
            solve(i + 1, s, map, str);
            str.deleteCharAt( str.length() - 1 );
        }
    }
}