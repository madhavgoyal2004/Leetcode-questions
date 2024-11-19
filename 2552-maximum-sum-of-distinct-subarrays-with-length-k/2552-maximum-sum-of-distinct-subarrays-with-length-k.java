class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        int i=0;
        int j=0;
        long sum = 0;
        long max = 0;
        while (j < nums.length){
            while(j < nums.length && j-i+1 <= k){
                if(!set.contains(nums[j])){
                    set.add(nums[j]);
                    sum += nums[j];
                    j++;
                }
                else{
                    while(set.contains(nums[j])){
                        sum -= nums[i];
                        set.remove(nums[i]);
                        i++;
                    }
                }
            }

            if(j-i+1 > k){
                max = Math.max(max, sum);
                sum -= nums[i];
                set.remove(nums[i]);
                i++;
            }
        }

        return max;
    }
}