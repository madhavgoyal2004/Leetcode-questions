class Solution {
    public int findsum(int num){
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    public int maximumSum(int[] nums) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int sum = findsum(nums[i]);
            if(map.containsKey(sum)){
                PriorityQueue<Integer> pq = map.get(sum);
                if(pq.size() < 2){
                    pq.add(nums[i]);
                } else{
                    int a = pq.peek();
                    if(a < nums[i]){
                        pq.poll();
                        pq.add(nums[i]);
                    }
                }
            }else{
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                pq.add(nums[i]);
                map.put(sum, pq);
            }
        }

        // System.out.println(map);

        int max = Integer.MIN_VALUE;
        for(int num : map.keySet()){
            PriorityQueue<Integer> pq = map.get(num);
            if(pq.size() == 2){
                int a = pq.poll();
                int b = pq.poll();
                max = Math.max(max, a+b);
            }
        }

        return max == Integer.MIN_VALUE ? -1 : max;
    }
}