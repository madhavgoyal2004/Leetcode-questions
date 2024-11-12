class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length < 2) return false;
        if(k == 1 || k == 0) return true;
        HashMap<Integer, Integer> map = new HashMap<>();
       
        int sum = nums[0];
        map.put(sum %k ,0); // 2 0
        
        for(int i=1; i<nums.length; i++){
            sum += nums[i];
            int mod = sum % k;
            if(mod == 0) return true;

            if(map.containsKey(mod)){
                if(i-map.get(mod) > 1)return true;
            }
            else map.put(mod, i);
        }

        return false;
    }
}