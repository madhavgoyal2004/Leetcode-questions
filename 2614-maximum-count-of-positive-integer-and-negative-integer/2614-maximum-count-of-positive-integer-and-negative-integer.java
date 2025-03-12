class Solution {
    private int helper (int [] nums, int st, int end){
        while(st < end){
            int mid = st + (end - st)/2;

            if(nums[mid] < 0){
                st = mid + 1;
            }
            else if(nums[mid] > 0){
                end = mid - 1;
            }
            else return mid;
        }

        return st;
    }
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int neg = -1;
        int pos = n;
        
        int idx = helper(nums, 0, n-1);

    
        for(int i=idx ; i>=0; i--){
            if(nums[i] < 0) {
                neg = i;
                break;
            }
        }
        for(int i=idx; i<n; i++){
            if(nums[i] > 0){
                pos = i;
                break;
            }
        }

        return Math.max(neg+1, n-pos);
    }
}