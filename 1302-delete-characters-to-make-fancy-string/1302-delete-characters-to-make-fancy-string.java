class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder(s);

        int count = 0;
        int i=1;
        for(;i<sb.length();i++){ // 4
            if(sb.charAt(i) == sb.charAt(i-1)){ // b b
                count++; // 2
            }
            else{
                count++; // 3
                if(count > 2){ //true
                    sb.delete((i-1 - (count-2)) , i-1); // 3-1 - (3-2), 3-1 = 1,2
                }
                i = i - count + 1; // 3-3+1 = 1
                count = 0; // 0
            }
        }
        count++;
        if(count > 2){ //true
            sb.delete((i-1 - (count-2)) , i-1); // 3-1 - (3-2), 3-1 = 1,2
        }

        return sb.toString();
    }
}