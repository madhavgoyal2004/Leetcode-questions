class Solution {
    public String compressedString(String word) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<word.length(); i++){
            char a = word.charAt(i-1);
            char b = word.charAt(i);
            if(a == b && count < 8){
                count++;
            }
            else{
                count++;
                sb.append(count + "" + a);
                count = 0;
            }
        }

        count++;
        sb.append(count + "" + word.charAt(word.length()-1));
        

        return sb.toString();
    }
}