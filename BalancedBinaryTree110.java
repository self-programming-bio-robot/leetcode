class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        int leftDeep = root.left == null ? 0 : root.left.val;
        int rightDeep = root.right == null ? 0 : root.right.val;
        root.val = Math.max(leftDeep, rightDeep) + 1;

        return left && right && Math.abs(leftDeep - rightDeep) < 2;
    }
}
