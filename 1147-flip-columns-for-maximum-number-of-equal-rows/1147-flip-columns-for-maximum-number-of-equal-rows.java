class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int max = 0;
        int n = matrix[0].length;

        for(int [] arr : matrix){
            int [] flip = new int[n];
            for(int i=0;i<n; i++){
                flip[i] = 1-arr[i];
            }
            
            int count = 0;
            for(int [] check : matrix){
                if(Arrays.equals(check, arr) || Arrays.equals(check, flip)) count++;
            }

            max = Math.max(count, max);
        }

        return max;
    }
}