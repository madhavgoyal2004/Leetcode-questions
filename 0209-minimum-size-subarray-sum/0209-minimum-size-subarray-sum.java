class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        while(j < nums.length){
            sum += nums[j++];

            while(i < j && sum >= target){
                len = Math.min(len, j-i);
                sum -= nums[i++];
            }
        }

        return len == Integer.MAX_VALUE ? 0 : len;
    }
}