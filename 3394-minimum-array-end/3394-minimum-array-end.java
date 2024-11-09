class Solution {
    public long minEnd(int n, int x) {
        int [] n_arr = new int[64];
        int [] x_arr = new int[64];
        n = n-1;
        for(int i=0; i<=64 ; i++){
            if(n == 0 && x == 0) break;
            if(n > 0) n_arr[i] = n & 1;
            if(x > 0) x_arr[i] = x & 1;
            n = n >> 1;
            x = x >> 1;
        }
        // System.out.println(Arrays.toString(n_arr));


        int j=0;
        for(int i=0; i<64; i++){
            if(x_arr[i] == 0) x_arr[i] = n_arr[j++];
        }
        // System.out.println(Arrays.toString(x_arr));

        long result = 0;
        for(int i=63; i>=0 ; i--){
            result = result << 1;
            result = result | x_arr[i];
        }

        return result;
    }
}