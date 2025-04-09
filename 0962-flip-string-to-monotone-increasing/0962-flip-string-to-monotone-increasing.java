class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int i = 0;
        int count = Integer.MAX_VALUE;
        int count_0 = 0;
        int count_1 = 0;

        while(i < n){
            if(s.charAt(i) == '0') count_0++;
            i++;
        }

        i=0;

        count = Math.min(count, count_0 + count_1);
        while(i<n){
            if(s.charAt(i) == '0'){
                count_0--;
            } else {
                count_1++;
            }
            count = Math.min(count, count_0 + count_1);
            i++;
        }

        return count;
    }
}