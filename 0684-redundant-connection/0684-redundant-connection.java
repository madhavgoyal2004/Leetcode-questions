class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<edges.length; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0; i<edges.length; i++){
            int first = edges[i][0]-1;
            int second = edges[i][1]-1;

            if(!graph.get(first).contains(second)){
                graph.get(first).add(second);
            }
            
            
            if(!graph.get(second).contains(first)){
                graph.get(second).add(first);
            }

            boolean [] visited = new boolean[graph.size()];
            if(dfs_check_cycle(graph, first, visited, -1 )){
                return edges[i];
            }
        }
        System.out.println(graph);

        return edges[0];
    }
    public boolean dfs_check_cycle(ArrayList<ArrayList<Integer>> graph,int s, boolean [] visited, int parent){
        // System.out.print(S + " ");
        visited[s] = true;

        ArrayList<Integer>  nbr_list = graph.get(s);

        for(int nbr : nbr_list){
            if(!visited[nbr]){
                if(dfs_check_cycle(graph, nbr, visited, s)) return true;
            }
            else if(nbr != parent){
                return true;
            }
        }

        return false;

    }
    

}