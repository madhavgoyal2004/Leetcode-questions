class Solution {
    private boolean helper(int [] nums, int [][] queries, int k){
        int n = nums.length;
        int [] prefix = new int[n+1];

        for(int i=0; i<=k; i++){
            int st = queries[i][0];
            int end = queries[i][1];
            int val = queries[i][2];
            prefix [st] += val;
            prefix [end+1] += val*-1;
        }

        for(int i=1; i<n+1; i++){
            prefix[i] += prefix[i-1];
        }

        for(int i = 0; i<n; i++){
            if(nums[i] > prefix[i]) return false;
        }
        return true;
    }
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;  
        int m = n; 
        for(int i=0; i<n; i++){
            if(nums[i] == 0) m--;
        }
        if(m == 0) return 0;
        int st = 0;
        int end = queries.length -1;

        int ans = -1;
        while(st <= end){
            int mid = st + (end - st) / 2;
            if(helper(nums, queries, mid)){
                ans = mid+1;
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }

        return ans;

    }
}