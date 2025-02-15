class Solution {
    int sum = 0;
    public boolean check(int n, String s, int sum){ 
        if(s.length() == 0){
            // System.out.println(sum);
            if(sum == n){
                return true;
            }
            sum = 0;
            return false;
        }
        boolean flag = false;
        for(int i=0; i<s.length(); i++){  
            String t = s.substring(0, i+1);
            // System.out.println("t " + t);
            int num = Integer.parseInt(t);
            // System.out.println("n " + num);
            // sum += num;
            // System.out.println("s " + sum);
            flag = flag || check(n, s.substring(i+1), sum + num);
            // System.out.println(flag);
            if(flag) return flag;
        }
        return flag;
    }
    public int punishmentNumber(int n) {
        // boolean flag = check(10, "100");
        // System.out.println(flag);
        int sum = 0;
        for(int i=1 ; i<=n ; i++){
            String s = String.valueOf(i*i);
            boolean flag = check(i, s, 0);
            // System.out.println(flag);
            if(flag) {
                // System.out.println(i);
                sum += i*i;
            }
        }
        return sum;
    }
}