class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int count = 0;
        int [] left = new int[n];
        int [] right = new int[n];
        left[0] = 0;
        count = boxes.charAt(0) == '1' ? 1:0;
        for(int i=1; i<n; i++){
            left[i] = left[i-1] + count;
            if(boxes.charAt(i) == '1'){
                count++;
            }
        }
        // System.out.println(Arrays.toString(left));
        right[n-1] = 0;
        count = boxes.charAt(n-1) == '1' ? 1:0;
        // System.out.println(count);
        for(int j=n-2; j>=0; j--){
            right[j] = right[j+1] + count;
            if(boxes.charAt(j) == '1'){
                count++;
            }
        }
        // System.out.println(Arrays.toString(right));



        for(int i=0; i<n; i++){
            left[i] += right[i];
        }
        return left;
    }
}