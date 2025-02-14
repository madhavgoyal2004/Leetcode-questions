class ProductOfNumbers {
    ArrayList<Integer> q;
    int prod;
    public ProductOfNumbers() {
        q = new ArrayList<>();
        prod = 1;
    }
    
    public void add(int num) {
        if(num == 0){
            q = new ArrayList<>();
            prod = 1;
            return;
        }
        prod *= num;
        q.add(prod);
    }
    
    public int getProduct(int k) {
        int n = q.size();
        if(n < k) return 0;
        int ans = q.get(n-1);
        if(n == k) return ans;
        return ans / q.get(n-1-k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */