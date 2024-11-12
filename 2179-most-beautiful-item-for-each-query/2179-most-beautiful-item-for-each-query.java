class Solution {
    public int bs (int [] max ,int [][] items,  int target){
        int i=0;
        int j=items.length-1;
        int mid = 0;
        int ans = 0;
        while (i <= j){
            mid = i + (j-i)/2;
            if(items[mid][0] <= target){
                ans = max[mid];
                i = mid +1;
            }
            else if(items[mid][0] > target){
                j = mid - 1;
            }
        }

        return ans;
    }
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int [] arr = new int[queries.length];
        Arrays.sort(items, (a,b) -> (a[0] - b[0]));
        int [] max = new int[items.length];
        max[0] = items[0][1];
        for(int i=1; i<items.length; i++){
            max[i] = Math.max(max[i-1], items[i][1]);
        }
        for(int i=0;i<queries.length; i++){
            arr[i] = bs(max, items,  queries[i]);
        }
        return arr;
    }
}