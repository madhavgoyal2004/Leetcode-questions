class Solution {
    public long dfs(int [][] arr, int i, long [] dp){
        if(i >= arr.length){
            return 0;
        }
        if(dp[i] != -1) return dp[i];
        int [] curr = arr[i];
        long a = dfs(arr, i+curr[1]+1, dp) + curr[0]; // pick;
        long b = dfs(arr, i+1 , dp); // not pick

        return dp[i] = Math.max(a,b);
    }

    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long [] dp = new long[n];
        Arrays.fill(dp, -1);
        long l = dfs(questions, 0, dp);
        return l;
    }
}