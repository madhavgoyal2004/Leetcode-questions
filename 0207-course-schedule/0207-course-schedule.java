class Solution {
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
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        // System.out.println(graph);

        for(int i=0; i<numCourses; i++){
            if(!visited[i]){
                if(cycle(graph, visited, path_visited, i)) return false;
            }
        }

        return true;
    }
}