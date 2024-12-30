class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for(int i=0; i<n; i++){
            if(map.containsKey(nums[i])){
                int curr = map.get(nums[i]);
                if(Math.abs(curr - i) <= k) return true;
                map.put(nums[i], i);
            }   
            else{
                map.put(nums[i], i);
            }
        }
        return false;
    }
}