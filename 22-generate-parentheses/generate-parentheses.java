class Solution {
    
    List<String> ans = new ArrayList<>();
    int N;

    public List<String> generateParenthesis(int n) {
        N = n;
        solve(0, 0, new StringBuilder());
        return ans;
    }

    void solve(int open, int close, StringBuilder str) {
        if (close > open) return;
        
        if (open == N) {
            int temp = close;
            while(temp < N) {
                temp++;
                str.append(')');
            }
            ans.add(str.toString());

            while(temp > close) {
                temp--;
                str.deleteCharAt( str.length() - 1 );
            }
            return;
        }

        str.append('(');
        solve(open + 1, close, str);

        str.deleteCharAt( str.length() - 1 );

        str.append(')');
        solve(open, close + 1, str);
        str.deleteCharAt( str.length() - 1 );
    }
}