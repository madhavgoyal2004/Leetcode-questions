class Solution {
    public int romanToInt(String s) {
        HashMap<Character , Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        Stack<Integer> st = new Stack <>();

        for(int i=0; i<s.length(); i++){
            int val = map.get(s.charAt(i));
            if(!st.isEmpty() && st.peek() < val){
                int a = st.pop();
                st.push(val - a);
                continue;
            }
            st.push(val);
        }

        int sum = 0; 
        while(!st.isEmpty()){
            sum += st.pop();
        }

        return sum;
    }
}