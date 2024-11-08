class Solution {

    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        solve(s, new ArrayList<>());
        return ans;
    }

    void solve( String s, ArrayList<String> list) {
        int n = s.length();

        if (n <= 1) {
            if (n > 0)
                list.add( s );
            if (list.size() > 0)
                ans.add(new ArrayList<>(list));
            if (n > 0)
                list.remove(list.size() - 1);
            return;
        }

        for(int i = 1; i <= n; i++) {
            String str = s.substring(0, i);

            if (isValid(str)) {
                
                list.add(str);
                solve ( s.substring(i),  list);

                list.remove(list.size() - 1);
            }
        }
    }

    boolean isValid(String s) {
        int n = s.length();
        int i = 0; 
        int j = n - 1;
        while(i < j) {
            if (s.charAt(i) != s.charAt(j) ) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}