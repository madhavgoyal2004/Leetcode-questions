class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        char prev = s.charAt(0);
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(prev == s.charAt(i)) count++;
            else count = 1;

            if(count < 3) sb.append(s.charAt(i));
            prev = s.charAt(i);
        }
        return sb.toString();
    }
}