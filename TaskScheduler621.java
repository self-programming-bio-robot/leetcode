class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        int[] lasts = new int[26];
        for (int i = 0; i < 26; i++) lasts[i] = -n-1;
        for (char c: tasks) {
            counts[c - 'A']++;
        }
        
        int pos = 0;
        boolean end = false;
        while (!end) {
            int best = -1;
            end = true;
            for (int i = 0; i < 26; i++) {
                if (counts[i] > 0) {
                    end = false;
                    if (lasts[i] < pos - n) {
                        best = (best == -1) ? i : ((counts[best] < counts[i]) ? i : best);
                    }
                }
            }
            
            if (end) break;
            
            if (best >= 0) {
                counts[best]--;
                lasts[best] = pos;
                // System.out.print(best + " ");
            } else {
                // System.out.print("X ");
            }
            pos++;
        }
        return pos;
    }
}
