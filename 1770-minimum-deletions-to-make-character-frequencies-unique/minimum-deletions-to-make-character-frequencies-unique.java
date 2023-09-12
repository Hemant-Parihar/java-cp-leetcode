class Solution {
    public int minDeletions(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Integer> list = map.values().stream().collect(Collectors.toList());
        Collections.sort(list, Collections.reverseOrder());
        int ans = 0;
        int last = list.get(0);
        for(int i = 1; i < list.size(); i++) {
            if (list.get(i) >= last) {
                if (last == 1) {
                    ans += list.get(i);
                    continue;
                }
                ans += list.get(i) - (last - 1);
                last = Math.min(last - 1, list.get(i));
            } else {
                last = list.get(i);
            }
        }
        return ans;
    }
}