/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> reversed = new Stack();
        ListNode node = head;
        while (node != null) {
            reversed.push(node);
            node = node.next;
        }
        
        int n = reversed.size() / 2;
        for (int i = 0; i < n; i++) {
            if (reversed.pop().val != head.val) return false;
            head = head.next;
        }
        
        return true;
    }
}
