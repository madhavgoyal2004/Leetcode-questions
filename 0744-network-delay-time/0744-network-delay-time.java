import java.util.*;
class Solution {
    class Pair{
        int vtx;
        int cost;
        Pair(int vtx, int cost){
            this.vtx = vtx;
            this.cost = cost;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
        for(int i=1; i<= n; i++){
            graph.put(i, new HashMap<>());
        }
        for(int [] arr : times){
            // if(graph.containsKey(arr[0])){
                graph.get(arr[0]).put(arr[1], arr[2]);
            // }else{
            //     HashMap<Integer,Integer> map = new HashMap<>();
            //     map.put(arr[1], arr[2]);
            //     graph.put(arr[0], map);
            // }
        }
        // System.out.println(graph);

        HashSet<Integer> visited = new HashSet<>();
        int[] total = {0};
        findTime(graph, n, k, visited, total);
        for(int i=1; i<=n; i++){
            if(!visited.contains(i)) return -1;
        }

        return total[0];
    }

    public void findTime(HashMap<Integer, HashMap<Integer, Integer>> graph, int n, int src, HashSet<Integer> visited, int[] total){
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return a.cost - b.cost;
            }
        });
        pq.add(new Pair(src, 0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(visited.contains(curr.vtx)) continue;
            visited.add(curr.vtx);
            HashMap<Integer, Integer> map = graph.get(curr.vtx);
            // int m = 0;
            // if(map.keySet() == null) continue;
            for(int nbr : map.keySet()){
                // m = Math.max(m , map.get(nbr));
                pq.add(new Pair(nbr, curr.cost + map.get(nbr)));
            }
            total[0] = Math.max(total[0], curr.cost);
        }
    }
}