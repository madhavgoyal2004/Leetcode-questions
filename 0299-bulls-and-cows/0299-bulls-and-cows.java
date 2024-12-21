class Solution {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        HashMap<Character, Integer> map_s = new HashMap<>();
        HashMap<Character, Integer> map_g = new HashMap<>();

        int bull = 0;
        for(int i=0; i<n; i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bull++;
            }else{
                map_s.put(secret.charAt(i), map_s.getOrDefault(secret.charAt(i), 0) + 1);
                map_g.put(guess.charAt(i), map_g.getOrDefault(guess.charAt(i), 0) + 1);
            }
        }
        // System.out.println(bull);
        // System.out.println(map_s);
        // System.out.println(map_g);

        
        int cow = 0;
        for(Character c : map_g.keySet()){
            if(map_s.containsKey(c)){
                cow += Math.min(map_s.get(c), map_g.get(c));
            }
        }
        // System.out.println(cow);

        return new String(bull + "A" + cow + "B");
    }
}