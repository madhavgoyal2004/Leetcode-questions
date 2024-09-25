class Solution { 
    public List<Integer> findAnagrams(String s, String p) {
        // System.out.println(s.length());
        // System.out.println(p.length());
        HashMap<Character, Integer> map_p = new HashMap<>();
        for(int j=0; j<p.length(); j++){
            map_p.put(p.charAt(j), map_p.getOrDefault(p.charAt(j), 0) + 1);
        }
        
        // System.out.println(map_p);
        HashMap<Character, Integer> map_s = new HashMap<>();
        int i=0 ;
        int j =0;
        List<Integer> list = new ArrayList<>();
        // while (j < s.length() && j < p.length()){
        //     map_s.put(s.charAt(j), map_s.getOrDefault(s.charAt(j), 0) + 1);
        //     j++;
        // }
        boolean flag = false;
        while (j < s.length()){
            // Insertion
            flag = false;
            while( j < s.length() && !map_p.containsKey(s.charAt(j))){
                j++;
                i = j;
                flag = true;
            }
            // System.out.println(flag);
            if(flag) map_s = new HashMap<>();

            while (j < s.length() && (j - i) < p.length()){
                map_s.put(s.charAt(j), map_s.getOrDefault(s.charAt(j), 0) + 1);
                j++;
            }
            // System.out.println(map_s + "I");

            //Validation
            if(equal(map_p, map_s)){
                // System.out.println("V");
                list.add(i);
            }
            
            //Collapse
            if(j < s.length() && map_p.containsKey(s.charAt(j))){
                map_s.put(s.charAt(i) , map_s.get(s.charAt(i)) - 1);
                if(map_s.get(s.charAt(i)) == 0) map_s.remove(s.charAt(i));
                i++;
            }
            // System.out.println(map_s + "C");
            
            // if(j < s.length() && map_p.containsKey(s.charAt(j))){
            //     map_s.put(s.charAt(j), map_s.getOrDefault(s.charAt(j), 0) + 1);
            //     j++;
            //     continue;
            // }

        }

        return list;
    }

    private boolean equal(HashMap<Character, Integer> map_p, HashMap<Character, Integer> map_s){
        if(map_p.size() != map_s.size()) return false;
        for(Character c : map_p.keySet()){
            if(!map_s.containsKey(c)) return false;
                
            else{
                if(!map_s.get(c).equals( map_p.get(c))) return false;
            }
        }
        return true;
    }
}