public class RemoveNthNodeFromEndOfList19 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))),
                2,
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(5))))
            ),
            new TestCase(
                new ListNode(1),
                1,
                null
            ), 
            new TestCase(
                new ListNode(1, new ListNode(2)),
                1,
                new ListNode(1)
            ),
        };

        for (TestCase c: cases) {
            System.out.println(c);
            ListNode actual = new Solution().removeNthFromEnd(c.head, c.n);
            System.out.println("actual " + actual);
            if (!ListNode.equals(actual, c.expected)) return;
        }
    }
}

class TestCase {
    public ListNode head;
    public int n;
    public ListNode expected;

    public TestCase(ListNode head, int n, ListNode expected) {
        this.head = head;
        this.n = n;
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

public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

     public String toString() {
        StringBuilder sb = new StringBuilder();

        ListNode node = this;
        while (node != null) {
            sb.append(node.val).append(",");
            node = node.next;
        }

        return sb.toString();
     }

     public static boolean equals(ListNode a, ListNode b) {
        while (a != null && b != null) {
            if (a.val != b.val) return false;
            a = a.next;
            b = b.next;
        }

        return a == null && b == null;
     }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nth = head;
        ListNode pNth = null;
        ListNode node = head;
        int i = 0;
        while (node != null) {
            if (i >= n) {
                pNth = nth;
                nth = nth.next;
            }
            node = node.next;
            i++;
        }

        if (pNth != null) {
            pNth.next = nth.next;
        } else {
            head = nth.next;
        }
        return head;       
    }
}
