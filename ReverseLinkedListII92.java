public class ReverseLinkedListII92 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(
                new ListNode(1,2,3,4,5),
                2, 4,
                new ListNode(1,4,3,2,5)
            ),
            new TestCase(
                new ListNode(5),
                1, 1,
                new ListNode(5)
            ),
            new TestCase(
                new ListNode(1,2,3),
                3, 3,
                new ListNode(1,2,3)
            )
        };

        for (TestCase c: cases) {
            System.out.println(c);
            ListNode actual = new Solution().reverseBetween(c.head, c.left, c.right);
            System.out.println("actual " + actual);
            if (!c.expected.equals(actual)) {
                System.out.println("Error");
                return;
            }
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    ListNode(int... values) {
        this.val = values[0];
        ListNode t = this;
        for (int i = 1; i < values.length;  i++) {
            t.next = new ListNode(values[i]);
            t = t.next;
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode t = this;

        while (t != null) {
            sb.append(t.val).append(", ");
            t = t.next;
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        ListNode a = this;
        ListNode b = (ListNode)obj;

        while (a != null && b != null && a.val == b.val) {
            a = a.next;
            b = b.next;
        }

        return a == null && b == null;
    }
}

class TestCase {
    public ListNode head;
    public int left;
    public int right;
    public ListNode expected;

    public TestCase(ListNode head, int left, int right, ListNode expected) {
        this.head = head;
        this.left = left;
        this.right = right;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        sb.append(head);
        sb.append("\n");
        sb.append(left);
        sb.append("\n");
        sb.append(right);
        sb.append("\n");
        sb.append("expected: ").append(expected);
        return sb.toString();
    }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode node = head;
        ListNode prev = null;
        ListNode start = null;
        ListNode first = null;

        for (int i = 1; i <= right; i++) {
            ListNode next = node.next;
            if (i == left) {
                start = prev;
                first = node;
            }
            if (i > left && i <= right) {
                node.next = prev;
            }
            if (i == right) {
                first.next = next;
                if (start == null) {
                    head = node;
                } else {
                    start.next = node;
                }
            }

            prev = node;
            node = next;
        }

        return head; 
    }
}
