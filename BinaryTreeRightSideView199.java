import java.util.List;
import java.util.LinkedList;
import java.util.Queue;


public class BinaryTreeRightSideView199 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(new TreeNode(1, 
                        new TreeNode(2, null, new TreeNode(5)),
                        new TreeNode(3, null, new TreeNode(4))
                    ), List.of(1,3,4)
            ),
            new TestCase(new TreeNode(1, 
                        new TreeNode(2, new TreeNode(4), null),
                        new TreeNode(3, null, null)
                    ), List.of(1,3,4)
            )
        };

        for (TestCase c: cases) {
            System.out.println(c);
            List<Integer> actual = new Solution().rightSideView(c.node);
            System.out.println("actual " + actual);
            if (!actual.equals(c.expected)) return;
        }
    }
}

class TestCase {
    public TreeNode node;
    public List<Integer> expected;

    public TestCase(TreeNode node, List<Integer> expected) {
        this.node = node;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        sb.append(node);
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList();
        if (root == null) return list;
        bfs(root, list);
        return list;
    }
    
    private void bfs(TreeNode node, List<Integer> result) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
                if (i == size - 1) {
                    result.add(cur.val);
                }
            }
        }
    }
}


