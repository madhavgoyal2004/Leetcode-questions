class Solution {
    // buy == 0 buy the stock recently
    // buy == 1 sell the stock recently
    // trans => transaction number 0 and 2 for Buy and 1 and 3 for sell;
    public int find(int [] prices, int ind, int trans, int [][] dp){
        if(ind >= prices.length ){
            return  0;
        }
        if(trans >= 4){
            return 0;
        }

        if(dp[ind][trans] != -1) return dp[ind][trans] ;

        if(trans % 2 == 0){
            int kharida = -prices[ind] + find(prices, ind+1, trans + 1, dp);
            int nhi_kharida = 0 + find(prices, ind + 1, trans , dp);
            return dp[ind][trans] = Math.max(kharida, nhi_kharida);
        }else {
            int becha = prices[ind] + find(prices, ind+1, trans+1, dp);
            int nhi_becha = 0 + find(prices, ind + 1, trans, dp);
            return dp[ind][trans] = Math.max(becha, nhi_becha);
        }

    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][] dp = new int[n+1][4];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return find(prices, 0, 0, dp);
        

    }
}