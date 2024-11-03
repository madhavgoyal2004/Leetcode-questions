class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;

        StringBuffer g = new StringBuffer(goal);
        int last = g.length()-1;
        int i=0;
        while(i < s.length()){
            if(g.toString().equals(s)){
                return true;
            }
            char c = g.charAt(last);
            g.deleteCharAt(last);
            g.insert(0, c);
            System.out.println(g);
            i++;
        }

        return false;
    }
}