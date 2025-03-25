class Solution {
    public boolean check(int [][] rectangles, int row, int col){
        ArrayList<int []> list = new ArrayList<>();
        list.add(new int [] {rectangles[0][row], rectangles[0][col]});
        for(int i = 1; i<rectangles.length; i++){
            int [] arr = rectangles[i];
            int a = arr[row];
            int b = arr[col];
            int [] temp = list.get(list.size()-1);

            if(temp[1] <= a){
                list.add(new int [] {a,b});
            }
            else{
                temp[1] = Math.max(temp[1] , b);
            }
        }
        return list.size() >= 3;
    }
    
    public boolean checkValidCuts(int n, int[][] rectangles) {
        Arrays.sort(rectangles, (a,b) -> a[0] - b[0]);

        if(check(rectangles, 0, 2)) return true;

        Arrays.sort(rectangles, (a,b) -> a[1] - b[1]);

        if(check(rectangles, 1, 3)) return true;
        return false;
    }
}