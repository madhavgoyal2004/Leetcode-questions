class Solution {
    // buy == 0 buy the stock recently
    // buy == 1 sell the stock recently
    public int find(int [] prices, int ind, int buy, int cap, int [][][] dp){
        if(ind >= prices.length ){
            return  0;
        }
        if(cap <= 0){
            return 0;
        }

        if(dp[ind][buy][cap] != -1) return dp[ind][buy][cap] ;

        if(buy == 1){
            int kharida = -prices[ind] + find(prices, ind+1, 0, cap, dp);
            int nhi_kharida = 0 + find(prices, ind + 1, 1, cap, dp);
            return dp[ind][buy][cap] = Math.max(kharida, nhi_kharida);
        }else {
            int becha = prices[ind] + find(prices, ind+1, 1, cap-1, dp);
            int nhi_becha = 0 + find(prices, ind + 1, 0, cap, dp);
            return dp[ind][buy][cap] = Math.max(becha, nhi_becha);
        }

    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][][] dp = new int[n+1][2][3];
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<2; j++){
        //         Arrays.fill(dp[i][j], -1);
        //     }
        // }

        // here we replace dp[ind+1] to after and dp[ind] to curr
        int [][] after = new int[2][3];
        int [][] curr = new int[2][3];

        for(int ind=n-1; ind>=0; ind--){
            for(int buy=0; buy<=1; buy++){
                for(int cap=1; cap<=2; cap++){
                    if(buy == 1){
                        int kharida = -prices[ind] + after[0][cap];
                        int nhi_kharida = 0 + after[1][cap];
                        curr[buy][cap] = Math.max(kharida, nhi_kharida);
                    }else {
                        int becha = prices[ind] + after[1][cap-1];
                        int nhi_becha = 0 + after[0][cap];
                        curr[buy][cap] = Math.max(becha, nhi_becha);
                    }
                }
            }
            after = curr;
        }
        return after[1][2];
        

    }
}