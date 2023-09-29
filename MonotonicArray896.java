class Solution {
    public boolean isMonotonic(int[] nums) {
        int dir = nums[nums.length - 1] - nums[0];
        for (int i = 1; i < nums.length; i++) {
            int dt = nums[i] - nums[i-1];
            if (dir == 0 && dt != 0 || dt != 0 && dir * dt < 0) {
                return false;
            }
        }

        return true;
    }
}
