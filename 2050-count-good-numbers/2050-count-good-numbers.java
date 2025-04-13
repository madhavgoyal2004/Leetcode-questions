class Solution {
    long base = 1000000007;
    public long pow (int x, long y){
        long res = 1;
        long mul = x;
        while(y > 0){
            if(y % 2 == 1) res = (res * mul) % base;
            mul = (mul * mul) % base;
            y /= 2;
        }

        return res;
    }
    public int countGoodNumbers(long n) {
        if(n == 1) return 5;
        long even = (n+1)/2;
        long odd = n - even;

        int ans = (int)((pow(5, even) * pow(4,odd)) % base);
        return ans ;
    }
}