class Solution {
    public int countPalindromicSubsequence(String s) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for(int i=0; i<s.length() ; i++){
            char curr = s.charAt(i);
            if(map.containsKey(curr)){
                map.get(curr).add(i);
            }
            else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(curr , list);
            }
        }

        int count = 0;
        for(Character c : map.keySet()){
            int start = map.get(c).get(0);
            int end = map.get(c).get(map.get(c).size() - 1);
            HashSet<Character> set = new HashSet<>();
            for(int i=start + 1; i < end; i++){
                set.add(s.charAt(i));
            }
            count += set.size();
        }
        return count;
    }
}