class Solution {
    public String RLE(String s){
        if(s.equals("1")) return "11";
        String t = "";
        int n = s.length();
        int count = 1;
        for(int i=1; i<n; i++){
            if(s.charAt(i-1) == s.charAt(i)){
                count++;
            }
            else{
                // System.out.println(count + " " + s.charAt(i-1));
                t += count +""+ s.charAt(i-1) + "";
                count = 1;
            }
        }
        t += count +""+ s.charAt(n-1) + "";
        return t;

    }
    public String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }
        String s = countAndSay(n-1);
        // System.out.println(s);

        String t = RLE(s);
        return t;

    }
}