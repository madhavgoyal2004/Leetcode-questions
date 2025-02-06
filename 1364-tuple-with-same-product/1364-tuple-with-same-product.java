class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        if(n < 4) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int sum = nums[i] * nums[j];
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
        }

        for(int i : map.keySet()){
            int size = map.get(i);
            if(size >= 2){
                count += (size*(size-1))/2; 
            }
        }

        return count*8;
    }
}