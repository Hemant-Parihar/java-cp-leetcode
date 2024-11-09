class Solution {
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

        List<String> ans = new ArrayList<>();

        for(int i = 0; i < digits.length(); i++) {
            int dig = digits.charAt(i) - '0';
            if (ans.size() == 0) {
                ans.addAll(map.get(dig));
            } else {
                List<String> tempAns = new ArrayList<>(ans);
                List<String> newList = new ArrayList<>();

                for(int j = 0; j < tempAns.size(); j++) {
                    List<String> temp = map.get(dig);
                    for(int k = 0; k < temp.size(); k++) {
                        newList.add( tempAns.get(j) + temp.get(k) );
                    }
                }

                ans = newList;
            }
        }

        return ans;
    }
}