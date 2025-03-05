class Solution {
    public long coloredCells(int n) {
        if(n == 1) return 1;
        long s = (long)(n-1)*(long)(n);
        return 1 + 2*s;
    }
}