class Solution {
    public String longestCommonPrefix(String[] strs) {
        int i = 0;
        String first = strs[0];
        StringBuilder sb = new StringBuilder();
        
        while (first.length() > i) {
            char c = first.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                String s = strs[j];
                if (s.length() <= i || s.charAt(i) != c) {
                    return sb.toString();
                }
            }
            sb.append(first.charAt(i));
            i++;
        }
        return first;
    }
}
