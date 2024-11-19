class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        // HashSet<Integer> set = new HashSet<>();
        boolean [] arr = new boolean[(int)1e5+1];

        int i=0;
        int j=0;
        long sum = 0;
        long max = 0;
        while (j < nums.length){
            while(j < nums.length && j-i+1 <= k){
                if(!arr[nums[j]]){
                    arr[nums[j]] = true;
                    sum += nums[j];
                    j++;
                }
                else{
                    while(arr[nums[j]]){
                        sum -= nums[i];
                        arr[nums[i]] = false;
                        i++;
                    }
                }
            }

            if(j-i+1 > k){
                max = Math.max(max, sum);
                sum -= nums[i];
                arr[nums[i]] = false;
                i++;
            }
        }

        return max;
    }
}