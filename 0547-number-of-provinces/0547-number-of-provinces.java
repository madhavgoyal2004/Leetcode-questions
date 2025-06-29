class Solution {
    public int find(int [] parent , int x){
        if(parent[x] == x){
            return x;
        } 
        return parent[x] = find(parent, parent[x]);
    }
    public void union(int [] parent, int a, int b){
        a = find(parent, a);
        b = find(parent, b);
        if(a != b){
            parent[a] = b;
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int [] parent = new int [n+1];
        for(int i=0; i<n+1; i++){
            parent[i] = i;
        }
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(isConnected[i][j] == 1){
                    union (parent, i+1, j+1);
                }
            }
        }

        for(int i=0; i<n+1; i++){
            find(parent, i);
        }
        
        int count = -1;
        for(int i=0; i<n+1; i++){
            if(parent[i]== i){
                count++;
            }
        }

        return count;

    }
}