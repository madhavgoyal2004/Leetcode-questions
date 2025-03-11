class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();

        int i=0;
        int j=0;
        int count = 0;
        
        while(j < n){
            char currchar = s.charAt(j);
            map.put(currchar, map.getOrDefault(currchar, 0) + 1);
            
            while(map.size() == 3){
                count += n - j;
                char cc = s.charAt(i);
                map.put(cc, map.get(cc) - 1); 

                if(map.get(cc) == 0) map.remove(cc);
                i++;
            }
            j++;
        }

        return count;
        
    }
}