class Solution {
    private int helper(int [][] arr, int row, int col, int target){
        int count = 0;
        for(int j=col; j<arr[0].length; j++){
            int sum = 0;
            for(int i=row; i<arr.length; i++){
                if(col > 0){
                    sum -= arr[i][col-1];
                }
                sum += arr[i][j];
                if(sum == target){
                    count++;
                }
            }
        }

        return count;
    }
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        // use prefix sum for row and column seprate
        int m = matrix.length;
        int n = matrix[0].length;
        int [][] prefix = new int [m][n];

        for(int i=0; i<m; i++){
            prefix[i][0] = matrix[i][0];
            for(int j=1; j<n; j++){
                prefix[i][j] =  prefix[i][j-1] +  matrix[i][j];
            }
        }

        int count = 0;

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                count += helper(prefix, i, j, target);
            }
        }
        return count;

    }
}