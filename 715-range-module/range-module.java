class RangeModule {

    List<int[]> intervals;

    public RangeModule() {
        intervals = new ArrayList<>();
        intervals.clear();
    }
    
    public void addRange(int start, int end) {
        // System.out.println("add " + start + " " + end);
        if (intervals.size() == 0) {
            int[] arr = new int[2];
            arr[0] = start;
            arr[1] = end - 1;
            intervals.add(arr);
        } else {
            boolean found = false;
            for(int i = 0; i < intervals.size(); i++) {
                if (intervals.get(i)[0] > end || intervals.get(i)[1] + 1 < start) {

                } else {
                    found = true;
                    start = Math.min(start, intervals.get(i)[0]);
                    end = Math.max(end - 1, intervals.get(i)[1]);
                    intervals.get(i)[0] = start;
                    intervals.get(i)[1] = end;
                    break;
                }
            }

            if (found == false ) {
                int[] arr = new int[2];
                arr[0] = start;
                arr[1] = end - 1;
                intervals.add(arr);
            }
            mergeIntervals(intervals);
        }
        // printIntervals(intervals);
    }

    void mergeIntervals(List<int[]> intervals) {
        Collections.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 1;
        while(i < intervals.size()) {
            if (intervals.get(i-1)[1] + 1 >= intervals.get(i)[0] ) {
                intervals.get(i-1)[0] = Math.min(intervals.get(i-1)[0], intervals.get(i)[0]);
                intervals.get(i-1)[1] = Math.max(intervals.get(i-1)[1], intervals.get(i)[1]);
                intervals.remove(i);
            } else {
                i++;
            }
        }
    }

    void printIntervals(List<int[]> intervals) {
        for(int i = 0; i < intervals.size(); i++) {
            System.out.println(intervals.get(i)[0] + " " + intervals.get(i)[1]);
        }
        System.out.println("==========");
    }
    
    public boolean queryRange(int left, int right) {
        // System.out.println("query " + left + " " + right);
        for(int i = 0; i < intervals.size(); i++) {
            if (left >= intervals.get(i)[0] && right - 1 <= intervals.get(i)[1]) {
                return true;
            }
        }
        return false;
    }
    
    public void removeRange(int left, int right) {
        // System.out.println("remove " + left + " " + right);
        int i;
        for(i = 0; i < intervals.size(); i++) {
            if (left <= intervals.get(i)[0] && right - 1 >= intervals.get(i)[1]) {
                intervals.remove(i);
                i--;
            } else if ( (left >= intervals.get(i)[0] && left <= intervals.get(i)[1]) ) {
                // we need to remove.
                if ( right - 1 <= intervals.get(i)[1] ) {

                    int[] arr = new int[2];
                    arr[0] = right;
                    arr[1] = intervals.get(i)[1];
                    intervals.add(i + 1, arr);


                    intervals.get(i)[1] = left - 1;
                    if (intervals.get(i)[1] < intervals.get(i)[0]) {
                        intervals.remove(i);
                    }
                    break;
                } else {
                    int temp = intervals.get(i)[1] + 1;
                    intervals.get(i)[1] = left - 1;
                    left = temp;
                    if (intervals.get(i)[1] < intervals.get(i)[0]) {
                        intervals.remove(i);
                    }
                }
            } else if (right >= intervals.get(i)[0] && right <= intervals.get(i)[1]) {
                intervals.get(i)[0] = right;
                if (intervals.get(i)[1] < intervals.get(i)[0]) {
                    intervals.remove(i);
                }
            }
        }

        // printIntervals(intervals);
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */