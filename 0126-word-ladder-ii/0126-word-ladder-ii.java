class Solution {
    public void dfs(String beginWord, String endWord, List<List<String>> list, List<String> temp, HashMap<String, Integer> map){
        if(beginWord.equals(endWord)){
            temp.add(0, beginWord);
            list.add(new ArrayList<>(temp));
            return;
        }

        temp.add(0, endWord);
        for(int i=0; i<endWord.length(); i++){
            char currchar = endWord.charAt(i);
            for(char j = 'a'; j<='z'; j++){
                String t = endWord.substring(0,i) + j + endWord.substring(i+1);
                if(map.containsKey(t) && map.get(t) + 1 == map.get(endWord)){
                    dfs(beginWord, t, list, temp, map);
                    temp.remove(0);
                }
            }
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    
        List<List<String>> list = new ArrayList<>();
        if(!wordList.contains(endWord)) return list;
        HashSet<String> set = new HashSet<>();
        for(String s : wordList){
            set.add(s);
        }

        Queue<String> q = new LinkedList<>();
        HashMap<String , Integer> map = new HashMap<>();
        map.put(beginWord, 0);
        int idx = 1;
        q.add(beginWord);

        while(!q.isEmpty()){

            int size = q.size();
            while(size-- > 0){
                String curr = q.poll();

                for(int i=0; i<curr.length(); i++){
                    char currchar = curr.charAt(i);
                    for(char j = 'a'; j<='z'; j++){
                        String t = curr.substring(0,i) + j + curr.substring(i+1);
                        if (set.contains(t)){
                            if(t.equals(beginWord)){
                                map.put(t, 0);
                            }else{
                                map.put(t, idx);
                            }
                            q.add(t);
                            set.remove(t);
                        }
                    }
                }

            }
            idx++;
        }

        List<String> temp = new ArrayList<>();

        dfs(beginWord, endWord, list, temp, map);


        return list;
    }
}