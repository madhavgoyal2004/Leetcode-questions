class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        int freq = 0;
        int dom = -1;
        for(int i : nums){
            if(freq == 0){
                dom = i;
                freq++;
            }
            else if(dom == i){
                freq++;
            }
            else{
                freq--;
            }
        }
        freq = 0;
        for(int i=0; i<n; i++){
            if(dom == nums.get(i)) freq++;
        }
        
        int count = 0;

        for(int i=0; i<n; i++){
            if(nums.get(i) == dom){
                count++;
            }  
            if(count * 2 > i+1 && (freq-count)*2 > n - (i+1)){
                return i;
            }
        }

        return -1;
    }
}