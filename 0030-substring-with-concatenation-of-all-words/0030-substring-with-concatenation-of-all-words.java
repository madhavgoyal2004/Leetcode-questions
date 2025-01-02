class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        int wordlength = words[0].length();
        int wordcount = words.length;
        int windowsize = wordlength * wordcount;
        int slength = s.length();

        if (wordcount == 0 || slength == 0) {
            return result;
        }
        Map<String, Integer> wordfreq = new HashMap<>();
        for (String word : words) {
            wordfreq.put(word, wordfreq.getOrDefault(word, 0) + 1);
        }
        // this outer loop is well nice. it make a all possible string.
        for (int i = 0; i < wordlength; i++) {
            Map<String, Integer> currentfreq = new HashMap<>();
            int start = i;
            int count = 0;
            for (int j = i; j + wordlength <= slength; j += wordlength) {
                String word = s.substring(j, j + wordlength);
                if (wordfreq.containsKey(word)) {
                    currentfreq.put(word, currentfreq.getOrDefault(word, 0) + 1);
                    count++;

                    while (currentfreq.get(word) > wordfreq.get(word)) {
                        // remove the word which start from start index and it is also in the left.
                        String leftword = s.substring(start, start + wordlength);
                        currentfreq.put(leftword, currentfreq.get(leftword) - 1);
                        count--;
                        start += wordlength;
                    }
                    if (count == wordcount) {
                        result.add(start);
                    }
                } else {
                    currentfreq.clear();
                    count = 0;
                    start = j + wordlength;
                }
            }
        }
        return result;
    }
}