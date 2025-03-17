class Solution {
    public boolean divideArray(int[] nums) {
        int ans = 0;
        int [] arr = new int[501];
        for(int i=0; i<nums.length; i++){
            arr[nums[i]]++;
        }

        for(int i=0; i<501; i++){
            if(arr[i] % 2 != 0) return false;
        }

        return true;
    }
}