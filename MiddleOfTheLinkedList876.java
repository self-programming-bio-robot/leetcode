public class MiddleOfTheLinkedList876 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(new ListNode(1,2,3,4,5), new ListNode(3,4,5)),
            new TestCase(new ListNode(1,2,3,4,5,6), new ListNode(4,5,6))
        };

        for (TestCase c: cases) {
            System.out.println(c);
            ListNode actual = new Solution().middleNode(c.list);
            System.out.println("actual " + actual);
            if (!c.expected.equals(actual)) return;
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

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode node = head;
        ListNode middle = head;

        boolean add = false;
        while (node != null) {
            if (add) middle = middle.next;
            node = node.next;
            add = !add;
        }
        return middle;
    }
}
