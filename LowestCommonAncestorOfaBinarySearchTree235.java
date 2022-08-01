import java.util.Queue;
import java.util.LinkedList;

public class LowestCommonAncestorOfaBinarySearchTree235 {
    public static void main(String[] args) {
        TreeNode b = new TreeNode(4,
                        new TreeNode(3),
                        new TreeNode(5)
                    );

        TreeNode a = new TreeNode(2,
                        new TreeNode(0),
                        b
                    );
        
        TestCase[] cases = new TestCase[] {
            new TestCase(
                new TreeNode(6,
                    a,
                    new TreeNode(8,
                        new TreeNode(7),
                        new TreeNode(9)
                    )
                ),
                a,
                b,
                a
            )
        };

        for (TestCase c: cases) {
            System.out.println(c);
            TreeNode actual = new Solution().lowestCommonAncestor(c.root, c.a, c.b);
            System.out.println("actual " + actual);
            if (actual != c.expected) return;
        }
    }
}

class TestCase {
    public TreeNode root;
    public TreeNode a;
    public TreeNode b;
    public TreeNode expected;

    public TestCase(TreeNode root, TreeNode a, TreeNode b, TreeNode expected) {
        this.root = root;
        this.a = a;
        this.b = b;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        sb.append(root).append(" ");
        sb.append(a.val).append(" ");
        sb.append(b.val);
        sb.append("\n");
        sb.append("expected: ").append(expected.val);
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
