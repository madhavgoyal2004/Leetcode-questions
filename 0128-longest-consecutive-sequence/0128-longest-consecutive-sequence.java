class Solution {
    public int longestConsecutive(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i : map.keySet()){
            arr.add(i);
        }
        if(arr.isEmpty()) return 0;

        int max = 0;
        int count = 1;
        int i = 1;

        while(i < arr.size()){
            if(arr.get(i) - arr.get(i-1) == 1){
                count++;
            }
            else{
                max = Math.max(max, count);
                count = 1;
            }
            i++;
        }

        max = Math.max(max, count);

        return max;
    }
}