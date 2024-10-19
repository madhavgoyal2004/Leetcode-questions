class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder("0");

        while (n-- > 0){
            StringBuilder t = new StringBuilder("1");
            t.append(invert(new StringBuilder(sb)).reverse());
            sb.append(t);
        }

        return sb.charAt(k-1);
    }

    public StringBuilder invert( StringBuilder t ){
        int i=0;
        while (i < t.length()){
            if(t.charAt(i) == '0') t.setCharAt(i, '1');
            else t.setCharAt(i, '0');
            i++;
        }
        return t;
    }
}