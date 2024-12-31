class Solution {
    public int countPoints(String rings) {
        int [][] dp = new int[10][3];

        for(int i=0; i<rings.length(); i+=2){
            char c = rings.charAt(i);
            int val = rings.charAt(i+1) - '0';
            if(c == 'B'){
                dp[val][0]++;
            }
            else if(c == 'R'){
                dp[val][1]++;
            }
            else{
                dp[val][2]++;
            }
        }

        int count = 0;
        for(int i=0; i<10; i++){
            int sum = Math.min(dp[i][0], Math.min(dp[i][1], dp[i][2]));
            if(sum > 0) count++;
        }

        return count;
    }
}