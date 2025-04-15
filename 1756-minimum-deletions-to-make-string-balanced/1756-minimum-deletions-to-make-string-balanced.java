class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int i=0; 
        int counta = 0;
        while(i<n){
            if(s.charAt(i) == 'a'){
                counta++;
            }
            i++;
        }

        int countb = 0;
        i = 0;
        int count = counta + countb;
        while(i < n){
            if(s.charAt(i) == 'b') countb++;
            else counta--;

            count = Math.min(count, counta + countb);
            i++;
        }


        return count;
    }
}