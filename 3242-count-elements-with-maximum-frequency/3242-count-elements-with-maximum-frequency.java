class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i: nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i) + 1);
            }
            else {
                map.put(i,1);
            }
        }

        int max = 0;
        int total_max = 0;
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            if(e.getValue() > max){
                max = e.getValue();
                total_max = max;
            }

            else if (e.getValue() == max){
                total_max += max;
            }
        }

        return total_max;
    }
}