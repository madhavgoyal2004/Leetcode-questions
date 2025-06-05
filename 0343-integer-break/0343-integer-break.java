class Solution {
    public int integerBreak(int n) {
        if(n <= 2) return 1;
        if(n == 3) return 2;
        int rem = n%3;
        int ans = 0;
        if(rem == 0){
            ans = (int)Math.pow(3,n/3);
        }
        else if(rem == 1){
            ans = (int)Math.pow(3, (n-3)/3) * 4;
        }
        else{
            ans = (int)Math.pow(3, n/3)*2;
        }

        return ans;
    }
}