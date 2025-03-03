class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> sList = new ArrayList<>();
        ArrayList<Integer> eqList = new ArrayList<>();
        ArrayList<Integer> lList = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            if(nums[i] < pivot){
                sList.add(nums[i]);
            }
            else if(nums[i] == pivot){
                eqList.add(nums[i]);
            }
            else{
                lList.add(nums[i]);
            }
        }

        int i = 0;
        int j = 0;
        while(j < sList.size()){
            nums[i++] = sList.get(j);
            j++; 
        }
        j=0;
        while(j < eqList.size()){
            nums[i++] = eqList.get(j);
            j++; 
        }
        j=0;
        while(j < lList.size()){
            nums[i++] = lList.get(j);
            j++; 
        }

        return nums;
    }
}