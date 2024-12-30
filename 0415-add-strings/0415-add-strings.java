class Solution {
    public String addStrings(String num1, String num2) {
        int m = num1.length();
        int n = num2.length(); 
        int i=m-1;
        int j=n-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 && j >= 0){
            int c1 = num1.charAt(i) - '0';
            int c2 = num2.charAt(j) - '0';

            int sum = c1 + c2 + carry;
            sb.insert(0, sum % 10);
            carry = sum / 10;

            i--;
            j--;

        }

        while (i >= 0){
            int c = num1.charAt(i) -'0';
            int sum = c + carry;
            sb.insert(0, sum % 10);
            carry = sum / 10;
            i--;
        }
        while (j >= 0){
            int c = num2.charAt(j) -'0';
            int sum = c + carry;
            sb.insert(0, sum % 10);
            carry = sum / 10;
            j--;
        }
        if(carry != 0) sb.insert(0, carry);

        return sb.toString();
    }
}