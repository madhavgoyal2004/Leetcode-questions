class Solution {
    public int countDays(int days, int[][] meetings) {
        int n = meetings.length;
        Arrays.sort(meetings, (a,b) -> a[0] - b[0]);
        int count = days;
        int start = Integer.MAX_VALUE;
        int close = 0;

        for(int i=1; i<n ;i++){
            if(close < meetings[i][1] && close < meetings[i][0] && meetings[i-1][1] < meetings[i][0]){
                if(close == 0) count -= (meetings[i-1][1] - meetings[i-1][0] + 1);
                else{
                    count -= close - start;
                    start = Integer.MAX_VALUE;
                    close = 0;
                }
            } else{
                start = Math.min(start , meetings[i-1][0]-1);
                close = Math.max(close, Math.max(meetings[i-1][1] , meetings[i][1])); 
            }
        }
        if(close == 0 && start == Integer.MAX_VALUE) count -= meetings[n-1][1] - meetings[n-1][0] + 1;
        else{
            count -= (close - start);
        }

        return count;
    }
}