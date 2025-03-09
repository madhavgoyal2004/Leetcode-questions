class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int ele = colors[0];
        int size = 1;
        int i = 1;
        int j = 0;
        int pairs = 0;
        while(j<n){
            while(size<k && (ele^colors[i%n])!=0){
                ele = colors[i%n];
                size++;
                i++;
            }
            if(size==k){
                pairs++;
                size--;
                j++;
            } else{
                ele = colors[i%n];
                j = i;
                size = 1;
                i++;
            }
        }
        return pairs;
    }
}