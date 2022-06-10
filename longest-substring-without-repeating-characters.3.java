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
        for (int i = 0; i < s.length(); i++) {
            if (set.containsKey(s.charAt(i))) {
                int prevInd = set.get(s.charAt(i));
                int setLen = set.size();
                for (int j = i - setLen; j < prevInd; j++) {
                    set.remove(s.charAt(j));
                }
            } else {
                set.put(s.charAt(i), i);
                max = max < set.size() ? set.size() : max;
            }
        }

        return max;
    }
}
