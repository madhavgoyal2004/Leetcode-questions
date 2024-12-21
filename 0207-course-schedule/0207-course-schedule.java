class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int [] arr : prerequisites){
            graph.get(arr[0]).add(arr[1]);
        }

        Stack<Integer> st = new Stack<>();
        boolean [] visited = new boolean[numCourses];
        for(int i=0; i<numCourses; i++){
            if(!visited[i])
            topoSort(graph, numCourses, visited, i, st);
        }
        System.out.println(st);

        ArrayList<Integer> arr = new ArrayList<>();

        while(!st.isEmpty()){
            arr.add(st.pop());
        }
        System.out.println(arr);

        for(int[] edge : prerequisites){
            int a = arr.indexOf(edge[0]);
            int b = arr.indexOf(edge[1]);

            if(a >= b) return false;
        }
        return true;
    }

    public void topoSort(ArrayList<ArrayList<Integer>> graph, int V, boolean [] visited, int src, Stack<Integer> st){
        if(visited[src]) return;
        visited[src] = true;
        for(int nbr : graph.get(src)){
            topoSort(graph, V, visited, nbr ,  st);
        }
        st.push(src);
    }
}