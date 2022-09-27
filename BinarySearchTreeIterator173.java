// not the best solution
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
class BSTIterator {

    private Deque<TreeNode> stack = new LinkedList();
    private TreeNode nextNode = null;
        
    public BSTIterator(TreeNode root) {
        stack.push(root);
        findNext();
    }
    
    public int next() {
        int res = -nextNode.val - 1;
        findNext();
        return res;
    }
    
    public void findNext() {
        nextNode = next(stack.peek());
        if (nextNode != null) nextNode.val = -nextNode.val - 1;
    }
    
    public boolean hasNext() {
        return nextNode != null;
    }
    
    private TreeNode next(TreeNode node) {
        if (node == null) return null;
        if (node.val >= 0) { // not visited
            if (node.left != null && node.left.val >= 0) {
                stack.push(node.left);
                return next(node.left);
            } else {
                return node;
            }
        } else {
            if (node.right != null && node.right.val >= 0) {
                stack.push(node.right);
                return next(node.right);
            } else {
                stack.pop();
                return next(stack.peek());
            }
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
