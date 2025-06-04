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

        @Override
        public String toString() {
            return start + " " + end + " " + pro + " . ";
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

        // System.out.println(Arrays.toString(arr));

        ans[0] = arr[0].pro;

        for(int i = 1; i < n; i++) {
            int j = i - 1;

            j = binarySearch(0, j, arr[i].start, arr);

            int processed = arr[i].pro;
            if (j >= 0) {
                processed += ans[j];
            }
            ans[i] = Math.max(ans[i - 1], processed);
        }

        return ans[n - 1];
    }

    int binarySearch(int start, int end, int val, Node[] arr) {

        if (val < arr[0].end) return -1;

        while(start < end) {
            int mid = (start + end) / 2;

            // System.out.println(start + " " + mid + " " + end + " " + val);
            
            if (arr[mid].end <= val && ( (mid + 1 <= end) && arr[mid + 1].end > val)) {
                return mid;
            } else if (arr[mid].end <= val) {
                start = mid + 1;
            } else if (val < arr[mid].end) {
                end = mid - 1;
            }
        }

        System.out.println("==========");

        return start;
        
    }
}