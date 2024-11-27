class Solution {
    class Pair{
        int vtx;
        int cost;
        Pair(int vtx, int cost){
            this.vtx = vtx;
            this.cost = cost;
        }
    }

    public int bfs(ArrayList<ArrayList<Integer>> graph, int src, boolean[] visited){
        PriorityQueue<Pair> q = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair a, Pair b){
                return a.cost - b.cost;
            }
        });

        int [] path = new int[graph.size()];
        q.add(new Pair(0,0));

        while(!q.isEmpty()){
            Pair curr = q.poll();

            if(visited[curr.vtx]) continue;
            visited[curr.vtx] = true;
            path[curr.vtx] = curr.cost;
            for(int nbr : graph.get(curr.vtx)){
                q.add(new Pair(nbr, curr.cost + 1));
            }
        }

        return path[graph.size() -1];
    }
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<n-1; i++){
            graph.get(i).add(i+1);
        }

        int [] ans = new int[queries.length];
        int i=0;
        for(int [] edge : queries){
            graph.get(edge[0]).add(edge[1]);
            ans[i++] = bfs(graph, 0, new boolean[n]);
        }
        return ans;
    }
}