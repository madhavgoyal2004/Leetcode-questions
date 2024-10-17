class Solution {
    public int maximumSwap(int num) {
        if(num <= 9) return num;
        int l = 0;
        int number = num;
        while (number > 0){
            l++;
            number/= 10;
        }
        // System.out.println(l);
        
        int [] arr = new int[l];

        int n = l-1;
        int n_num = num;
        while (num > 0){
            arr[n] = num % 10;
            n--;
            num /= 10;
        }

        // System.out.println(Arrays.toString(arr));

        int p = -1;
        boolean f = true;
        for(int i=0;i<l && f; i++){
            // System.out.println(i +" p");
            for(int j =i+1; j<l && f; j++){
                if(arr[i] < arr[j]){
                    p = i;
                    f = false;
                    break;
                }
            }
        }
        // System.out.println(p);

        if(p == -1) return n_num;
        
        int max = Integer.MIN_VALUE;
        int q = -1;
        for(int i=l-1; i>=p; i--){
            if(arr[i] > max){
                max = arr[i];
                q = i;
            }
        }
        // System.out.println(max +" " + q);

        int temp = arr[p];
        arr[p] = arr[q];
        arr[q] = temp;

        num = 0;
        for(int i=0; i<l ;i++){
            num = num*10 + arr[i];
        }

        return num;
    }
}