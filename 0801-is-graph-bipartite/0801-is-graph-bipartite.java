class Solution {
    public boolean isBipartite(int[][] graph) {
        // 0 -> red, 1 -> blue
        int n = graph.length;
        int [] arr = new int [n];
        Arrays.fill(arr, -1);


        for(int vtx = 0; vtx <n; vtx ++){
            if(arr[vtx] == -1){
                Queue<Integer> q = new LinkedList<>();
                q.add(vtx);
                arr[vtx] = 0;

                while(!q.isEmpty()){
                    int curr = q.poll();

                    for(int nbr : graph[curr]){
                        if(arr[nbr] == -1){
                            arr[nbr] = 1 - arr[curr];
                            q.add(nbr);
                        } else if(arr[nbr] == arr[curr]){
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}