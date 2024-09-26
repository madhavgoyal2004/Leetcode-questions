class MyCalendar {
    TreeMap<Integer, Integer> tm;
    public MyCalendar() {
        tm = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        if(tm.isEmpty()) {
            tm.put(start, end);
            return true;
        }

        for(int ele : tm.keySet()){
            if(start < ele && end > ele) return false;
            if(start < tm.get(ele) && end > tm.get(ele)) return false;
            if(start < ele && end > tm.get(ele)) return false;
            if(start > ele && end < tm.get(ele)) return false;
        }
        tm.put(start, end);
        return true;
    }   
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */