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
    public TreeNode replaceValueInTree(TreeNode root) {
        
        HashMap<Integer, HashMap<Integer,Integer>> map = new HashMap<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        List<Integer> list = new ArrayList<>();

        while(!q.isEmpty()){
            int size = q.size();
            int sum = 0;
            for(int i=0; i<size;i++){
                TreeNode curr = q.poll();
                sum += curr.val;

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            list.add(sum);
            level++;
        } 

        // System.out.println(list);

        q.add(root);
        level = 1;
        root.val = 0;
        while (!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                int sum = 0;
                if(curr.left != null){
                    q.add(curr.left);
                    sum += curr.left.val;
                }
                if(curr.right != null){
                    q.add(curr.right);
                    sum += curr.right.val;
                }

                if(curr.left != null){
                    curr.left.val = list.get(level) - sum;
                }
                if(curr.right != null){
                    curr.right.val = list.get(level)- sum;
                }
            }
            level++;
        }

        return root;
    }
}