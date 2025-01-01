class Solution {
    public void find(String s, int k, String ans, String [] t, boolean [] check, int[] count){
        if(s.length() == 0){
            count[0]++;
            if(k == count[0]){
                t[0] = ans;
                check[0] = true;
            }
            return;
        }

        for(int i=0; i<s.length();i++){
            char curr = s.charAt(i);

            String temp = s.substring(0, i) + s.substring(i+1);
            find(temp, k, ans + curr, t, check, count);
            if(check[0]) return;
        }
        
    }
    public String getPermutation(int n, int k) {
        String s = "";
        for(int i=1; i<=n; i++){
            s += i;
        }
        String [] t = new String[1];
        int [] count = new int[1];
        boolean [] check = new boolean [1];
        find(s , k, "", t, check, count);
        return t[0];
    }
}