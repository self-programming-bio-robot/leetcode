public class BinaryTreeCameras968 {
    public static void main (String[] args) {
        TreeNode root = new TreeNode(0,
                    new TreeNode(0, 
                        new TreeNode(0,
                            new TreeNode(0,
                                null,
                                new TreeNode(0, null, null)),
                            null),
                        null),
                    null);

        System.out.println("expected: 2");
        System.out.println("actual: " + new Solution().minCameraCover(root));
    }
}

class TreeNode {
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
}

class Solution {
    public int minCameraCover(TreeNode root) {
        if (root.left == null && root.right == null) return 1;

        return dfs(root, null, null);        
    }

    private int dfs(TreeNode n, TreeNode p, TreeNode pp) {
        if (n == null) return 0;
        if (n.left == null && n.right == null) {
            if (p != null) p.val = 3;
            if (pp != null) pp.val = 1;
            return 0;
        }

        int res = dfs(n.left, n, p) + dfs(n.right, n, p);

        if (p != null) {
            int next = (n.val + 1) % 3;
            p.val = better(p.val, next);
            if (pp == null && p.val == 2) p.val = 0; 
        }
        if (pp != null) {
            int next = (n.val + 2) % 3;
            pp.val = better(pp.val, next);
        }
        return n.val % 3 == 0 ? res + 1 : res;
    }

    private int better(int a, int b) {
        return a == 3 ? 0 : a == 1 || b == 1 ? 1 : a == 2 || b == 2 ? 2 : 0;
    }
}
