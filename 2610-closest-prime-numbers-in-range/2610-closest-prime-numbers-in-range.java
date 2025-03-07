class Solution {
    public int[] closestPrimes(int left, int right) {
        // int n = right - left +1;
        boolean [] arr = new boolean [right + 1];

        for(int i=2; i*i<= right; i++){
            if(arr[i]) continue;
            for(int j = i*i; j<= right ; j = j + i){
                arr[j] = true;
            }
        }

        int prev = 0;
        int next = 0;
        int diff = Integer.MAX_VALUE;
        int val1 = 0;
        int val2 = 0;
        for(int i=Math.max(2,left); i<=right; i++){
            if(!arr[i]){
                if(prev == 0){ 
                    prev = i;
                    continue;
                }
                next = i;

                if(diff > next - prev){
                    val1 = prev;
                    val2 = next;
                    diff = next - prev;
                }
                prev = next;
            }
        }

        return next == 0 ? new int[]{-1,-1}: new int[] {val1, val2};
    }
}