class Solution {
    public boolean canDistribute(int [] quantities, int mid, int n){
        int sum = 0;
        for(int i : quantities){
            // if(i % mid == 0) sum += i/(double)mid;
            // else sum += (i/(double)mid + 1);
            sum += (i+mid-1)/mid;
        }

        return sum <= n;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int st = 1;
        int end = Integer.MIN_VALUE;
        int mid = 0;

        // System.out.println(Arrays.toString(quantities));
        for(int i : quantities){
            end = Math.max(end , i);
        }
        if(n == quantities.length) return end;
        int ans = 0;
        while (st <= end){
            mid = st + (end - st)/2;

            if(canDistribute(quantities, mid, n)){
                ans = mid;
                end = mid - 1;
            }
            else{
                st = mid + 1;
            }
        }
        return ans ;
    }
}