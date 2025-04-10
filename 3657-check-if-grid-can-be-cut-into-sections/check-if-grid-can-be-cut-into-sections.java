class Solution {
    public boolean checkValidCuts(int n, int[][] rec) {
        int size = rec.length;
        int[][] l1 = new int[size][2];
        int[][] l2 = new int[size][2];

        for(int i = 0; i < size; i++) {
            l1[i][0] = rec[i][0];
            l1[i][1] = rec[i][2];

            l2[i][0] = rec[i][1];
            l2[i][1] = rec[i][3];
        }

        Arrays.sort(l1, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(l2, (a, b) -> Integer.compare(a[0], b[0]));

        int count1 = 0;
        int end = l1[0][1];
        int count2 = 0;
        for(int i = 0; i < size - 1; i++) {
            if (end <= l1[i + 1][0]) {
                count1++;
            }
            end = Math.max(end, l1[i + 1][1]);
            if (count1 > 1) return true;
        }

        if (count1 > 1) {
            return true;
        }

        end = l2[0][1];
        for(int i = 0; i < size - 1; i++) {
            if (end <= l2[i + 1][0]) {
                count2++;
            }
            end = Math.max(end, l2[i + 1][1]);
            if (count2 > 1) return true;
        }
        if (count2 > 1) return true;
        return false;
    }
}