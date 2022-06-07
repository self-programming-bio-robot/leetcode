public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> a = new HashSet<ListNode>();
        for (ListNode i = headA; i != null; i = i.next) {
            a.add(i);
        }
        
        for (ListNode i = headB; i != null; i = i.next) {
            if (a.contains(i)) return i;
        }
        
        return null;
    }
}
