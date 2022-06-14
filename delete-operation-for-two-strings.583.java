/* 
 * Used levenshtein distance without replacing characters
 * /
public class DeleteOperationForTwoStrings583 {
    public static void main(String[] args) {
        String word1 = "leetcode";
        String word2 = "etco";
        int excepted = 4;
        System.out.println("excepted: " + excepted + " actual: " 
                + new Solution().minDistance(word1, word2));
    }
}

class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] d0 = new int[n + 1];
        int[] d1 = new int[n + 1];

        for (int i = 1; i <= n; i++) d0[i] = i;

        for (int i = 0; i < m; i++) {
            d1[0] = i + 1;
            for (int j = 1; j <= n; j++) {
                d1[j] = word1.charAt(j-1) == word2.charAt(i) 
                    ? d0[j - 1] 
                    : Math.min(d1[j-1] + 1, d0[j] + 1);
            }
            System.arraycopy(d1, 0, d0, 0, n + 1);
        }
        return d1[n];
    }
}
