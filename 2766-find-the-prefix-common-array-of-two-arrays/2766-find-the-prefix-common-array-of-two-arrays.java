class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        // HashSet<Integer> setA = new HashSet<>();
        // HashSet<Integer> setB = new HashSet<>();
        boolean [] A1 = new boolean[n+1];
        boolean [] B1 = new boolean[n+1];
        int [] ans = new int[n];
        
        for(int i=0; i<n; i++){
            A1[A[i]] = true;
            B1[B[i]] = true;
            ans[i] = intersection(A1 , B1);
        }

        return ans;
    }
    public int intersection(boolean [] A1 , boolean [] B1){
        int count=0;
        for(int i=0; i<A1.length; i++){
            if(A1[i] && B1[i]){
                count++;
            }
        }

        return count;
    }
}