class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> list = new ArrayList<>();
        double N = Math.log(bound);
        double D = Math.log(x);
        int a = 0, b = 0;
        if(x >= 2) a = (int)(N / Math.log(x));
        if(y >= 2) b = (int)(N / Math.log(y));

        System.out.println(Math.log(1));

        for(int i=0; i<=a; i++){
            for(int j=0; j<=b; j++){
                int c = (int)(Math.pow(x, i) + Math.pow(y,j));
                if(c <= bound && !list.contains(c)) list.add(c);
            }
        }
        return list;
    }
}