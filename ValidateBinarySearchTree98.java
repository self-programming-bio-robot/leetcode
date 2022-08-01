import java.util.Queue;
import java.util.LinkedList;

public class ValidateBinarySearchTree98 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(
                    new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)
                    ),
                    true
            ),
            new TestCase(
                    new TreeNode(5,
                        new TreeNode(1),
                        new TreeNode(4,
                            new TreeNode(3),
                            new TreeNode(6)
                        )
                    ),
                    false
            ),            
            new TestCase(
                    new TreeNode(5,
                        new TreeNode(4),
                        new TreeNode(6,
                            new TreeNode(3),
                            new TreeNode(7)
                        )
                    ),
                    false
            )            
        };

        for (TestCase c: cases) {
            System.out.println(c);
            boolean actual = new Solution().isValidBST(c.root);
            System.out.println("actual " + actual);
            if (actual != c.expected) return;
        }
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

class TestCase {
    public TreeNode root;
    public boolean expected;

    public TestCase(TreeNode root, boolean expected) {
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

class Solution {
    private boolean result = true;

    public boolean isValidBST(TreeNode root) {
        Result res = check(root);
        return res.correct;
    }

    private Result check(TreeNode root) {
        if (root == null) return null;
        Result res = new Result(root.val, root.val, true);

        Result l = check(root.left);
        Result r = check(root.right);

        if (l != null) {
            res.correct &= l.correct && l.max < root.val;
            res.min = l.min;
        }

        if (r != null) {
            res.correct &= r.correct && r.min > root.val;
            res.max = r.max;
        }

        return res;
    }
}

class Result {
    public int min;
    public int max;
    public boolean correct;

    public Result(int min, int max, boolean correct) {
        this.min = min;
        this.max = max;
        this.correct = correct;
    }
}
