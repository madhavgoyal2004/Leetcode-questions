class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);

        int n = satisfaction.length;

        if(satisfaction[n-1] <= 0) return 0;

        int multiplier = 1;
        int st = -1;
        int sum = 0;
        int ans = 0;
        for(int i=0; i<n; i++){
            if(satisfaction[i] >= 0){
                if(st == -1) st = i;
                ans += multiplier*satisfaction[i];
                sum += satisfaction[i];
                multiplier++;
            }
        }

        int max = ans;
        for(int i=st-1; i>=0; i--){
            ans = ans + sum + satisfaction[i];
            max = Math.max(ans, max);
            sum = sum + satisfaction[i];
        }

        return max;
    }
}