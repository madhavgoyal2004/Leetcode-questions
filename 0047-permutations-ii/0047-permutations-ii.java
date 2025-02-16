class Solution {
    public void helper(List<Integer> nums, HashSet<List<Integer>> list, List<Integer> temp){
        if(nums.size() == 0){
            list.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0; i<nums.size(); i++){
            int num = nums.remove(i);
            int k = i;
            temp.add(num);
            helper(nums, list, temp);
            temp.remove(temp.size()-1);
            nums.add(k, num);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> l = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            l.add(nums[i]);
        }
        HashSet<List<Integer>> set = new HashSet<>();
        helper(l, set, new ArrayList<>());
        List<List<Integer>> list = new ArrayList<>();
        for(List<Integer> i : set){
            list.add(i);
        }
        return list;
    }
}