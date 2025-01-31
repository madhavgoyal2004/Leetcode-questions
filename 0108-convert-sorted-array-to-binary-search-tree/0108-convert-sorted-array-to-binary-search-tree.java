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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        TreeNode root = find(nums, 0, nums.length - 1);
        return root;
    }
    public TreeNode find(int [] nums, int st, int end){
        if(st > end){
            return null;
        }
        int mid = st + (end - st)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = find(nums, st, mid-1);
        node.right = find(nums, mid + 1, end);
        return node;
    }
}