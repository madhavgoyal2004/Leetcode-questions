class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int count1 = 0;
        for(int i : derived){
            if(i == 1) count1++;
        }
        return count1 % 2 == 0;
    }
}