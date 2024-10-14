class Solution {
    public int firstUniqChar(String s) {
        int result = Integer.MAX_VALUE;

        for(int i=0;i<26; i++){
            char ch = (char)(i+97);
            if(s.indexOf(ch) != -1 && s.indexOf(ch) == s.lastIndexOf(ch)){
                result = Math.min(result, s.indexOf(ch));
            }
        }

        return (result == Integer.MAX_VALUE) ? -1 : result;
    }
}