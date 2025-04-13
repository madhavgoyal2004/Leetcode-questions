class Solution {
    public double myPow(double x, int n) {
        double res = 1;
        double mul = x;
        boolean isnegative = false;
        long num = n;
        if (num < 0){ 
            isnegative = true;
            num = num*-1;
        }
        while(num > 0){
            if(num % 2 == 1) res = (res * mul);
            mul = (mul * mul);
            num /= 2;
        }

        if(isnegative){
            res = 1/res;
        }

        return res;
    }
}