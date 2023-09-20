class Solution {
    public int minOperations(int[] nums, int x) {
        int op = Integer.MAX_VALUE;
        int base = 0;
        int rsum[] = new int[nums.length+1];
        for (int i = 1; i <= nums.length; i++) {            
            rsum[i] = rsum[i-1] + nums[nums.length - i];
        }

        for (int l = -1; l < nums.length; l++) {
            if (l >= 0) {
                base += nums[l];
            }
            if (base == x) {
                op = Math.min(op, l + 1);
                break;
            }

            int r = bs(rsum, x - base, rsum.length - 1 - (l + 1));
            if (r > -1) {
                op = Math.min(op, l + 1 + r);
            }
        }

        return op == Integer.MAX_VALUE ? -1 : op;
    }

    int bs(int[] sums, int t, int r) {
        int l = 0;

        while (l <= r) {
            int m = (l + r) / 2;

            if (sums[m] == t) return m;

            if (sums[m] > t) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
