class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int pos = 0;
        // int diff = 0;
        int [] right = new int[n];
        right[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--){
            right[i] = Math.max(right[i+1], nums[i+1]);
        }
        // System.out.println(Arrays.toString(right));

        long [] diff = new long[n];
        for(int i=1; i<n; i++){
            diff[i] = nums[i-1] - nums[i];
        }
        // System.out.println(Arrays.toString(diff));

        long sum = 0;
        long maxdiff = 0;
        for(int i=1; i<n-1; i++){
            sum += diff[i];
            if(maxdiff < sum*right[i]){
                maxdiff = sum*right[i];
                pos = i;
            }
            if(sum < 0) sum = 0;
        }
        // System.out.println(maxdiff);

        // long ans = 0;
        // while(pos < n){
        //     ans = Math.max(ans, nums[pos]*maxdiff);
        //     pos++;
        // }
        return maxdiff;
    }
}