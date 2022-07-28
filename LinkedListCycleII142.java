public class LinkedListCycleII142 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {}; //todo: add test

        for (TestCase c: cases) {
            System.out.println(c);
            ListNode actual = new Solution().detectCycle(c.list);
            System.out.println("actual " + actual);
            if (c.expected = actual) return;
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

i        while (t != null) {
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

public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> viewed = new HashSet();
        
        while (head != null) {
            if (viewed.contains(head)) {
                return head;
            }
            viewed.add(head);
            head = head.next;
        }
        return null;
    }
}
