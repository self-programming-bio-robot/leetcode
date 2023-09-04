public class LinkedListCycle141 {
    public static void main(String[] args) {
        
        ListNode last = new ListNode(-4);
        ListNode head = new ListNode(3, new ListNode(2, new ListNode(0, last)));
        last.next = head.next;

        TestCase[] cases = new TestCase[] {
            new TestCase(head, true)
        };

        for (TestCase c: cases) {
            System.out.println(c);
            boolean actual = new Solution().hasCycle(c.head);
            System.out.println("actual " + actual);
            if (actual != c.expected) {
                System.out.println("Error");
                return;
            }
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
    
    ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }
}

class TestCase {
    public ListNode head;
    public boolean expected;

    public TestCase(ListNode head, boolean expected) {
        this.head = head;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        sb.append(head);
        sb.append("\n");
        sb.append("expected: ").append(expected);
        return sb.toString();
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast && slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) fast = fast.next;
        }
        return slow == fast && slow != null;
    }
}
