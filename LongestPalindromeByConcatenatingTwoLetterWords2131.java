class Solution {
    public int longestPalindrome(String[] words) {
        int[] set = new int[2526];
        int res = 0;
        
        for (String s: words) {
            int straight = (s.charAt(0) - 'a') * 100 + (s.charAt(1) - 'a');
            int reverse = (s.charAt(1) - 'a') * 100 + (s.charAt(0) - 'a');
            
            if (set[reverse] > 0) {
                res += 4;
                set[reverse]--;
            } else {
                set[straight]++;
            }
        }
        
        for (int i = 0; i < 26; i++) {
            if (set[i*100+i] > 0) {
                res += 2;
                break;
            }
        }
        
        return res;
    }
}
