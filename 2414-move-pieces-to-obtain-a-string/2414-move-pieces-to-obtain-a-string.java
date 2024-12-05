class Solution {
    public boolean canChange(String start, String target) {
        Queue<Pair<Character, Integer>> sq = new LinkedList<>(), tq = new LinkedList<>();

        int n = start.length();

        for(int i=0; i<n; i++){
            if(start.charAt(i) != '_') sq.add(new Pair(start.charAt(i),i));
            if(target.charAt(i) != '_') tq.add(new Pair(target.charAt(i),i));
        }

        if(sq.size() != tq.size()) return false;

        while(!sq.isEmpty()){
            Pair<Character, Integer> s = sq.poll();
            Pair<Character, Integer> t = tq.poll();
            
            char s_key = s.getKey();
            int s_val = s.getValue();
            char t_key = t.getKey();
            int t_val = t.getValue();
            // System.out.println(s_key + " " + s_val + " " + t_key + " " + t_val)
            if(s_key != t_key || (s_key == 'L' && s_val < t_val) || (s_key == 'R' && s_val > t_val)) return false;
        }

        return true;
    }
}