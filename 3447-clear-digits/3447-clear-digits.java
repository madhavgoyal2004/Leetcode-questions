class Solution {
    public String clearDigits(String s) {
        Stack<Character> st = new Stack();
        int num_count = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(st.isEmpty()){
                if(47 < c && c < 58){
                    num_count++;
                }else if(num_count > 0){
                    num_count--;
                }else{
                    st.push(c);
                }
            }
            else{
                if(47 < c && c < 58){
                    st.pop();
                }else{
                    st.push(c);
                }
            }
        }

        String t = "";
        while(!st.isEmpty()){
            t = st.pop() + t;
        }
        return t;
    }
}