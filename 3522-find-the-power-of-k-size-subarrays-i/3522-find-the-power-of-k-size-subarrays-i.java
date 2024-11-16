class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length; 
        int [] arr = new int[n - k +1];
        int i=0;
        int j=i+k-1;
        while (j < nums.length){
            arr[i] = nums[i];
            for(int a = i+1; a <= j ; a++){
                if(nums[a] - nums[a-1] != 1){
                    arr[i] = -1;
                    break;
                }
                arr[i] = Math.max(arr[i], nums[a]);
            }
            i++;
            j++;
        }
        return arr;
    }
}