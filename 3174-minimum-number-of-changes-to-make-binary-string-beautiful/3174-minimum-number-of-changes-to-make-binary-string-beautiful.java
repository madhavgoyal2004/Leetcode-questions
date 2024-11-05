class Solution {
    public int minChanges(String s) {
        int st = 0;
        int change = 0;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i-1) != s.charAt(i) && (i - st)%2 == 1){
                change++;
                st = i+1;
            }
        }

        return change;
    }
}