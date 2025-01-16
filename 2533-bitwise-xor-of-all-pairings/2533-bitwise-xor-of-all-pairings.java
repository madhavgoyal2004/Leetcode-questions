class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length; 
        int m = nums2.length;
        int xor1 = nums1[0];
        int xor2 = nums2[0];

        int i=1; 
        while(i < n){
            xor1 ^= nums1[i++];
        }
        int j=1; 
        while(j < m){
            xor2 ^= nums2[j++];
        }

        if(n % 2 == 0 && m%2 == 0){
            return 0;
        }
        else if(n%2 == 0){
            return xor1;
        }
        else if(m % 2 == 0){
            return xor2;
        }
        return xor1^xor2;
    }
}