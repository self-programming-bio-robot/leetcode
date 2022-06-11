class Solution {
    public int minOperations(int[] nums, int x) {
        int[] lsum = new int[nums.length];
        int[] rsum = new int[nums.length];
        int n = lsum.length - 1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            lsum[i] = i > 0 ? lsum[i - 1] + nums[i] : nums[i];
            rsum[i] = i > 0 ? rsum[i - 1] + nums[n - i] : nums[n - i];
            if ((lsum[i] == x || rsum[i] == x) && min > i) min = i+1;
        }
        
        for (int i = 0; i <= n && lsum[i] < x; i++) {
            int r = bs(rsum, x - lsum[i], 0, n);
            if (n - (r + i) > 1 && rsum[r] + lsum[i] == x && min > i + r + 2) {
                min = i + r + 2;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    private int bs(int[] nums, int x, int l, int r) {
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] < x) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return r;

    }
}
