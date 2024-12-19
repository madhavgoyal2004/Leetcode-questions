class Solution {
    public int maxChunksToSorted(int[] arr) {
        int count = 0;
        int sum = 0;
        int prefix = 0;

        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            prefix += i;
            if(prefix == sum){
                count++;
            }
        }
        return count;
    }
}