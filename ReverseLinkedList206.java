public class ReverseLinkedList206 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(new ListNode(1,2,3,4,5), new ListNode(5,4,3,2,1)),
            new TestCase(new ListNode(1,2), new ListNode(2,1)),
            new TestCase(null, null)
        };

        for (TestCase c: cases) {
            System.out.println(c);
            ListNode actual = new Solution().reverseList(c.list);
            System.out.println("actual " + actual);
            if (c.expected == null && actual != null 
                    || c.expected != null && !c.expected.equals(actual)) return;
        }
    }
}

class TestCase {
    public ListNode list;
    public ListNode expected;

    public TestCase(ListNode list, ListNode expected) {
        this.list = list;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        sb.append(list);
        sb.append("\n");
        sb.append("expected: ").append(expected);
        return sb.toString();
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

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        return deep(head, null); 
    }

    private ListNode deep(ListNode node, ListNode prev) {
        ListNode next = node.next;
        node.next = prev;
        if (next == null) return node;

        return deep(next, node);
    }
}
