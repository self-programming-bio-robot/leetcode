public class NQueensII51 {
    public static void main(String[] args) {
        int excepted = 352;
        System.out.println("Excepted:");
        System.out.println(excepted);
        System.out.println("Actual:");
        System.out.println(new Solution().totalNQueens(9));
    }
}

class Solution {
    public int totalNQueens(int n) {
        if (n == 1) return 1;
        if (n < 4) return 0;

        int line = 0;
        int rdiag = 0;
        int ldiag = 0;
        return lookForSolving(0, line, rdiag, ldiag, n);
    }

    private int lookForSolving(int j, int l, int rd, int ld, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (((l | rd | ld) & (1 << i)) == 0) {
                if (j == n - 1) {
                    return 1;
                } else {
                    int nl = l | (1 << i) ;

                    int nrd = ((rd << 1) | (1 << (i + 1))) & 1023;
                    int nld = ((ld >> 1) | (i > 0 ? 1 << (i - 1) : 0)) & 1023;
                    sum += lookForSolving(j + 1, nl, nrd, nld, n);
                }
            }
        }
        return sum;
    }
}
