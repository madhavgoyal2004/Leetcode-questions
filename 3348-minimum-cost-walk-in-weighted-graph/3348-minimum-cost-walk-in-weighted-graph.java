class Solution {
    public int find(int [] parent, int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent, parent[x]);
    }
    public void union (int [] parent, int [] rank, int a , int b){
        a = find(parent, a);
        b = find(parent, b);
        if(a == b) return;

        if(rank[a] <= rank[b]){
            rank[b]++;
            parent[a] = b;
        }
        else{
            rank[a]++;
            parent[b] = a;
        }

    }
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int [] parent = new int[n];
        int [] rank = new int[n];

        for(int i=0 ; i<n; i++){
            parent[i] = i;
        }

        for(int [] edge : edges){
            union(parent, rank, edge[0], edge[1]);
        }

        for(int i=0; i<n; i++){
            find(parent, i);
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int [] edge : edges){
            int p1 = parent[edge[0]];
            int p2 = parent[edge[1]];

            if(p1 == p2){
                if(map.containsKey(p1)){
                    map.put(p1, map.get(p1) & edge[2]);
                }
                else{
                    map.put(p1, edge[2]);
                }
            }
        }

        int [] arr = new int[query.length];
        Arrays.fill(arr, -1);
        for(int i=0; i<query.length; i++){
            int p1 = parent[query[i][0]];
            int p2 = parent[query[i][1]];

            if(p1 == p2){
                arr[i] = map.get(p1);
            }
        }

        return arr;
    }
}
