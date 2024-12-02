class Solution {
    class Pair{
        String s;
        int cost;
        Pair(String s, int cost){
            this.s = s;
            this.cost = cost;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        HashSet<String> set = new HashSet<>();
        for(String s : wordList){
            set.add(s);
        }

        int count = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            String s = curr.s;
            if(s.equals(endWord)) count = Math.min(count, curr.cost);

            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                for(int j=97; j<=122; j++){
                    char ch = (char) j;
                    if(c != ch){
                        String t = s.substring(0,i) + ch + s.substring(i+1);
                        if(set.contains(t)){
                            set.remove(t);
                            q.add(new Pair(t, curr.cost + 1));
                        }
                    }
                }
            }
        }
        return count == Integer.MAX_VALUE ? 0 : count;
    }
}