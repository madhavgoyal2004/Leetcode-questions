class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        HashMap<Integer, int[]> map = new HashMap<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                map.put(mat[i][j], new int[] {i, j});
            }
        }

        for(int i=0; i<arr.length; i++){
            int [] curr = map.get(arr[i]);
            int a = curr[0];
            int b = curr[1];
            mat[a][b] = 0;
            if(checkAllRow(mat, a, n) || checkAllCol(mat, b, m)){
                return i;
            }
        }

        return -1;
    }

    public boolean checkAllRow(int [][] mat, int a, int n){
        for(int i=0; i<n; i++){
            if(mat[a][i] != 0){
                return false;
            }
        }
        return true;
    }
    public boolean checkAllCol(int [][] mat, int b, int m){
        for(int i=0; i<m; i++){
            if(mat[i][b] != 0){
                return false;
            }
        }
        return true;
    }
}