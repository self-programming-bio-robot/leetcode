import java.util.Arrays;

public class SplitLinkedListInParts725 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(ListNode.from(1,2,3), 5, 
                    new ListNode[] { 
                        ListNode.from(1),
                        ListNode.from(2),
                        ListNode.from(3),
                        null,
                        null
                    }
            ),
            new TestCase(ListNode.from(1,2,3,4,5,6,7,8,9,10), 3, 
                    new ListNode[] { 
                        ListNode.from(1,2,3,4),
                        ListNode.from(5,6,7),
                        ListNode.from(8,9,10)
                    }
            )
        };

        for (TestCase c: cases) {
            System.out.println(c);
            ListNode[] actual = new Solution().splitListToParts(c.head, c.k);
            System.out.println("actual " + Arrays.toString(actual));
            if (!Arrays.equals(c.expected, actual)) {
                System.out.println("Error");
                return;
            }
        }
    }
}

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode from(int... nums) {
        ListNode result = new ListNode(nums[0]);
        ListNode node = result;
        for (int i = 1; i < nums.length; i++) {
            ListNode next = new ListNode(nums[i]);
            node.next = next;
            node = next;
        }
        return result;
    }

    @Override
    public String toString() {
        return val + ((next != null) ? ", " + next.toString() : ";");
    }

    @Override
    public int hashCode() {
        return val + ((next != null) ? next.hashCode() * 10 : 0);
    }

    @Override 
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ListNode) {
            ListNode another = (ListNode)obj;

            if (another.val == this.val) {
                if (another.next == null && this.next == null) {
                    return true;
                }
                if (another.next != null && this.next != null) {
                    return this.next.equals(another.next);
                }
            }
        }
        return false;
    }
}

class TestCase {
    public ListNode head;
    public int k;
    public ListNode[] expected;

    public TestCase(ListNode head, int k, ListNode[] expected) {
        this.head = head;
        this.k = k;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        sb.append(head);
        sb.append("\n");
        sb.append(k);
        sb.append("\n");
        sb.append("expected: ").append(Arrays.toString(expected));
        return sb.toString();
    }
}

class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        if (head == null) {
            return new ListNode[k];
        }
        int len = getLength(head);
        int part = len / k;
        int over = len % k;
        ListNode[] result = new ListNode[k];

        result[0] = head;
        for (int i = 1; i < k; i++) {
            if (head == null) {
                result[i] = null;
                continue;
            }
            ListNode prev = head;
            for (int j = 0; j < part + Math.min(over, 1); j++) {
                prev = head;
                head = head.next;
            }
            result[i] = head;
            prev.next = null;
            over = Math.max(0, over - 1);
        }

        return result; 
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
