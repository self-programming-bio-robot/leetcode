public class MergeTwoSortedLists21 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(new ListNode(1, 2, 4), new ListNode(1, 3, 4), 
                    new ListNode(1, 1, 2, 3, 4, 4)),
            new TestCase(null, null, null),
            new TestCase(null, new ListNode(0), new ListNode(0))
        };

        for (TestCase c: cases) {
            System.out.println(c);
            ListNode actual = new Solution().mergeTwoLists(c.a, c.b);
            System.out.println("actual " + actual);
            if (c.expected == null && actual != null 
                    || c.expected != null && !c.expected.equals(actual)) return;
        }
    }
}

class TestCase {
    public ListNode a;
    public ListNode b;
    public ListNode expected;

    public TestCase(ListNode a, ListNode b, ListNode expected) {
        this.a = a;
        this.b = b;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        sb.append(a).append(" ").append(b);
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode res = null;
        ListNode head = null;

        while (list1 != null || list2 != null) {
            int min;
            if (list1 == null || list2 != null && list1.val > list2.val) {
                min = list2.val;
                list2 = list2.next;
            } else {
                min = list1.val;
                list1 = list1.next;
            }
            ListNode next = new ListNode(min);
            if (res != null) {
                res.next = next;
            } else {
                head = next;
            }

            res = next;
        }

        return head;       
    }
}
