class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String, Integer> r2i = new HashMap<>();

        for(int i=0; i<recipes.length; i++){
            r2i.put(recipes[i], i);
        }

        List<String> supply = new ArrayList<>();
        for(int i=0; i<supplies.length; i++){
            supply.add(supplies[i]);
        }

        Map<String, List<String>> graph = new HashMap<>(); 

        int [] indegree = new int [recipes.length];

        for(int i =0 ; i<recipes.length; i++){
            for(String ingredient : ingredients.get(i)){
                if(!supply.contains(ingredient)){
                    graph.putIfAbsent(ingredient, new ArrayList<>());

                    graph.get(ingredient).add(recipes[i]);
                    indegree[i]++;
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<recipes.length;i ++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        List<String> maked = new ArrayList<>();

        while(!q.isEmpty()){
            int curr = q.poll();
            String recipe = recipes[curr];
            maked.add(recipe);

            if(!graph.containsKey(recipe)) continue;

            for(String nbr : graph.get(recipe)){
                if(--indegree[r2i.get(nbr)] == 0){
                    q.add(r2i.get(nbr));
                }
            }
        }

        return maked;

    }
}