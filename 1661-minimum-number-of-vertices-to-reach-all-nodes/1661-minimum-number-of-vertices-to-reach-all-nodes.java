class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int [] parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        for(List<Integer> edge : edges){
            parent[edge.get(1)] = edge.get(0);
        }

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(parent[i] == i){
                list.add(i);
            }
        }

        return list;
    }
}