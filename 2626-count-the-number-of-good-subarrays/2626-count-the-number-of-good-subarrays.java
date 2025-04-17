class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length; 
        if(n == 1) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int i=0;
        int j=0;
        long count = 0;
        int pair = 0;
        while(j < n){
            map.put(nums[j], map.getOrDefault(nums[j] , 0) + 1);

            if(map.get(nums[j]) > 1){
                pair += map.get(nums[j])-1;
            }

            while(i < j && pair >= k){
                count += n-j;
                map.put(nums[i], map.get(nums[i]) - 1);
                pair -= map.get(nums[i]);
                if(map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
                i++;
            }
            j++;
        }

        return count;
    }
}