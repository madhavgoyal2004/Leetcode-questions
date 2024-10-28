class Solution {
    public int longestSquareStreak(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int ele : nums){
            set.add(ele);
        }

        int max = 0;
        for(int i : nums){
            int curr = 0;
            long num = i;
            while(set.contains((int)num)){
                curr++;
                num *= num;
                if(num > 1e5) break;
            }
            max = Math.max(max, curr);
        }

        return max < 2 ? -1 : max;
    }
}