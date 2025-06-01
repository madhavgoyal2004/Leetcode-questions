class Solution {
    public void dfs(ArrayList<ArrayList<Integer>> graph, boolean [] visited, int src, Stack<Integer> st){

        visited[src] = true;

        for(int nbr : graph.get(src)){
            if(!visited[nbr])
            dfs(graph, visited, nbr, st);
        }
        
        st.push(src);

    }

    public boolean cycle(ArrayList<ArrayList<Integer>> graph, boolean[] visited, boolean[] path_visited, int src){
        visited[src] = true;
        path_visited[src] = true;

        for(int nbr :  graph.get(src)){
            if(!visited[nbr]){
                if(cycle(graph, visited, path_visited, nbr)) return true;
            }
            else if(visited[nbr] && path_visited[nbr]) return true;
        }

        path_visited[src] = false;

        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean [] visited = new boolean[numCourses];
        boolean [] path_visited = new boolean[numCourses];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0; i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int [] arr : prerequisites){
            int a = arr[0];
            int b = arr[1];
            graph.get(b).add(a);
        }

        boolean cycle = false;
        for(int i=0; i<numCourses; i++){
            if(!visited[i]){
                if(cycle(graph, visited, path_visited, i)) cycle = true;
            }
        }

        if(cycle) return new int [] {};

        Arrays.fill(visited, false);

        Stack<Integer> st = new Stack<>();
        for(int i=0; i<numCourses; i++){
            if(!visited[i]){
                dfs(graph, visited, i, st);
            }
        }
        
        int [] arr = new int[numCourses];
        int i=0;
        while(!st.isEmpty()){
            arr[i] = st.pop();
            i++;
        }

        return arr;
    }
}