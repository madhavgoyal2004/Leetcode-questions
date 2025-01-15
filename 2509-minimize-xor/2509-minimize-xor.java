class Solution {
    public int minimizeXor(int num1, int num2) {

        // System.out.println(count_1);
        // System.out.println(count);


        String s_num1 = Integer.toBinaryString(num1);
        String s_num2 = Integer.toBinaryString(num2);

        System.out.println(s_num1);
        System.out.println(s_num2);

        // int [] arr = new int[s_num1.length()];

        // return 0;


        int [] arr1 = new int[32];

        int cnt1 = 0 , cnt2 = 0;

        cnt1 = Integer.bitCount(num1);
        cnt2 = Integer.bitCount(num2);
        System.out.println(cnt1);
        System.out.println(cnt2);

        if(cnt1 == cnt2) return num1;

        int diff = cnt2 - cnt1;

        int num = num1;
        int i =31;
        while(num > 0){
            arr1[i--] = num & 1;
            num = num >> 1; 
        }

        for(int j=31; j>=0 ; j--){
            if(diff == 0) break;
            
            if(diff > 0 && arr1[j] == 0){
                arr1[j] = 1;
                diff--;
            } 
            else if(diff < 0 && arr1[j] == 1){
                arr1[j] = 0;
                diff++;
            }
        }
        System.out.println(Arrays.toString(arr1));


        num = 0;
        i=0;
        while(i <= 31){
            num = arr1[i++] + (num << 1);
        }

        return num;
    }
}