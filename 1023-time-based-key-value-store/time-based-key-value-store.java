class TimeMap {

    class Node {
        String val;
        int t;
        Node(String val, int t) {
            this.val = val;
            this.t = t;
        }
    }

    HashMap<String, List<Node>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Node node = new Node(value, timestamp);
        if (map.containsKey(key)) {
            List<Node> list = map.get(key);
            list.add(node);
        } else {
            map.put(key, new ArrayList<Node>(List.of(node)));
        }
    }

    public int binary_search(List<Node> list, int time) {
        int start = 0;
        int end = list.size() - 1;

        while(start <= end) {
            int mid = (start + end) / 2;
            int t = list.get(mid).t;
            if (t == time ) {
                return mid + 1;
            } else if (mid + 1 <= end && (t <= time && list.get(mid + 1).t > time) ) {
                return mid + 1;
            } else if (t > time) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return end + 1;
    }
    
    public String get(String key, int timestamp) {
        if (map.containsKey(key)) {
            List<Node> list = map.get(key);
            int i = binary_search(list, timestamp);
            i--;
            if (i < 0) return "";
            else 
                return list.get(i).val;
        
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */