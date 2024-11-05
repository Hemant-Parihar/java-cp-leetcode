class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++) {
            String s = strs[i];
            int[] freq = new int[26];
            for(int j = 0; j < s.length(); j++) {
                freq[s.charAt(j) - 'a']++;
            }
            StringBuilder str = new StringBuilder();
            for(int j = 0; j < 26; j++) {
                str.append(freq[j] + ",");
            }
            String key = str.toString();
            if ( map.containsKey(key) ) {
                map.get(key).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key, list );
            }
        }

        return new ArrayList<>(map.values());
    }
}