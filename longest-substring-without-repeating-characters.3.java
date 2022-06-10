import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters3 {
    public static void main(String[] args) {
        int actual = new Solution().lengthOfLongestSubstring("pwwkew");
        System.out.println("actual: " + actual + " expected: 3");
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> set = new HashMap<>();

        int max = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.containsKey(s.charAt(i))) {
                end = Math.max(set.get(s.charAt(i)) + 1, end);
                set.put(s.charAt(i), i); 
            } else {
                set.put(s.charAt(i), i);
            }
            max = Math.max(max, i - end + 1);
        }

        return max;
    }
}
