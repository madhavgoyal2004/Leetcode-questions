class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int x=0, y=0, a=0, b=0;
        long count=0;
        long sum = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                if(matrix[i][j] <= 0){
                    if(max < matrix[i][j]){
                        max = matrix[i][j];
                        x = i;
                        y = j;
                    }
                    count++;
                }
                int temp = Math.abs(matrix[i][j]);
                if(min > temp){
                    min = temp;
                    a = i;
                    b = j;
                }
                sum += temp;
            }
        }
        // System.out.println(sum);

        if(count % 2 == 1){
            if(Math.abs(matrix[x][y]) > Math.abs(matrix[a][b])){
                sum += Math.abs(matrix[a][b])*-2;
            }
            else sum += 2*matrix[x][y];
        }
        return sum;
    }
}