class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int [] arr = new int[n];
        HashMap<Integer,Integer> map_ball = new HashMap<>();
        HashMap<Integer,Integer> map_color = new HashMap<>();
        for(int i=0; i<n; i++){
            int [] query = queries[i];
            if(map_ball.containsKey(query[0])){
                int find = map_ball.get(query[0]);
                map_color.put(find, map_color.get(find) - 1);
                if(map_color.get(find) == 0){
                    map_color.remove(find);
                }
            }
            map_ball.put(query[0], query[1]);
            map_color.put(query[1], map_color.getOrDefault(query[1], 0) + 1);
            arr[i] = map_color.size();
        }
        return arr;
    }
}