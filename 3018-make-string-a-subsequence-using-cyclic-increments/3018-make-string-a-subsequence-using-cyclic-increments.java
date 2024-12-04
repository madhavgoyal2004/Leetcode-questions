class Solution {
    public boolean check (String s , String str){
        int i=0; 
        int j=0;
        while(i < s.length() && j < str.length()){
            if(s.charAt(i) == str.charAt(j) || (s.charAt(i) + 1) == str.charAt(j) || (s.charAt(i) == 'z' && str.charAt(j) == 'a')){
                j++;
            }
            i++;
        }
        if(j == str.length()) return true;
        return false;
    }
    public boolean canMakeSubsequence(String str1, String str2) {
        if(str2.length() > str1.length()) return false;
        if(check(str1, str2)) return true;
        
        return false;
    }
}