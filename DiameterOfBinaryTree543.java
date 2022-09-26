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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        
        int leftDeep = root.left == null ? 0 : root.left.val;
        int rightDeep = root.right == null ? 0 : root.right.val;
        root.val = Math.max(leftDeep, rightDeep) + 1;
        return Math.max(Math.max(left, right), leftDeep + rightDeep);
    }
}
