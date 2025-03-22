class Solution {
    int count;
    public int countCompleteComponents(int n, int[][] edges) {
        count = 0;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            arr.add(new ArrayList<Integer>());
        }

        for(int i=0; i<edges.length; i++){
            int first = edges[i][0];
            int second = edges[i][1];

            if(!arr.get(first).contains(second)){
                arr.get(first).add(second);
            }
            
            if(!arr.get(second).contains(first)){
                arr.get(second).add(first);
            }
        }

        System.out.println(arr);

        boolean [] visited = new boolean [n];

        for(int i=0; i<n; i++){
            if(!visited[i]){
                if(bfs (arr, n, i, visited)) count++;
            }
        }

        return count;
    }

    public boolean bfs(ArrayList<ArrayList<Integer>> arr, int n, int i, boolean[] visited){

        Queue <Integer> q = new LinkedList<>();
        ArrayList<Integer> edges = new ArrayList<>();

        q.add(i);
        int nodes = 1;
        visited[i] = true;
        
        while (!q.isEmpty()){
            int curr = q.poll();
            edges.add(curr);
            ArrayList<Integer> list = arr.get(curr);

            for(int nbr : list){
                if(!visited[nbr]){
                    visited[nbr] = true;
                    nodes++;
                    q.add(nbr);
                }
            }
        }
        int k = countedges(arr, edges);
        if((nodes*(nodes-1))/2  ==  k) return true;
        return false;
    }

    public int countedges(ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> edges){
        int countedge = 0;
        for(int edge : edges){
            ArrayList<Integer> ar = arr.get(edge);
            for(int ele : ar){
                if(ele > edge){
                    countedge++;
                }
            }
        }

        return countedge;
    }
}