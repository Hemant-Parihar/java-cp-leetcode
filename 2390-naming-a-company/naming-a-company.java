class Solution {
    public long distinctNames(String[] ideas) {
        HashSet[] groups = new HashSet[26];
        for(int i = 0; i < 26; i++) {
            groups[i] = new HashSet<String>();
        }

        for(int i = 0; i < ideas.length; i++) {
            char ch = ideas[i].charAt(0);
            groups[ch - 'a'].add(ideas[i].substring(1));
        }

        long ans = 0;
        for(int i = 0; i < 26; i++) {
            HashSet<String> set1 = groups[i];
            for(int j = i + 1; j < 26; j++) {
                HashSet<String> set2 = groups[j];
                
                HashSet<String> newSet = new HashSet<String>();
                newSet.addAll(set1);
                newSet.addAll(set2);

                int common = set1.size() + set2.size() - newSet.size();

                ans += (set1.size() - common) * (set2.size() - common) * 2;
                
            }
        }

        return ans;
    }
}