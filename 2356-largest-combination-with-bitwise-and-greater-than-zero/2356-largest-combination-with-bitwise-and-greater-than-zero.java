class Solution {
    public void bit(int [] arr, int a){
        int idx = 0;
        while (a > 0){
            if((a & 1) == 1){
                arr[idx]++;
            }
            idx++;
            a = a>>1;
        }
    }
    public int largestCombination(int[] candidates) {
        int [] arr = new int[24];
        for(int i=0; i<candidates.length; i++){
            bit(arr, candidates[i]);
        }     

        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            max = Math.max(arr[i],max);
        }
        return max;
    }
}