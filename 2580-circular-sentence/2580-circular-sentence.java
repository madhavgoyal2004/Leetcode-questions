class Solution {
    public boolean isCircularSentence(String sentence) {
        String [] arr = sentence.split("[' ']");
        
        int i=1;
        for(; i<arr.length; i++){
            String a = arr[i-1];
            String b = arr[i];
            if(a.charAt(a.length() - 1) != b.charAt(0)){
                return false;
            }
        }
        String a = arr[i-1];
        String b = arr[0];
        if(a.charAt(a.length() - 1) != b.charAt(0)){
            return false;
        }

        return true;
    }
}