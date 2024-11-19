class Solution {
    public boolean isBipartite(int[][] graph) {
        // Red -> 0 , Blue -> 1
        int n = graph.length;
        int [] color = new int[n];
        Arrays.fill(color, -1);


        for(int vtx = 0; vtx < n; vtx++){
            color[0] = 0;
            Queue<Integer> q = new LinkedList<>();
            q.add(vtx);
            while(!q.isEmpty()){
                int curr = q.poll();
                for(int nbr : graph[curr]){
                    if(color[nbr] == -1){
                        color[nbr] = 1 - color[curr];
                        q.add(nbr);
                    }
                    else if(color[nbr] == color[curr]){
                        return false;
                    }
                }
            }
        }

        return true;

    }
}