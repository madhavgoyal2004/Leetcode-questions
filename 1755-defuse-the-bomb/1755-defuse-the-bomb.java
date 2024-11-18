class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        if(k == 0) return  new int[n];
        int [] arr = new int[n];
        // int sum = 0;
        if(k > 0){
            int i=0;
            int j=k;
            while(j < n + k){
                for(int a = i+1; a<=j; a++){
                    arr[i] = arr[i] + code[a%n];
                }
                i++;
                j++;
            }
        }
        else{
            k = Math.abs(k);
            int i = k;
            int j = 0;
            while(j < n){
                for(int a = i-1; a>=j; a--){
                    arr[i%n] = arr[i%n] + code[a % n];
                }
                i++;
                j++;
            }
        }

        return arr;
    }
}