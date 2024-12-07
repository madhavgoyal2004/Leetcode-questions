class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int n = nums.length;
        int left =1;
        int right = 0;
        for(int num : nums){
            right = Math.max(right, num);
        }

        while(left < right){
            int middle = left + (right - left)/2;

            if(isPossible(middle, nums, maxOperations)){
                right = middle;
            }
            else {
                left = middle + 1;
            }
        }

        return left;
    }
    public boolean isPossible(int balls, int [] nums, int max){
        int totalOperation = 0;

        for(int num : nums){
            totalOperation += (int) Math.ceil(num/(double)(balls)) - 1;
            if(totalOperation > max) return false;
        }
        return true;
    }
}