class Solution {
    public void fillsetbits(int [] nums, int [] arr){
        for(int i=0; i<nums.length; i++){
            int a = nums[i];
            while (a > 0){
                if((a & 1) == 1) arr[i]++;
                a = a >> 1;
            }
        }
        // System.out.println(Arrays.toString(arr));
    }
    public void swap(int [] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public boolean canSortArray(int[] nums) {
        int [] arr = new int [nums.length];
        fillsetbits(nums, arr);
        // System.out.println(Arrays.toString(nums));
        for(int i=0; i<nums.length; i++){
            for(int j =1; j<nums.length; j++){
                if(nums[j-1] > nums[j] && arr[j-1] == arr[j]){
                    swap(nums, j-1, j);
                }
            }
        }
        
        // System.out.println(Arrays.toString(nums));

        for(int i=1; i<nums.length; i++){
            if(nums[i-1] > nums[i]){
                return false;
            }
        }
        return true;
    }
}