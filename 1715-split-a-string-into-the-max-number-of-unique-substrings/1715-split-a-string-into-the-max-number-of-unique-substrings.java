class Solution {
    int ans = 0;
    public void helper(String s, HashSet<String> set){
        if(s.length() <= 0){
            ans = Math.max(ans,set.size());
            return ;
        }
        for(int i=0; i<=s.length(); i++){
            String t = s.substring(0,i);
            if(!set.contains(t) && !t.isEmpty()){
                set.add(t);
                helper(s.substring(i), set);
                set.remove(t);
            }
        }

    }
    public int maxUniqueSplit(String s) {
        helper(s, new HashSet<>());
        return ans;
    }
}