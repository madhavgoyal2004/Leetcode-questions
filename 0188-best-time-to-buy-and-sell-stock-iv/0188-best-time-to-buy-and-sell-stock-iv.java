class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int [][] after = new int[2][k+1];
        int [][] curr = new int[2][k+1];

        for(int ind=n-1; ind>=0; ind--){
            for(int buy=0; buy<=1; buy++){
                for(int cap=1; cap<=k; cap++){
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
        return after[1][k];
    }
}