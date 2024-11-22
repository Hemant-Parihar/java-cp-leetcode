class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candy = new int[n];
        candy[0] = 1;
        for(int i = 1; i < n; i++) {
            if (ratings[i] < ratings[i - 1]) {
                // (i - 1) should get more candy.
                candy[i] = 1;

                int j = i - 1;
                while(j >= 0 && ratings[j + 1] < ratings[j]) {
                    if ( candy[j + 1] == candy[j]) {
                        candy[j]++;
                        j--;
                    } else {
                        break;
                    }
                }

            } else if (ratings[i] == ratings[i - 1]) {
                candy[i] = 1;
            } else {
                candy[i] = candy[i-1] + 1;
            }

        }

        // System.out.println(Arrays.toString(candy));

        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += candy[i];
        }

        return sum;
    }
}