class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long bad = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            nums[i] = nums[i] - i;
            int good = map.getOrDefault(nums[i], 0);
            bad += i - good;
            map.put(nums[i], good + 1);
        }
        return bad;
    }
}