class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int [][] arr = new int[m][n];
        for(int i=0; i<guards.length; i++){
            arr[guards[i][0]][guards[i][1]] = 1;
        }
        for(int i=0; i<walls.length; i++){
            arr[walls[i][0]][walls[i][1]] = 2;
        }
        for(int i=0; i<m; i++){
            boolean pick = false;
            for(int j=0; j<n; j++){
                if(arr[i][j] == 1) pick = true;
                else if(arr[i][j] == 2) pick = false;
                else if(pick == true && arr[i][j] == 0) arr[i][j] = -1;
            }
            pick = false;
            for(int j=n-1; j>=0; j--){
                if(arr[i][j] == 1) pick = true;
                else if(arr[i][j] == 2) pick = false;
                else if(pick == true && arr[i][j] == 0) arr[i][j] = -1;
            }
        }

        for(int i=0; i<n; i++){
            boolean pick = false;
            for(int j=0; j<m; j++){
                if(arr[j][i] == 1) pick = true;
                else if(arr[j][i] == 2) pick = false;
                else if(pick == true && arr[j][i] == 0) arr[j][i] = -1;
            }
            pick = false;
            for(int j=m-1; j>=0; j--){
                if(arr[j][i] == 1) pick = true;
                else if(arr[j][i] == 2) pick = false;
                else if(pick == true && arr[j][i] == 0) arr[j][i] = -1;
            }
        }

        int count = 0;
        for(int i=0; i<m ;i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] == 0) count++;
            }
        }

        return count;


    }
}