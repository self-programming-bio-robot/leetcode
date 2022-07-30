import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Deque;

public class NTreePreorderTraversal589 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(
                    Node.of(1,null,3,2,4,null,5,6), 
                    List.of(1,3,5,6,2,4)
            ),
            new TestCase(
                    Node.of(1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,
                        null,null,11,null,12,null,13,null,null,14), 
                    List.of(1,2,3,6,7,11,14,4,8,12,5,9,13,10)
            ),
            new TestCase(
                    Node.of(), 
                    List.of()
            )
        };

        for (TestCase c: cases) {
            System.out.println(c);
            List<Integer> actual = new Solution().preorder(c.root);
            System.out.println("actual " + actual);
            if (!c.expected.equals(actual)) return;
        }
    }
}

class TestCase {
    public Node root;
    public List<Integer> expected;

    public TestCase(Node root, List<Integer> expected) {
        this.root = root;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        sb.append(root);
        sb.append("\n");
        sb.append("expected: ").append(expected);
        return sb.toString();
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Queue<Node> q = new LinkedList();
        q.add(this);
        sb.append(val).append(", null, ");
        while (!q.isEmpty()) {
            Node c = q.poll();
            if (c.children != null) {
                q.addAll(c.children);
                for (Node x: c.children) {
                    sb.append(x.val).append(", ");
                }
                sb.append("null, ");
            }
        }
        return sb.toString();
    }

    public static Node of(Integer... nums) {
        if (nums.length == 0) return null;
        Node root = new Node(nums[0]);
        Queue<Node> next = new LinkedList();
        next.add(root);
        int i = 2;
        while (i < nums.length) {
            List<Node> ch = new LinkedList();
            while (i < nums.length && nums[i] != null) {
                Node c = new Node(nums[i]);
                ch.add(c);
                next.add(c);
                i++;
            }
            i++;
            next.poll().children = ch;
        }
        return root;
    }
};

class Solution {
    public List<Integer> preorder(Node root) {
        if (root == null) return new LinkedList();
        Deque<Node> stack = new LinkedList();
        stack.add(root);
        List<Integer> res = new LinkedList();
        
        while (!stack.isEmpty()) {
            Node c = stack.poll();
            res.add(c.val);
            if (c.children != null) {
                for (int i = c.children.size() - 1; i >= 0; i--) {
                    stack.addFirst(c.children.get(i));
                }
            }
        }

        return res;
    }
}
