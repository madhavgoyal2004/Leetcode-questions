class Solution {
    public int find(int [] parent, int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent, parent[x]);
    }
    public void union (int [] parent, int [] rank, int a ,int b){
        a = find(parent, a);
        b = find(parent, b);
        if(a == b) return;
        if(rank[a] >= rank[b]){
            rank[a]++;
            parent[a] = b;
        }else {
            rank[b]++;
            parent[b] = a;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1){
            return -1;
        }
        int [] parent = new int[n];
        int [] rank = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }

        for(int [] arr : connections){
            union(parent, rank, arr[0], arr[1]);
        }
        System.out.println(Arrays.toString(parent));
        System.out.println(Arrays.toString(rank));

        int m = 0;
        for(int i=0; i<n; i++){
            if(parent[i] == i){
                m++;
            }
        }
        return m-1;

    }
}