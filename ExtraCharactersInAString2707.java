class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int[] dp = new int[s.length()+1];

        List<int[]> found = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            dp[i+1] = dp[i]+1;
            for (int j = 0; j < dictionary.length; j++) {
                String d = dictionary[j];
                if (c == d.charAt(0)) {
                    found.add(new int[] {i, j});
                }
            }
            Iterator<int[]> it = found.iterator();
            while (it.hasNext()) {
                int[] cur = it.next();
                int local = i - cur[0];
                if (local == dictionary[cur[1]].length() 
                    || dictionary[cur[1]].charAt(local) != c) {
                    it.remove();
                }
                if (local == dictionary[cur[1]].length()-1 
                    && dictionary[cur[1]].charAt(local) == c) {
                    dp[i + 1] = Math.min(dp[i + 1], dp[cur[0]]);
                }
            }
        }
        return dp[s.length()];
    }
}
