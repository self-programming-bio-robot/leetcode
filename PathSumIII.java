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
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int rootFit = 0; 
        if (root.val == targetSum) rootFit++;
        ListNode head = new ListNode(root.val);

        return summ(root.left, targetSum, head, head, root.val) 
            + summ(root.right, targetSum, head, head, root.val) 
            + rootFit;
    }
    
    private int summ(TreeNode node, int targetSum, ListNode head, ListNode last, long sum) {
        if (node == null) return 0;

        int rootFit = 0; 
    
        last.next = new ListNode(node.val);
        last = last.next;
        
        sum += node.val;
        long j = sum;
        
        ListNode i = head;
        while (i != last) {
            if (j == targetSum) rootFit++;
            j -= i.val;
            i = i.next;
        }

        if (j == targetSum) rootFit++;
        
        int res = summ(node.left, targetSum, head, last, sum) 
            + summ(node.right, targetSum, head, last, sum) 
            + rootFit;

        return res; 
    }
}

class LinkedNode {
    public int val;
    public LinkedNode next;
    
    LinkedNode(int val) {
        this.val = val;
    }
}
