class Solution {

    public List<List<String>> partition(String s) {
        return solve(s);
    }

    List<List<String>> solve( String s ) {
        int n = s.length();
        if (n == 0) return new ArrayList<>();
        List<List<String>> list = new ArrayList<>();

        if (n == 1) {
            list.add( new ArrayList<>(List.of(s) ) );
            return list;
        }

        for(int i = 1; i <= n; i++) {
            String str = s.substring(0, i);

            if (isValid(str)) {

                List<List<String>> subList = solve ( s.substring(i) );

                for(int j = 0; j < subList.size() ; j++) {
                    subList.get(j).add(0, str);
                    list.add(subList.get(j));
                }

                if (subList.size() == 0) {
                    list.add(new ArrayList<>(List.of(str)));
                }

            }
        }

        return list;
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