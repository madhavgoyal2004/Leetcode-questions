class Solution {
    public boolean canConstruct(String s, int k) {
        // int [] arr = new int[26];
        // for(int i=0; i<s.length(); i++){
        //     char c = s.charAt(i);
        //     arr[c-'a']++;
        // }
        if(s.length() < k) return false;
        if(s.length() == k) return true;

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        // System.out.println(map);
        int count = 0;
        for(Character c : map.keySet()){
            if(map.get(c) % 2 == 1){
                count++;
            }
        }
        
        return count <= k;
    }
}