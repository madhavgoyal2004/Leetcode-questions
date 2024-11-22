class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        int n = graph.length;
        dfs (graph, 0, n-1, list, new ArrayList<>());

        return list;
    }

    public void dfs(int [][] graph, int src, int des , List<List<Integer>> list, List<Integer> temp){
        if(src == des){
            temp.add(des);
            list.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return;
        }

        temp.add(src);
        for(int nbr : graph[src]){
            dfs(graph, nbr, des,list, temp );
        }
        temp.remove(temp.size()-1);
    }
}