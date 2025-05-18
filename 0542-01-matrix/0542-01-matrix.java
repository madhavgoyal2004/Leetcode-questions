class Solution {
    class Pair{
        int row;
        int col;
        int val;
        Pair(int row , int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int [] r = {-1,0,1,0};
        int [] c = {0,-1,0,1};
        Queue<Pair> q = new LinkedList<>();
        boolean [][] visit = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0) {
                    q.add(new Pair (i, j, 0));
                }
                else{
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while(!q.isEmpty()){
            Pair curr = q.poll();
            int x = curr.row;
            int y = curr.col;
            if(visit[x][y]) continue;

            visit[x][y] = true;

            for(int i=0; i<4; i++){
                int nr = x + r[i];
                int nc = y + c[i];
                if(nr >=0 && nc >=0 && nr < m && nc < n && mat[nr][nc] != 0){
                    mat[nr][nc] = Math.min(mat[nr][nc], curr.val + 1);
                    q.add(new Pair(nr, nc, mat[nr][nc]));
                }
            }
        }

        return mat;

    }
}