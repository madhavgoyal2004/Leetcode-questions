class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int [] temp = new int[n+1];
        int [] ans = new int[n];
        int curr = 0;
        for(int i=0; i<n; i++){
            if(++temp[A[i]] >= 2) curr++;
            if(++temp[B[i]] >= 2) curr++;
            ans[i] = curr;
        }

        return ans;
    }
}