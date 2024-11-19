class SummaryRanges {

    int n = 100001;
    boolean[] intervals = new boolean[n];

    public SummaryRanges() {
        
    }
    
    public void addNum(int value) {
        intervals[value] = true;
    }
    
    public int[][] getIntervals() {
        List<int[]> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if (intervals[i] == true) {
                int start = i;

                while(i < n && intervals[i] == true) {
                    i++;
                }

                int end = --i;
                int[] sub_ans = new int[2];
                sub_ans[0] = start;
                sub_ans[1] = end;

                ans.add(sub_ans);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */