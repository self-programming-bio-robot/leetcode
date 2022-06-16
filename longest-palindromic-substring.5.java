public class LongestPalindromicSubstring5  {
    public static void main (String[] args) {
        //String text = "babad"; // bab
        String text = "cbbd"; // bb
        System.out.println("expected: bb");
        System.out.println("actual: " + new Solution().longestPalindrome(text));
    }
}

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 1; i - j >= 0 && i + j < n; j++) {
                if (s.charAt(i - j) != s.charAt(i + j)) break;
                max = j;
            }
            if (res.length() < max * 2 + 1) {
                res = s.substring(i - max, i + max + 1);
            }
            
            max = 0;
            for (int j = 1; i - j >= 0 && i + j - 1 < n; j++) {
                if (s.charAt(i - j) != s.charAt(i + j - 1)) break;
                max = j;
            }
            if (res.length() < max * 2) {
                res = s.substring(i - max, i + max);
            }
        }
        return res;
    }
}
