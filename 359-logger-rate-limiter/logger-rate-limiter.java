class Logger {

    class Log {
        int time;
        String message;
        Log(int timestamp, String message) {
            this.time = timestamp;
            this.message = message;
        }
    }
    
    Queue<Log> queue;
    HashSet<String> set;
    
    public Logger() {
        queue = new LinkedList<>();
        set = new HashSet<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        while(!queue.isEmpty() && timestamp - queue.peek().time >= 10) {
            set.remove(queue.peek().message);
            queue.poll();
        }
        if (set.contains(message)) return false;
        queue.add(new Log(timestamp, message));
        set.add(message);
        return true;
    }
}

/**
    
 */

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */