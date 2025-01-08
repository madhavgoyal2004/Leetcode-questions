class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for(int i=0; i<words.length; i++){
            for(int j=i+1; j<words.length; j++){
                String a = words[i];
                String b = words[j];
                if(b.startsWith(a) && b.endsWith(a)){
                    count++;
                }
            }
        }
        return count;
    }
}