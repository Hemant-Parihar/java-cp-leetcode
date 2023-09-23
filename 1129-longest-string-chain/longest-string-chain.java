class Solution {
    class Node {
        String str;
        int len;
        Node(String str, int len) {
            this.str = str;
            this.len = len;
        }
    }

    public int longestStrChain(String[] words) {
        List<Node> list = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            list.add( new Node(words[i], words[i].length() ));
        }
        Collections.sort(list, (a, b) -> a.len - b.len);

        int n = words.length;
        int[][] dp = new int[n+1][n+1];

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(0, list, -1, dp);
    }

    int solve(int i, List<Node> list, int j, int[][] dp) {
        if (i == list.size()) {
            return 0;
        }

        if (dp[i+1][j+1] != -1) {
            return dp[i+1][j+1];
        }

        int p = Integer.MIN_VALUE, up;
        if ( j == -1 || checkSubSequence(list.get(j).str, list.get(i).str)) {
            if (j != -1) {
                System.out.println(list.get(j).str + " " + list.get(i).str);
            }
            p = 1 + solve(i + 1, list, i, dp);
        }
        up = solve(i + 1, list, j, dp);

        dp[i+1][j+1] = Math.max(p, up);
        return Math.max(p, up);
    }

    boolean checkSubSequence(String str, String superStr) {
        int i = 0;
        int j = 0;

        if (str.length() + 1 != superStr.length()) {
            return false;
        }

        if (str == "") {
            return true;
        }

        while(j < superStr.length()) {
            if (superStr.charAt(j) == str.charAt(i)) {
                i++;
                if (i == str.length()) return true;
            }
            j++;
        }
        return false;
    }
}