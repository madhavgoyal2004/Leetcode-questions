class Solution {
    public int firstUniqChar(String s) {
        int result = Integer.MAX_VALUE;

        for(char i='a';i<='z'; i++){
            if(s.indexOf(i) != -1 && s.indexOf(i) == s.lastIndexOf(i)){
                result = Math.min(result, s.indexOf(i));
            }
        }

        return (result == Integer.MAX_VALUE) ? -1 : result;
    }
}