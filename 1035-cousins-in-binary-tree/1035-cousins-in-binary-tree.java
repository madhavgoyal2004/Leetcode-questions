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
    int x_label = -1;
    int y_label = -1;
    int x_parent = 0;
    int y_parent = 0;
    public boolean isCousins(TreeNode root, int x, int y) {
        HashMap<TreeNode, Integer> map = new HashMap<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int label = 0;
        while(!q.isEmpty()){
            
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                
                if(curr.left != null){
                    if(curr.left.val == x){
                        x_parent = curr.val;
                        x_label = label;
                    }
                    else if(curr.left.val == y){
                        y_parent = curr.val;
                        y_label = label;
                    }
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    if(curr.right.val == x){
                        x_parent = curr.val;
                        x_label = label;
                    }
                    else if(curr.right.val == y){
                        y_parent = curr.val;
                        y_label = label;
                    }
                    q.add(curr.right);
                }
            }
            label++;
        }

        return x_label == y_label && x_parent != y_parent;
    }
}