class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph  =  new ArrayList<>();

        for(int i=0; i<numCourses ; i++){
            graph.add(new ArrayList<>());
        }

        for(int [] arr : prerequisites){
            graph.get(arr[0]).add(arr[1]);
        }

        boolean [] visited = new boolean [numCourses];
        // Stack<Integer> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            if(!visited[i]){
                topoSort(graph, list, i, visited);
            }
        }
        System.out.println(list);
        int [] new_arr = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            new_arr[i] = list.get(i);
        }

        for(int [] arr : prerequisites){
            int a = list.indexOf(arr[0]);
            int b = list.indexOf(arr[1]);

            if(a < b) return new int [] {};
        }

        return new_arr;
    }

    public void topoSort(ArrayList<ArrayList<Integer>> graph, ArrayList<Integer> list, int src, boolean [] visited){
        visited[src] = true;
        for(int nbr : graph.get(src)){
            if(!visited[nbr]){
                topoSort(graph, list, nbr, visited);
            }
        }
        list.add(src);
    }
}