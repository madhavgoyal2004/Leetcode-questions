class Solution {
    int [] r = {1,0,-1,0};
    int [] c = {0,1,0,-1};
    public void dfs(char [][] board, int m, int n, int row, int col){
        board[row][col] = '#';
        for(int i=0; i<4; i++){
            int nr = row + r[i];
            int nc = col + c[i];
            if(nr >= 0 && nc >= 0 && nr < m && nc < n && board[nr][nc] == 'O'){
                dfs(board, m, n, nr , nc);
            }
        }        
    }
    public boolean isvalid(char [][] board, int m, int n, int row, int col){
        return (row == 0 || col == 0 || row == m-1 || col == n-1) && board[row][col] == 'O';
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(isvalid(board, m, n, i, j)){
                    dfs(board, m, n, i, j);
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
                else{
                    board[i][j] = 'X';
                }
            }
        }
    }
}