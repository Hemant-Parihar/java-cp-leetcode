class Solution {

    class Node {
        int start;
        int end;
        int pro;
        Node(int s, int e, int p) {
            this.start = s;
            this.end = e;
            this.pro = p;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        
        Node[] arr = new Node[n];
        int[] ans = new int[n];

        for(int i = 0; i < n; i++) {
            Node node = new Node(startTime[i], endTime[i], profit[i]);
            arr[i] = node;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a.end, b.end));

        ans[0] = arr[0].pro;

        for(int i = 1; i < n; i++) {
            int j = i - 1;
            while(j >= 0 && arr[j].end > arr[i].start) {
                j--;
            }

            int processed = arr[i].pro;
            if (j >= 0) {
                processed += ans[j];
            }
            ans[i] = Math.max(ans[i - 1], processed);
        }

        // System.out.println(Arrays.toString(ans));

        return ans[n - 1];
    }
}