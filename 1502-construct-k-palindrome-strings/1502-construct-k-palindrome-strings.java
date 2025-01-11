class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length() < k) return false;
        if(s.length() == k) return true;
        int [] arr = new int[26];
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            arr[c-'a']++;
        }
        // System.out.println(map);
        int count = 0;
        for(int i=0; i<26; i++){
            if(arr[i] % 2 == 1){
                count++;
            }
        }
        
        return count <= k;
    }
}