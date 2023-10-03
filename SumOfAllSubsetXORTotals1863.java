class Solution {
    public int subsetXORSum(int[] nums) {
        return dp(nums, 0, 0);
    }

    private int dp(int[] nums, int st, int total) {
        if (st == nums.length) {
            return total;
        }
        int sum = total;
        for (int i = st; i < nums.length; i++) {
            sum += dp(nums, i+1, total ^ nums[i]);
        }
        return sum;
    }
}
