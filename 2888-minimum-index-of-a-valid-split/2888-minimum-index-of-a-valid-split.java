class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int dominating = 0;
        int freq = 0;
        for(int num : map.keySet()){
            if(map.get(num) > freq){
                dominating = num;
                freq = map.get(num);
            }
        }
        
        int count = 0;

        for(int i=0; i<n; i++){
            if(nums.get(i) == dominating){
                count++;
            }  
            if(count * 2 > i+1 && (freq-count)*2 > n - (i+1)){
                return i;
            }
        }

        return -1;
    }
}