class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int n = searchWord.length();
        String[] s = sentence.split(" ");
        for(int i=0; i<s.length; i++){
            if(s[i].length() < n) continue;
            if(s[i].substring(0,n).equals(searchWord)){
                return i+1; 
            }
        }
        return -1;
    }
}