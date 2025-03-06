class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int m = n*n;
        boolean [] arr = new boolean[m+1];
        int repeat = 0;
        int miss = 0;
        int sum = 0;
        for(int i=0; i<n; i++){
            for(int j=0;j<n; j++){
                if(!arr[grid[i][j]]){
                    arr[grid[i][j]] = true;
                }
                else repeat = grid[i][j];
                sum += grid[i][j];
            }
        }

        miss = m*(m+1)/2 - (sum - repeat);

        return new int[] {repeat, miss};

    }
}