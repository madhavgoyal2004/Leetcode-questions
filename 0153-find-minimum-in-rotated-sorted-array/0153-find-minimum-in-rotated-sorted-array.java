class Solution {
    public int findMin(int[] nums) {

        int st = 0, end = nums.length -1;
        int mid =0, min =  Integer.MAX_VALUE;
        if(nums[st]<=nums[end])
            return nums[st];
        else if(nums.length == 2)
            return nums[end];

        while (st < end){            //4   3
            mid = (end - st)/2 + st; //4
            if(nums[mid] < nums[st] && nums[mid] < nums[end]){
                min = nums[mid];
            }

            if(nums[st] == nums[mid] && nums[st] < nums[end] && min > nums[st]){
                return nums[mid];
            }

            if(nums[st] < nums[mid] && nums[st]< min && nums[st] < nums[end]){
                return nums[st];
            }
            

            if(Math.abs(nums[mid] - nums[st]) >= Math.abs(nums[mid] - nums[end])){  // 0  0
                // min = nums[mid];
                end = mid - 1;                                                    //3
            }
            else
                st = mid + 1;                                                     //4
            
            
        }
        if(nums[st] < min)
            return nums[st];
        return min;
    }
}