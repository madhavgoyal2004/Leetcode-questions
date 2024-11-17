class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long [] prefix = new long[n+1];
        // System.out.println(n);
        int len = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++){
            prefix[i] = nums[i-1] + prefix[i-1];
        }

        Deque<Integer> nums_idx = new ArrayDeque<>();

        for(int i=0; i<=n; i++){
            while(!nums_idx.isEmpty() && prefix[i] - prefix[nums_idx.peekFirst()] >= k){
                len = Math.min(len, i - nums_idx.pollFirst());
            }

            while(!nums_idx.isEmpty() && prefix[i] <= prefix[nums_idx.peekLast()]){
                nums_idx.pollLast();
            }

            nums_idx.offerLast(i);
        }
        return len == Integer.MAX_VALUE ? -1 : len;
    }
}