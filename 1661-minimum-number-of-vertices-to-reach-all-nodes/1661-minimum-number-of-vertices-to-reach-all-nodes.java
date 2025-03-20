class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int [] parent = new int[n];
        for(List<Integer> edge : edges){
            parent[edge.get(1)]++;
        }

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(parent[i] == 0){
                list.add(i);
            }
        }

        return list;
    }
}