class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = answers.length;
        int sum = 0;
        for(int i=0; i<n; i++){
            map.put(answers[i], map.getOrDefault(answers[i], 0) + 1);
        }

        for(int i : map.keySet()){
            int f = map.get(i);
            int a = (f + (i+1) -1)/(i+1);
            sum += a*(i+1);
        }
        return sum;
    }
}