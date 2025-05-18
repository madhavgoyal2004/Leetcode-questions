class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int [] r = {-1,0,1,0};
        int [] c = {0,-1,0,1};
        Queue<int []> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0) {
                    q.add(new int [] {i,j});
                }
                else{
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while(!q.isEmpty()){
            int [] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for(int i=0; i<4; i++){
                int nr = x + r[i];
                int nc = y + c[i];
                if(nr >=0 && nc >=0 && nr < m && nc < n && mat[nr][nc] != 0){
                    if(mat[nr][nc] > mat[x][y] + 1){
                        mat[nr][nc] = mat[x][y] + 1;
                        q.add(new int [] {nr, nc});
                    }
                }
            }
        }

        return mat;

    }
}