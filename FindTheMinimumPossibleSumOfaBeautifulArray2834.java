class Solution {
    public long minimumPossibleSum(int n, int target) {
        long t = Math.min(target / 2, n);
        long t2 = target;
        long n2 = n - t;
        long firstpart = (2 + t - 1) * t / 2;
        long secondpart = (2 * t2 + n2 - 1) * n2 / 2;
        return firstpart + secondpart;
     }
}
