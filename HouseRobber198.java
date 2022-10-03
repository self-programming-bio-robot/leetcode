class Solution {
    public int rob(int[] nums) {
        int[] res = new int[nums.length + 2];
        res[0] = 0;
        res[1] = 0;
        for (int i = 0; i < nums.length; i++) {
            res[i+2] = Math.max(res[i] + nums[i], res[i+1]);
        }
        return res[res.length-1];
    }
}
