class Solution {
    private boolean helper(int [] arr, long k, int mid){
        long count = 0;
        for(int i=0; i<arr.length; i++){
            count += arr[i] / mid;
        }
        return count >= k;
    }
    public int maximumCandies(int[] candies, long k) {
        int sum = 0;
        int st = 1;
        int end = 0;

        for(int i=0; i<candies.length; i++){
            sum += candies[i];
            end = Math.max(end, candies[i]);
        }

        int ans = 0;

        while(st <= end){
            int mid = st + (end - st)/2;
            
            if(helper(candies, k, mid)){
                ans = mid;
                st = mid + 1;
            } else{
                end = mid - 1;
            }
        }

        return ans;

    }
}