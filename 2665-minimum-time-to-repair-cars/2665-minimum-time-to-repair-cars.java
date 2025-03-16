class Solution {
    private boolean helper(int [] ranks, int cars, long mid){
        long count = 0;
        for(int i=0; i<ranks.length; i++){
            long temp = mid / ranks[i];
            count += (long) Math.sqrt(temp);
        }

        return count >= cars;
    }
    public long repairCars(int[] ranks, int cars) {
        long n = ranks.length;
        long st = 0;
        long end = Long.MAX_VALUE;

        long mid = 0;
        long ans = 0;

        while(st < end){
            mid = st + (end - st)/2;

            if(helper(ranks, cars, mid)){
                ans = mid;
                end = mid;
            } else{
                st = mid + 1;
            }
        }

        return ans;  
    }
}