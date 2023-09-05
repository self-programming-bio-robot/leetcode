public class CopyListWithRandomPointer138 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
           //todo: add some tests 
        };

        for (TestCase c: cases) {
            System.out.println(c);
            Node actual = new Solution().copyRandomList(c.head);
            System.out.println("actual " + actual);
            if (actual != c.expected) {
                System.out.println("Error");
                return;
            }
        }
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    //todo: implement hashcode and equals methods
}

class TestCase {
    public Node head;
    public Node expected;

    public TestCase(Node head, Node expected) {
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

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> symlinks = new HashMap<>();
        Node node = head;
        Node result = null;
        Node next = null;
        while (node != null) {
            int val = node.val;
            if (result == null) {
                result = symlinks.computeIfAbsent(node, (k)->new Node(val));
                next = result;
            } else {
                next.next = symlinks.computeIfAbsent(node, (k)->new Node(val));
                next = next.next;
            }

            if (node.random != null) {
                int randomVal = node.random.val;
                next.random = symlinks.computeIfAbsent(node.random, (k)->new Node(randomVal));
            }
                
            node = node.next;
        }

        return result;
    }
}
