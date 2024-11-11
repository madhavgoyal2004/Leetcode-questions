class Solution {
    Boolean [][] dp;
    public boolean find(ArrayList<Integer>list, int [] nums, int idx, int p){
        if(nums.length == idx) return true;
        if(dp[idx][p] != null) return dp[idx][p];
        if(nums[idx] > p){
            if(find(list, nums, idx+1, nums[idx])) return dp[idx][p] = true;
        }
        
        for(int i=list.size()-1; i>=0; i--){
            if(nums[idx] > list.get(i) && nums[idx] - list.get(i) > p){
                if(find(list, nums, idx+1, nums[idx] - list.get(i))) return dp[idx][p] = true;
            }
        }

        return dp[idx][p] = false;
    }

    public boolean primeSubOperation(int[] nums) {
        int m = nums[0];
        if(nums.length == 1) return true;
        for(int i=1; i<nums.length; i++){
            if(nums[i] == 1) return false;
            m = Math.max(m, nums[i]);
        }
        dp = new Boolean[nums.length][m+1];
        ArrayList<Integer> list = new ArrayList<>();

        primesieve(m , list);
        // System.out.println(list);
        boolean b = find(list , nums, 0, 0);
        return b;
    }

    public void primesieve(int m, ArrayList<Integer> prime){
        boolean[] check = new boolean[m+1];

        for(int i=2; i*i < m; i++){
            if(check[i]) continue;
            for(int j=2; j*i < m; j++){
                check[j*i] = true; 
            }
        }
        

        for(int i=2; i< m; i++){
            if(!check[i]) prime.add(i);
        }
    }
}