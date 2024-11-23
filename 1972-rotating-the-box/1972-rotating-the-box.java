class Solution {
    public char[][] rotateTheBox(char[][] box) {
        for(char [] arr : box){
            int i = 0;

            boolean isfirst = false;
            for(int j= arr.length-1; j>=0; j--){
                if(arr[j] == '*'){
                    i = j;
                    isfirst = false;
                }
                else if(arr[j] == '.' && !isfirst){
                    i = j; 
                    isfirst = true;
                }
                else if(arr[j] == '#' && isfirst){
                    arr[i] = arr[j];
                    arr[j] = '.';
                    i--;
                }
            }
            // System.out.println(Arrays.toString(arr));
        }

        // System.out.println(Arrays.deepToString(box));

        int n = box[0].length;
        int m = box.length;
        char [][] mat = new char[n][m];
        for(int i=0; i<n; i++){
            for(int j=m-1; j>=0; j--){
                mat[i][m-1-j] = box[j][i];
            }
        }


        return mat;
    }
}