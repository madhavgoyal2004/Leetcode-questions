class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int [] arr = new int[26];
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            arr[c-'a']++;
        }

        int mod = 1000000007;
        int max = 0;
        int j = 0;
        while(j++ < t){
            int count_z = 0;
            for(int i=25; i>0; i--){
                if(i == 25){
                    count_z = arr[i];
                }
                arr[i] = arr[i-1];
            }
            arr[0] = 0;
            if(count_z != 0){
                arr[0] = count_z;
                arr[1] = (arr[1] + count_z) % mod;
            }
        }

        for(int i : arr){
            max = (max + i) % mod;
        }

        return max;

    }
} 