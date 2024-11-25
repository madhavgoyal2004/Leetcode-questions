class Solution {
    public int uniquePathsWithObstacles(int[][] nums) {
        if(nums[0][0] == 1) return 0;
        nums[0][0] = 1;
        int m = nums.length;
        int n = nums[0].length;

        for(int i=1; i<m; i++){
            if(nums[i][0] == 1){
                nums[i][0] = 0;
            }
            else{
                nums[i][0] = nums[i-1][0];
            }
        }
        for(int j=1; j<n; j++){
            if(nums[0][j] == 1){
                nums[0][j] = 0;
            }
            else{
                nums[0][j] = nums[0][j-1];
            }
        }

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(nums[i][j] == 1){
                    nums[i][j] = 0;
                }
                else{
                    nums[i][j] = nums[i-1][j] + nums[i][j-1];
                }
            }
        }

        return nums[m-1][n-1];
    }
}