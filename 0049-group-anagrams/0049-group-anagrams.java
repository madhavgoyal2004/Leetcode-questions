class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            String key = findKey(str);

            if(map.containsKey(key)){
                map.get(key).add(str);
            }
            else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list );
            }
        }

        List<List<String>> list = new ArrayList<>();

        for(String key : map.keySet()){
            list.add(map.get(key));
        }
        
        return list;

    }

    public String findKey(String str){
        int [] arr = new int[26];

        for(int i=0; i<str.length() ; i++){
            char ch = str.charAt(i);
            arr[ch-'a'] = arr[ch-'a'] + 1;
        }

        StringBuilder sb = new StringBuilder();
        for(int k : arr){
            sb.append(k).append("_");
        }
        return sb.toString();
    }
}