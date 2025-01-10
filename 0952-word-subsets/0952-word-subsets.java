class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> list = new ArrayList<>();
        int [] arr = new int[26];
        for(char ch = 'a' ; ch<='z'; ch++){
            for(String a : words2){
                int count = 0;
                for(int i=0; i<a.length(); i++){
                    char c = a.charAt(i);
                    if(ch == c){
                        count++;
                        arr[ch-'a'] = Math.max(arr[ch-'a'], count);
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(arr));

        for(String b : words1){
            int [] temp = new int[26];
            for(int i=0; i<b.length(); i++){
                char c = b.charAt(i);
                temp[c-'a']++;
            }
            // System.out.println(Arrays.toString(temp));
            boolean f = true;
            for(int i=0; i<26; i++){
                if(arr[i] > 0 && temp[i] < arr[i]){
                    f = false;
                    break;
                }
            }
            if(f) list.add(b);
        }
        return list;
    }
}