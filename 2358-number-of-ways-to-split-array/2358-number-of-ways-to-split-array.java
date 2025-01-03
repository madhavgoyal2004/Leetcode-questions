class Solution {
    public int waysToSplitArray(int[] nums) {
        long sum = 0;
        for(int num : nums){
            sum += num;
        }

        long n = 0;
        int count = 0;
        int i = 0;
        while(i < nums.length-1){
            n += nums[i];
            if(n >= sum-n){
                count++;
            }
            i++;
        }

        return count;
    }
}