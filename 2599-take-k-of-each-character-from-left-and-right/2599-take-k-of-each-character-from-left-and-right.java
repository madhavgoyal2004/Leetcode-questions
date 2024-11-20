class Solution {
    public int takeCharacters(String s, int k) {
        int n = s.length();
        if(3*k > n) return -1;
        int [] main = new int[3];
        for(int i=0; i<n; i++){
            main[s.charAt(i) - 'a']++;
        }
        // 8 2 2

        for(int i=0; i<3; i++){
            if(main[i] < k) return -1;
        }

        int [] window = new int[3];
        // 2 1 
        int i=0;
        int j=0;
        int len = 0;
        while(i < s.length()){
            window[s.charAt(i) - 'a']++;

            while(j <= i && (main[0]-window[0] < k || main[1] - window[1] < k || main[2] - window[2] < k)){
                window[s.charAt(j) - 'a']--;
                j++;
            }

            len = Math.max(len, i-j+1);
            // System.out.println(len);
            i++;
        }

        return n-len;
    }
}