class Solution {
    public boolean canJump(int[] nums) {
        // 3 2 1 0 4
        int f=0;
        for(int i=0;i<nums.length;i++){ // 4
            if(f<i){ // 3 < 4
                return false;
            }
            f=Math.max(f,nums[i]+i); // max(3 , 0 + 3 ) == 3
        }
        return true;
    }
}