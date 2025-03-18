class Solution {
    public int longestNiceSubarray(int[] nums) {
        int maxlen = 0;
        int i=0;
        int j=0;
        int ans = 0;

        while(j<nums.length){

            while((ans & nums[j])  != 0){
                ans ^= nums[i];
                i++;
            }
            ans |= nums[j];
            maxlen = Math.max(maxlen, j-i+1);
            j++;
        }

        return maxlen;
    }
}