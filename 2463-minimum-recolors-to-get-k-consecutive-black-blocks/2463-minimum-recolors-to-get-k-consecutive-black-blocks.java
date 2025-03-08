class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int i=0; 
        int j=0;
        int count = 0;
        int min = Integer.MAX_VALUE;
        
        while(j < n){
            if(blocks.charAt(j) == 'W'){
                count++;
            }
            if(j-i+1 == k) min = Math.min(min, count);

            while(i < n && j-i+1 >= k){
                if(blocks.charAt(i) == 'W') count--;
                i++;
            }
            j++;
        }

        return min;
    }
}