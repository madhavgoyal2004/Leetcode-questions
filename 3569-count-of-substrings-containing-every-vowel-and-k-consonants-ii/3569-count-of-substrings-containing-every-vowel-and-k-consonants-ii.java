class Solution {
    public long countOfSubstrings(String word, int k) {
        return helper(word, k) - helper(word , k+1);
    }

    private long helper(String word, int k){
        int n = word.length();
        HashMap<Character, Integer> map = new HashMap<>();

        int i=0; 
        int j=0;
        int cons = 0;
        long count = 0;

        while(j < n){
            char currchar = word.charAt(j);
            if(currchar == 'a' || currchar == 'e' || currchar == 'i' || currchar == 'o' || currchar == 'u'){
                map.put(currchar, map.getOrDefault(currchar, 0) + 1);
            } else {
                cons++;
            }

            while(map.size() == 5 && cons >= k){
                count += n - j;
                char cc = word.charAt(i);
                if(cc == 'a' || cc == 'e' || cc == 'i' || cc == 'o' || cc == 'u'){
                    map.put(cc, map.get(cc) - 1);
                    if(map.get(cc) == 0) map.remove(cc);
                } else {
                    cons--;
                }
                i++;
            }
            j++;
        }

        return count;
    }
}