class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] front = new int[n];
        int[] f_c = new int[n];

        int[] back = new int[n];
        int[] b_c = new int[n];

        if (boxes.charAt(0) == '1') {
            f_c[0] = 1;
        }

        for(int i = 1; i < n; i++) {
            front[i] = front[i - 1] + f_c[i - 1];

            if (boxes.charAt(i) == '1') {
                f_c[i] = 1 + f_c[i - 1];
            } else {
                f_c[i] = f_c[i - 1];
            }
        }


        if (boxes.charAt(n - 1) == '1') {
            b_c[n - 1] = 1;
        }

        for(int i = n - 2; i >= 0; i--) {
            back[i] = back[i + 1] + b_c[i + 1];

            if (boxes.charAt(i) == '1') {
                b_c[i] = 1 + b_c[i + 1];
            } else {
                b_c[i] = b_c[i + 1];
            }
        }

        int[] ans = new int[n];

        // System.out.println(Arrays.toString(f_c));
        // System.out.println(Arrays.toString(front));

        // System.out.println(Arrays.toString(b_c));
        // System.out.println(Arrays.toString(back));

        for(int i = 0; i < n; i++) {
            ans[i] = front[i] + back[i];
        }

        return ans;
    }
}