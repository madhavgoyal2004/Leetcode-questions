class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Character> str = new ArrayList<>();
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                arr.add(i);
                str.add(s2.charAt(i));
            }
        }

        if(arr.size() > 2) return false;
        
        for(int i=0; i<arr.size(); i++){
            if(!str.contains(s1.charAt(arr.get(i)))){
                return false;
            }
        }

        return true;
    }
}