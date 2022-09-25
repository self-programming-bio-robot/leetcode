public class SortList148 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(ListNode.of(4,2,1,3), ListNode.of(1,2,3,4)),
            new TestCase(ListNode.of(-1,5,3,4,0), ListNode.of(-1,0,3,4,5)),
            new TestCase(ListNode.of(1,2,3,4), ListNode.of(1,2,3,4)),
        };

        for (TestCase c: cases) {
            System.out.println(c);
            ListNode actual = new Solution().sortList(c.head);
            System.out.println("actual " + actual);
            if (!ListNode.equals(c.expected, actual)) return;
        }
    }
}

class TestCase {
    public ListNode head;
    public ListNode  expected;

    public TestCase(ListNode head, ListNode  expected) {
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

class ListNode {
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

     public static ListNode of(int... nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode prev = head;
        for (int i = 1; i < nums.length; i++) {
            prev.next = new ListNode(nums[i]);
            prev = prev.next;
        }
        return head;
     }
}

class Solution {
    public ListNode sortList(ListNode head) {
        // choose pivot and seperate to 2 partition
        // sort left and right partition
        // connect left part and pivot and right part

        if (head == null) return null;

        ListNode pivot = findPivot(head);
        ListNode node = head;
        ListNode leftHead = null;
        ListNode rightHead = null;
        ListNode left = null;
        ListNode right = null;

        while (node != null) {
            if (node == pivot) {
                node = node.next;
                continue;
            }
            if (node.val > pivot.val) { // right
                if (rightHead == null) {
                    rightHead = node;
                } else {
                    right.next = node;
                }
                right = node;
            } else { // left
                if (leftHead == null) {
                    leftHead = node;
                } else {
                    left.next = node;
                }
                left = node;
            }
            ListNode buf = node;
            node = node.next;
            buf.next = null;
        }
        
        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);

        if (leftHead == null) {
            head = pivot;
        } else {
            head = leftHead;
            lastNode(head).next = pivot; // need optimize
        }
        pivot.next = rightHead;
        return head;
    }

    private ListNode lastNode(ListNode head) {
        while(head != null && head.next != null) {
            head = head.next;
        }

        return head;
    }

    private ListNode findPivot(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
