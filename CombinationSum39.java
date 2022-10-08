class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList();
        dfs(res, new LinkedList(), target, candidates, 0);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> cur, int sum, int[] nums, int s) {
        if (sum <= 0) {
            if (sum == 0)
                res.add(new LinkedList(cur));
            return;
        }
        for (int d = s; d < nums.length; d++) {
            cur.add(nums[d]);
            dfs(res, cur, sum - nums[d], nums, d);
            cur.remove(cur.size() - 1);
        }
    }
}
