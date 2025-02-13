class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(long i : nums){
            pq.add(i);
        }

        while(pq.size() > 1 && pq.peek() < k){
            long a = pq.poll();
            long b = pq.poll();
            long find = Math.max(a,b) + Math.min(a,b)*2;
            pq.add(find);
        }

        return n - pq.size();
    }
}