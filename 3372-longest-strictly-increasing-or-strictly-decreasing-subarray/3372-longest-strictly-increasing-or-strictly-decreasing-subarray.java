class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        if(n==1)return 1;
        int a = 1;
        int b = 1;
        int max = 1;

        for(int i=0; i<n-1; i++){
            if(nums[i] > nums[i+1]){
                b=1;
                a++;
            }
            else if(nums[i] < nums[i+1]){
                a=1;
                b++;
            }
            else{
                a=1;
                b=1;
            }
            max = Math.max(max , Math.max(a, b)) ;
        }

        return max;
    }
}