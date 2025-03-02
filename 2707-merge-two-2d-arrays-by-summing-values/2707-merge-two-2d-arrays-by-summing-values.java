class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        ArrayList<int[]> arr = new ArrayList<>();
        int n = nums1.length;
        int m = nums2.length;

        int i=0;
        int j=0;

        while (i < n && j < m){
            int id1 = nums1[i][0];
            int id2 = nums2[j][0];

            if(id1 == id2){
                int sum = nums1[i][1] + nums2[j][1];
                arr.add(new int [] {id1, sum});
                i++;
                j++;
            }
            else if(id1 < id2){
                arr.add(nums1[i]);
                i++;
            }
            else{
                arr.add(nums2[j]);
                j++;
            }
        }

        while (i < n){
            arr.add(nums1[i]);
            i++;
        }

        while (j < m){
            arr.add(nums2[j]);
            j++;
        }

        int [][] a = new int [arr.size()][2];

        int k = 0;
        for(int [] ar : arr){
            a[k++] = ar;
        }

        return a;
    }
}