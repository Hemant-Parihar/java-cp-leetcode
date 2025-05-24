class Solution {

    int depth(int n) {
        int count = 0;
        while(n >= 1) {
            n /= 2;
            count++;
        }
        return count;
    }

    int lcs(int a, int b, int depth_a, int depth_b) {
        if (depth_a > depth_b) {
            int count = depth_a - depth_b;
            while(count > 0) {
                a = a / 2;
                count--;
            }
        } else {
            int count = depth_b - depth_a;
            while(count > 0) {
                b = b / 2;
                count--;
            }
        }

        while(a != b) {
            a = a / 2;
            b = b / 2;
        }

        return a;
    }

    public int[] cycleLengthQueries(int n, int[][] queries) {
        int m = queries.length;
        int[] ans = new int[m];

        for(int i = 0; i < m; i++) {
            int a = queries[i][0];
            int b = queries[i][1];

            int depth_a = depth(a);
            int depth_b = depth(b);

            // System.out.println(depth_a);
            // System.out.println(depth_b);

            int node = lcs(a, b, depth_a, depth_b);
            // System.out.println(node);

            int node_d = depth(node);

            ans[i] = depth_a + depth_b - 2*node_d + 1;
        }
        
        return ans;
    }
}