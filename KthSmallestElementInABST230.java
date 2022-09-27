class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList();
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        
        TreeNode res = null;
        for (int i = 0; i < k; i++) {
            res = next(stack);
        }
        return res.val;
    }
    
    private TreeNode next(Deque<TreeNode> stack) {
        TreeNode node = stack.pop();
        TreeNode cur = node;
        
        if (cur.right != null) {
            cur = cur.right;
            
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }
        
        return node;
    }
}
