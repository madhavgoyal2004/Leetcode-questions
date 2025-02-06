class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        if(n < 4) return 0;
        HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int sum = nums[i]*nums[j];
                if(map.containsKey(sum)){
                    map.get(sum).add(new int [] {i,j});
                }
                else{
                    ArrayList<int []> arr = new ArrayList<>();
                    arr.add(new int [] {i, j});
                    map.put(sum, arr);
                }
            }
        }

        for(int i : map.keySet()){
            int size = map.get(i).size();
            if(size >= 2){
                count += (size*(size-1))/2; 
            }
        }

        return count*8;
    }
}