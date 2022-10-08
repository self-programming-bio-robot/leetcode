class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList();
        int used = (1 << nums.length) - 1;
        dfs(res, new LinkedList(), used, nums);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> cur, int used, int[] nums) {
        if (used == 0) {
            res.add(new LinkedList(cur));
            return;
        }
        for (int d = 0; d < nums.length; d++) {
            if ((used & (1 << d)) > 0) {
                cur.add(nums[d]);
                dfs(res, cur, used & (~(1 << d)), nums);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
