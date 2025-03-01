class Solution {
    public int[] applyOperations(int[] nums) {
        for(int i=1; i<nums.length; i++){
            if(nums[i-1] == nums[i]){
                nums[i-1] *= 2;
                nums[i] = 0;
            }
        }

        int [] arr = new int[nums.length];
        int k = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0)arr[k++] = nums[i];
        }
        return arr;
    }
}