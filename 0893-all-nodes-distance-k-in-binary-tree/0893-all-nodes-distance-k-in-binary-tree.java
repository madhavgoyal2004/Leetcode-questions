/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list = new ArrayList<>();
        if(k == 0) {
            list.add(target.val);
            return list;
        }
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        dfs(graph, root);
        find(graph, k, target.val, list);
        return list;
        
    }
    public void dfs(HashMap<Integer, HashSet<Integer>> graph, TreeNode root){
        if(root == null ) return;

        HashSet<Integer> set = graph.getOrDefault(root.val, new HashSet<Integer>());

        if(root.left != null){
            set.add(root.left.val);
            HashSet<Integer> s = graph.getOrDefault(root.left.val, new HashSet<Integer>());
            s.add(root.val);
            graph.put(root.left.val, s);
        }
        if(root.right != null){
            set.add(root.right.val);
            HashSet<Integer> s = graph.getOrDefault(root.right.val, new HashSet<Integer>());
            s.add(root.val);
            graph.put(root.right.val, s);
        }

        graph.put(root.val, set);

        dfs(graph, root.left);
        dfs(graph, root.right);
        
    }

    class Pair{
        int vtx;
        int dist;
        Pair(int vtx, int dist){
            this.vtx = vtx;
            this.dist = dist;
        }
    }

    public void find(HashMap<Integer, HashSet<Integer>> graph, int k, int tar, List<Integer> list){
        Queue<Pair> q = new LinkedList<>();
		HashSet<Integer> visited = new HashSet<>();
		q.add(new Pair(tar, 0));
		
		while (!q.isEmpty()){
			Pair curr= q.poll();
			visited.add(curr.vtx);
			for(int nbr : graph.get(curr.vtx)){
				if(!visited.contains(nbr)) q.add(new Pair(nbr, curr.dist+1));
				if(curr.dist+1==k && !visited.contains(nbr)) list.add(nbr);
			}
		}
    }
}