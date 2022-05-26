public class NumberOf1Bits191 {
    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(-3));
    }
}

public class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        long ln = ((1L << 32)-1) & n;
        while (ln != 0) {
            res += ln & 1;
            ln = ln >> 1;           
        }
        return res;
    }
}
