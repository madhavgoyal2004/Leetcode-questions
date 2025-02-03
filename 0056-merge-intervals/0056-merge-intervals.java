class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        ArrayList<int []> arr = new ArrayList<>();
        arr.add(intervals[0]);

        
        for(int i=1; i<intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            int [] interval = arr.get(arr.size()-1);
            if(start > interval[1]){
                arr.add(intervals[i]);
            }
            else{
                interval[1] = Math.max(interval[1], end);
            }
        }
        int [][] array = new int[arr.size()][2];
        for(int i=0; i<arr.size(); i++)
        {
            array[i] = arr.get(i);
        }
        return array;
    }
}