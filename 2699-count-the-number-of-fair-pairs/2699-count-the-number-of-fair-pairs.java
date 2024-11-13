class Solution {
    public int lower (int [] nums, int lower, int upper, int idx){
        int st = idx+1;
        int end = nums.length - 1;
        int mid = 0;
        int ans = -1;
        // System.out.println(nums[idx]);
        while (st <= end){
            mid = st + (end - st)/2;
            // System.out.println(st + " " + mid + " " + end);
            int sum = nums[idx] + nums[mid];
            if(sum >= lower){
                if(sum <= upper)ans = mid;
                end = mid - 1;
            } else st = mid + 1;
        }
        return ans;
    }

    public int higher (int [] nums, int lower, int upper, int idx){
        int st = idx+1;
        int end = nums.length -1;
        int mid = 0;
        int ans = -1;
        while (st <= end){
            mid = st + (end - st)/2;
            int sum = nums[idx] + nums[mid];
            if(sum <= upper){
                if(sum >= lower)ans = mid;
                st = mid + 1;
            } else end = mid - 1;
        }
        return ans;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        long count = 0;
        int l = 0;
        int h = 0;
        for(int i=0; i<nums.length; i++){
            int lowest = lower(nums, lower, upper, i);
            int highest = higher (nums, lower, upper, i);
            if(lowest == -1 || highest == -1) continue;
            // System.out.println(nums[i] + " " + lowest + " " + highest);
            count += highest - lowest + 1;
        }
        // System.out.println(Arrays.toString(nums));

        return count;
    }
}