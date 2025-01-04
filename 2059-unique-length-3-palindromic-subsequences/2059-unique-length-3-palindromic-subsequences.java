class Solution {
    public int countPalindromicSubsequence(String s) {
        HashMap<Character, int[]> map = new HashMap<>();
        for(int i=0; i<s.length() ; i++){
            char curr = s.charAt(i);
            if(map.containsKey(curr)){
                map.get(curr)[1] = i;
            }
            else{
                int [] arr = new int[2];
                arr[0] = i;
                map.put(curr , arr);
            }
        }

        int count = 0;
        for(Character c : map.keySet()){
            int start = map.get(c)[0];
            int end = map.get(c)[1];
            HashSet<Character> set = new HashSet<>();
            for(int i=start + 1; i < end; i++){
                set.add(s.charAt(i));
            }
            count += set.size();
        }
        return count;
    }
}