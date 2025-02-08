class NumberContainers {
    private HashMap<Integer, TreeSet<Integer>> map;
    private HashMap<Integer,Integer> Ind_map;
    public NumberContainers() {
       map = new HashMap(); 
       Ind_map = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(Ind_map.containsKey(index)){
            int prev_num = Ind_map.get(index);
            if(map.containsKey(prev_num)){
                map.get(prev_num).remove(index);
            }
            if(map.get(prev_num).isEmpty()){
                map.remove(prev_num);
            }
        }

        Ind_map.put(index, number);
        map.putIfAbsent(number, new TreeSet());
        map.get(number).add(index);
    }
    
    public int find(int number) {
        if(map.containsKey(number)){
            return map.get(number).first();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */