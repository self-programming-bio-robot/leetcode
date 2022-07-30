import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class BinaryTreeLevelOrderTraversal102 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(
                new TreeNode(3,
                    new TreeNode(9),
                    new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)
                    )
                ),
                List.of(List.of(3), List.of(9, 20), List.of(15, 7))
            ),
            new TestCase(new TreeNode(1), List.of(List.of(1))),
            new TestCase(null, List.of())
        };

        for (TestCase c: cases) {
            System.out.println(c);
            List<List<Integer>> actual = new Solution().levelOrder(c.root);
            System.out.println("actual " + actual);
            if (!c.expected.equals(actual)) return;
        }
    }
}

class TestCase {
    public TreeNode root;
    public List<List<Integer>> expected;

    public TestCase(TreeNode root, List<List<Integer>> expected) {
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

public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }

     @Override
     public String toString() {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(this);
        StringBuilder sb = new StringBuilder();
        int lev = 0;
        int buf = 0;
        sb.append("[");
        while (!queue.isEmpty()) {
            buf = queue.size();
            for (int i = 0; i < buf; i++) {
                TreeNode cur = queue.poll();
                sb.append(cur == null ? "null" : cur.val).append(",");
                if (cur != null) {
                    queue.add(cur.left);
                    queue.add(cur.right);
                }
            }
        }
        sb.append("]");
        return sb.toString();
     }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new LinkedList();

        List<TreeNode> level = new LinkedList();
        level.add(root);

        List<List<Integer>> res = new LinkedList();

        while (!level.isEmpty()) {
            res.add(level.stream().map(it -> it.val).collect(Collectors.toList()));
            List<TreeNode> next = new LinkedList();
            for (TreeNode x: level) {
                if (x.left != null) next.add(x.left);
                if (x.right != null) next.add(x.right);
            }
            level = next;
        }

        return res;
    }
}
