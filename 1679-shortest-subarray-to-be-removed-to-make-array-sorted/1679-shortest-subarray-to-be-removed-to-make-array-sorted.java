class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int right = arr.length -1;
        int left = 0;
        while(right > 0 && arr[right] >= arr[right - 1]){
            right--;
        }
        // System.out.println(right);
        if(right == 0) return 0;

        int ans = right;
        
        while (left < right && (left == 0 || arr[left] >= arr[left - 1])){

            while (right < arr.length && arr[left] > arr[right]) right++;

            ans = Math.min(right - left - 1, ans);
            // System.out.println(left + " " + ans + " " + right);
            left++;
        }

        return ans;
    }
}