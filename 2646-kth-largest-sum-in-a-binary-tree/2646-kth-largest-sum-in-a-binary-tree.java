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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        List<Long> sum = new ArrayList<>();
        int level = 0;
        List<List<Integer>> list = new ArrayList<>();
        while (!q.isEmpty()){
            list.add(new ArrayList<>());
            int size = q.size();

            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                list.get(level).add(curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            level++;
        }

        for(int i=0; i<list.size(); i++){
            long s = 0;
            for(int ele : list.get(i)){
                s += ele;
            }
            sum.add(s);
        }

        Collections.sort(sum);

        if(k > list.size()) return -1;
        return sum.get(sum.size() - k);
        
    }
}