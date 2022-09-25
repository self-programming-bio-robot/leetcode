public class OddEvenLinkedList328 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))),
                new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(2, new ListNode(4)))))
            ),
            new TestCase(
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))),
                new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(2, new ListNode(4, new ListNode(6))))))
            ),
        };

        for (TestCase c: cases) {
            System.out.println(c);
            ListNode actual = new Solution().oddEvenList(c.head);
            System.out.println("actual " + actual);
            if (!ListNode.equals(c.expected, actual)) return;
        }
    }
}

class TestCase {
    public ListNode head;
    public ListNode expected;

    public TestCase(ListNode head, ListNode expected) {
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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        ListNode evenHead = null;
        ListNode even = null;
        ListNode last = head;
        ListNode node = head;
        int i = 0;
        while (node != null) {
            ListNode next = node.next;

            if (evenHead == null) {
                evenHead = next;
                even = next;
            } else {
                even.next = next;
                even = next;
            }

            last = node;
            if (next != null) {
                node.next = next.next;
                node = next.next; 
            } else {
                node = null;
            }
        }

        last.next = evenHead;
        return head; 
    }
}
