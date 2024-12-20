/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                temp.add( curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            list.add(level, new ArrayList<>(temp));
            level++;
        }

        List<Integer> reversedlist = new ArrayList<>();
        for(int i=0; i<list.size(); i++){
            if(i % 2 == 1) {
                List<Integer> temp = list.get(i);
                int n = temp.size(); 
                for(int j = 0; j<n/2; j++){
                    int t = temp.get(j);
                    temp.set(j, temp.get(n-j-1));
                    temp.set(n-j-1, t);

                }
            }

            for(int ele : list.get(i)){
                reversedlist.add(ele);
            }

        }

        TreeNode main = createBT(reversedlist , 0);

        // System.out.println(reversedlist);
        return main;
    }

    public TreeNode createBT(List<Integer> list, int idx){
        if(list.size() <= idx) return null;

        TreeNode nn = new TreeNode(list.get(idx));

        nn.left = createBT(list, 2*idx + 1);
        nn.right = createBT(list, 2*idx + 2);

        return nn;
    }
}