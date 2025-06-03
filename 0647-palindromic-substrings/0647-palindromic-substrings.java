class Solution {
    public boolean isPallindrome(int i, int j, String s){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public int countSubstrings(String s) {
        int n = s.length();
        int count = s.length();

        for(int i=0; i<n; i++){
            for(int j=i+1 ; j<n; j++){
                if(j == i+1 && s.charAt(i) == s.charAt(j)){
                    count++;
                }
                else if(isPallindrome(i, j, s)){
                    count++;
                }
            }
        }

        return count;
    }
}