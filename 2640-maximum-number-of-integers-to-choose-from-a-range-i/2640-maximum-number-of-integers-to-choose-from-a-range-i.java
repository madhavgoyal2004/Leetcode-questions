class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int l = banned.length;
        int count = 0;
        long sum = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<l ;i++){
            if(banned[i] <= n)set.add(banned[i]);
        }
        for(int i=1; i<=n; i++){
            if(!set.contains(i)){
                sum += i;
                if(sum <= maxSum) count++;
                else break;
            }
        }
        return count;
    }
}