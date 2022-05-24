public class Problem32 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestValidParentheses("((())())("));
    }
}

class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        int rank = 0;
        int[] k = new int[s.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) == ')') {
                if (rank > 0) {
                    rank--;
                    k[i] = k[i-1] + 2;
                    if (i - k[i] > 0)
                        k[i] += k[i - k[i]];

                    max = max < k[i] ? k[i] : max;
                }
            } else {
                rank++;
            }
        }

        return max;
    }
}
