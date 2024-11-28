class Solution {

    class Node {
        int profit;
        int startTime;
        int endTime;
        Node(int s, int e, int p) {
            this.profit = p;
            this.endTime = e;
            this.startTime = s;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Node[] dp = new Node[n];

        List<Node> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            list.add(new Node(startTime[i], endTime[i], profit[i]));
        }

        Collections.sort(list, (a, b) -> a.endTime - b.endTime);
        
        dp[0] = list.get(0);

        for(int i = 1; i < n; i++) {
            Node node = list.get(i);
            int j = i - 1;
            int ans = 0;

            while(j >= 0) {
                if (dp[j].endTime <= node.startTime) {
                    ans = dp[j].profit + node.profit;
                    break;
                } else {
                    j--;
                }
            }
            
            if ( dp[i-1].profit >= ans) {
                if (j < 0 && dp[i-1].profit < node.profit) {
                    dp[i] = new Node(0, node.endTime, node.profit);
                } else {
                    dp[i] = dp[i-1];
                }
            } else {
                if (j >= 0) {
                    dp[i] = new Node(0, node.endTime, ans);
                } else {
                    dp[i] = new Node(0, node.endTime, node.profit);
                }
            }
        }

        // for(int i = 0; i < n; i++) {
        //     System.out.println(dp[i].endTime + " " + dp[i].profit);
        // }

        return dp[n-1].profit;
    }
}