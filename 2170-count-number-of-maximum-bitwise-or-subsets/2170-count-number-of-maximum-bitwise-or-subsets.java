class Solution {
    public void helper(int [] nums, TreeMap<Integer, List<List<Integer>>> map, List<Integer> temp, int idx){
        if(idx >= nums.length){
            return ;
        }
        for(int i=idx ; i< nums.length; i++){
            temp.add(nums[i]);
            int k = findOR(temp);
            if(map.containsKey(k)){
                map.get(k).add(new ArrayList<>(temp));
            } else{
                List<List<Integer>> list = new ArrayList<>();
                list.add(new ArrayList<>(temp));
                map.put(k, list);
            }
            helper(nums, map, temp, i+1);

            temp.remove(temp.size()-1);
        }
    }

    public int findOR(List<Integer> temp){
        int s = temp.get(0);
        for(int i=1; i<temp.size(); i++){
            s = s|temp.get(i);
        }
        return s;
    }
    public int countMaxOrSubsets(int[] nums) {
        TreeMap<Integer, List<List<Integer>>> map = new TreeMap<>((a,b) -> b-a);
        List<Integer> list = new ArrayList<>();
        helper(nums, map , list, 0);
        // System.out.println(map);
        return map.get(map.firstKey()).size();

    }
}