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
    int maxsum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxgain(root);
        return maxsum;
    }
    public int maxgain(TreeNode node){
        if(node==null)return 0;
        int leftgain = Math.max(maxgain(node.left),0);
        int rightgain = Math.max(maxgain(node.right),0);

        maxsum = Math.max(maxsum,leftgain + node.val + rightgain);
        return node.val + Math.max(leftgain,rightgain);
    }
}