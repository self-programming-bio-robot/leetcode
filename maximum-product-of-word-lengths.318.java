public class MaximumProductOfWordLengths318 {
    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct(new String[] {"abcw","baz","foo","bar","xtfn","abcdef" }));
    }
}

class Solution {
    public int maxProduct(String[] words) {
        int[] hash = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                hash[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        int max = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((hash[i] & hash[j]) == 0 
                        && max < words[i].length() * words[j].length()) {
                    max = words[i].length() * words[j].length();
                }
            }
        }
        return max;
    }
}
