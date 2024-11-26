class Solution {
    public int find(int [] parent, int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent, parent[x]);
    }
    public void union(int a, int b, int [] parent, int [] rank){
        int p_a = find(parent, a);
        int p_b = find(parent, b);

        if(p_a == p_b) return;

        // if(rank[p_a] >= rank[p_b]){
        //     rank[p_a] ++;
        //     parent[p_b] = p_a; 
        // }
        // else{
        //     rank[p_b]++;
        //     parent[p_a] = p_b;
        // }

        
    }
    public int findChampion(int n, int[][] edges) {
        int [] parent = new int[n];
        int [] rank = new int[n];
        for(int i=0; i<n; i++){
            parent[i] =i;
        }

        for(int [] edge : edges){
            // union(edge[0], edge[1], parent, rank);
            parent[edge[1]] = edge[0];
        }

        // System.out.println(Arrays.toString(parent));
        int unique = 0;
        int count = 0;
        for(int i=0; i<parent.length; i++){
            if(parent[i] == i){
                count++;
                unique = i;
            }
        }
        // System.out.println(count);

        return count == 1 ? unique : -1;
    }
}